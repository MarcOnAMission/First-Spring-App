package com.example.BookReadingAppV3;

import com.example.BookReadingAppV3.model.Book;
import com.example.BookReadingAppV3.model.BookDTO;
import com.example.BookReadingAppV3.repositories.BookRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookTest {

    @Mock
    private BookRepository bookRepo;

    private Book testBook;
    private BookDTO testDto;

    @BeforeEach
    public void setUp(){
        testBook = new Book();
        testBook.setId(1L);
        testBook.setTitle("Deep work");
        testBook.setAuthor("Cal Newport");
        testBook.setNumberOfPages(190);
        testBook.setPublication("MIT");

        testDto = new BookDTO();
        testDto.setTitle("Deep work");
        testDto.setAuthor("Cal Newport");
        testDto.setNumberOfPages(190);
        testDto.setPublication("MIT");
    }
    @Test
    void save_ReturnBookAfterSave(){
        Book savedBook = bookRepo.save(testBook);
        assertNotNull(savedBook);
        assertEquals(savedBook.getTitle(),testBook.getTitle());
        verify(bookRepo).save(testBook);
    }
}
