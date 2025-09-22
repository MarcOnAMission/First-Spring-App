package com.example.BookReadingAppV3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "special_pages")
public class SpecialPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quote;
    private Long pageNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id" , nullable = false)
    @JsonIgnore
    private Book book;
}
