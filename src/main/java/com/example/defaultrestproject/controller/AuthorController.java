package com.example.defaultrestproject.controller;

import com.example.defaultrestproject.DTO.AuthorDTO;
import com.example.defaultrestproject.DTO.AuthorDTOResponse;
import com.example.defaultrestproject.model.Author;
import com.example.defaultrestproject.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDTOResponse>> getAllAuthors() {
        return ResponseEntity.ok(authorService.findAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTOResponse> getAuthorById(@PathVariable Integer id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody Author author) {
        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Integer id, @RequestBody Author author) {
        return ResponseEntity.ok(authorService.saveAuthorOrUpdate(id, author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AuthorDTOResponse> deleteAuthor(@PathVariable Integer id) {
        return ResponseEntity.ok(authorService.deleteAuthorById(id));
    }
}