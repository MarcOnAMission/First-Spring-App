package com.example.BookReadingAppV3.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO{
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    String title;
    @NotBlank(message = "Author cannot be blank")
    @Size(min = 1, max = 255, message = "Author must be between 1 and 255 characters")
    String author;
    @Min(value = 1,message = "Page number cannot be lower than 1.")
    int numberOfPages;
    @NotBlank(message = "Publication cannot be blank")
    @Size(min = 1, max = 255, message = "Publication must be between 1 and 255 characters")
    String publication;
}
