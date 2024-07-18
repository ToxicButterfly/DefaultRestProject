package com.example.defaultrestproject.service;

import com.example.defaultrestproject.DTO.BookDTO;
import com.example.defaultrestproject.DTO.BookDTOResponse;

import java.util.List;

public interface BookService {
    List<BookDTOResponse> findAllBooks();

    BookDTOResponse findBookById(Integer id);

    BookDTOResponse saveBook(BookDTO book);

    BookDTOResponse saveBookOrUpdate(Integer id, BookDTO book);

    BookDTOResponse deleteBookById(Integer id);

}
