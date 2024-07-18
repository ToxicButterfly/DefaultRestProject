package com.example.defaultrestproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTOResponse {
    private Integer id;
    private String name;
    private String email;
    private List<BookDTO> books;
}
