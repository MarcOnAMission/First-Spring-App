package com.example.BookReadingAppV3.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpecialPageDTO{
    @NotBlank(message = "Quote cannot be blank.")
    @Size(min = 1,max = 255,message = "Quote has to be between 1-255 characters.")
    private String quote;
    @NotNull(message= "Page number cannot be blank")
    @Min(value =1,message = "Page number cannot be lower than 1")
    private Long pageNumber;
    @NotBlank(message = "Book title cannot be blank.")
    private String title;
}
