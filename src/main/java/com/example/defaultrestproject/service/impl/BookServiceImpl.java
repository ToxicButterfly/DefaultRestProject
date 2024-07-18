package com.example.defaultrestproject.service.impl;

import com.example.defaultrestproject.DTO.BookDTO;
import com.example.defaultrestproject.DTO.BookDTOResponse;
import com.example.defaultrestproject.convert.DTOConverter;
import com.example.defaultrestproject.model.Author;
import com.example.defaultrestproject.model.Book;
import com.example.defaultrestproject.repo.AuthorRepo;
import com.example.defaultrestproject.repo.BookRepo;
import com.example.defaultrestproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final DTOConverter dtoConverter;

    @Override
    public List<BookDTOResponse> findAllBooks() {
        return bookRepo.findAll().stream().map(dtoConverter::booktoBookDTOResponse).toList();
    }

    @Override
    public BookDTOResponse findBookById(Integer id) {
        Optional<Book> book = bookRepo.findById(id);
        if (book.isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        }
        return dtoConverter.booktoBookDTOResponse(book.get());
    }

    @Override
    public BookDTOResponse saveBook(BookDTO bookDTO) {
        Optional<Author> author = authorRepo.findById(bookDTO.getAuthorId());
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author not found");
        }
        Book book = Book.builder()
                .author(author.get())
                .title(bookDTO.getTitle())
                .genre(bookDTO.getGenre())
                .build();
        return dtoConverter.booktoBookDTOResponse(bookRepo.save(book));
    }

    @Override
    public BookDTOResponse saveBookOrUpdate(Integer id, BookDTO bookDTO) {
        Book book = bookRepo.findById(id).orElse(new Book());
        Optional<Author> author = authorRepo.findById(bookDTO.getAuthorId());
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author not found");
        }
        book.setTitle(bookDTO.getTitle());
        book.setGenre(bookDTO.getGenre());
        book.setAuthor(author.get());
        return dtoConverter.booktoBookDTOResponse(bookRepo.save(book));
    }

    @Override
    public BookDTOResponse deleteBookById(Integer id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if (optionalBook.isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        }
        bookRepo.deleteById(id);
        return dtoConverter.booktoBookDTOResponse(optionalBook.get());
    }
}
