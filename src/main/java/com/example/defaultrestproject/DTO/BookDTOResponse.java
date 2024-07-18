package com.example.defaultrestproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTOResponse {
    private Integer id;
    private String title;
    private String genre;
    private AuthorDTO author;
}
