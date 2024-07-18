package com.example.defaultrestproject.service.impl;

import com.example.defaultrestproject.DTO.AuthorDTO;
import com.example.defaultrestproject.DTO.AuthorDTOResponse;
import com.example.defaultrestproject.DTO.BookDTO;
import com.example.defaultrestproject.convert.DTOConverter;
import com.example.defaultrestproject.model.Author;
import com.example.defaultrestproject.repo.AuthorRepo;
import com.example.defaultrestproject.repo.BookRepo;
import com.example.defaultrestproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final ModelMapper modelMapper;
    private final DTOConverter dtoConverter;

    @Override
    public List<AuthorDTOResponse> findAllAuthors() {
        List<Author> authors = authorRepo.findAll();
        return authors.stream()
                .map(this::convertAuthorToAuthorDTOResponse)
                .toList();
    }
    private AuthorDTOResponse convertAuthorToAuthorDTOResponse(Author author) {
        List<BookDTO> bookDTOList = author.getBooks().stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .collect(Collectors.toList());

        return AuthorDTOResponse.builder()
                .id(author.getId())
                .name(author.getName())
                .email(author.getEmail())
                .books(bookDTOList)
                .build();
    }


    @Override
    public AuthorDTOResponse findAuthorById(Integer id) {
        Optional<Author> author = authorRepo.findById(id);
        if (author.isPresent()) {
            return convertAuthorToAuthorDTOResponse(author.get());
        } else {
            throw new IllegalArgumentException("Author not found with id " + id);
        }
    }

    @Override
    public AuthorDTO saveAuthor(Author author) {
        Author savedAuthor = authorRepo.save(author);
        return AuthorDTO.builder()
                .email(savedAuthor.getEmail())
                .name(savedAuthor.getName())
                .id(savedAuthor.getId())
                .build();
    }

    @Override
    public AuthorDTO saveAuthorOrUpdate(Integer id, Author author) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        optionalAuthor.ifPresent(value -> author.setId(value.getId()));
        Author savedAuthor = authorRepo.save(author);
        return AuthorDTO.builder()
                .email(savedAuthor.getEmail())
                .name(savedAuthor.getName())
                .id(savedAuthor.getId())
                .build();
    }

    @Override
    public AuthorDTOResponse deleteAuthorById(Integer id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if (optionalAuthor.isEmpty()) {
            throw new IllegalArgumentException("Author not found");
        }
        if (!optionalAuthor.get().getBooks().isEmpty()) {
            System.out.println("Books almost deleted");
            bookRepo.deleteAll(optionalAuthor.get().getBooks());
            System.out.println("Books deleted");
        }

        authorRepo.deleteById(id);

        System.out.println("Author deleted!");

        return convertAuthorToAuthorDTOResponse(optionalAuthor.get());
    }
}
