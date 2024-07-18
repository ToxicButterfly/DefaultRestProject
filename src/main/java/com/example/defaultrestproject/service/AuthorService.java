package com.example.defaultrestproject.service;

import com.example.defaultrestproject.DTO.AuthorDTO;
import com.example.defaultrestproject.DTO.AuthorDTOResponse;
import com.example.defaultrestproject.model.Author;

import java.util.List;

public interface AuthorService {
    List<AuthorDTOResponse> findAllAuthors();

    AuthorDTOResponse findAuthorById(Integer id);

    AuthorDTO saveAuthor(Author author);

    AuthorDTO saveAuthorOrUpdate(Integer id, Author author);

    AuthorDTOResponse deleteAuthorById(Integer id);
}
