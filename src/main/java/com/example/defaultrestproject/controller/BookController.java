package com.example.defaultrestproject.controller;
import com.example.defaultrestproject.DTO.BookDTO;
import com.example.defaultrestproject.DTO.BookDTOResponse;
import com.example.defaultrestproject.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTOResponse>> getAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTOResponse> getBookById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @PostMapping
    public ResponseEntity<BookDTOResponse> createBook(@RequestBody BookDTO book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTOResponse> updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.saveBookOrUpdate(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTOResponse> deleteBook(@PathVariable Integer id) {
        return ResponseEntity.ok(bookService.deleteBookById(id));
    }
}