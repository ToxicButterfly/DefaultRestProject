package com.example.defaultrestproject.convert;

import com.example.defaultrestproject.DTO.AuthorDTOResponse;
import com.example.defaultrestproject.DTO.BookDTO;
import com.example.defaultrestproject.DTO.BookDTOResponse;
import com.example.defaultrestproject.model.Author;
import com.example.defaultrestproject.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DTOConverter {

    private final ModelMapper modelMapper;
    public DTOConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public BookDTO BooktoBookDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public BookDTOResponse booktoBookDTOResponse(Book book) {
        return modelMapper.map(book, BookDTOResponse.class);
    }

    public AuthorDTOResponse convertAuthorToAuthorDTOResponse(Author author) {
        return modelMapper.map(author, AuthorDTOResponse.class);
    }

    public Book BookDTOToBook(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

}
