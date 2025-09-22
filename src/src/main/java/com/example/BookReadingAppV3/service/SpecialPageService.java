package com.example.BookReadingAppV3.service;

import com.example.BookReadingAppV3.model.Book;
import com.example.BookReadingAppV3.model.SpecialPage;
import com.example.BookReadingAppV3.repositories.BookRepository;
import com.example.BookReadingAppV3.repositories.SpecialPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecialPageService {
    @Autowired
    private SpecialPageRepository specialPageRepository;
    @Autowired
    private BookRepository bookRepository;
    public SpecialPage savePage(String bookTitle, SpecialPage specialPage){
        Book maybeBook = bookRepository.findByTitle(bookTitle).orElseThrow(() -> new RuntimeException("Book not found."));
        specialPage.setBook(maybeBook);
        return specialPageRepository.save(specialPage);
    }
    public Iterable<SpecialPage> getAll(){
        return specialPageRepository.findAll();
    }
    public void deleteByBook_TitleAndId(String title,Long id){
        specialPageRepository.deleteByBook_TitleAndId(title,id);
    }
    public void deleteById(Long id){
        specialPageRepository.deleteById(id);
    }

    public Optional<SpecialPage> findByBook_TitleAndPageNumber(String title, Long pageNumber) {
        return specialPageRepository.findByBook_TitleAndPageNumber(title,pageNumber);
     }
    public List<SpecialPage> findByBook_Title(String title){
        Book maybeBook = bookRepository.findByTitle(title).orElseThrow(() -> new RuntimeException("Book not found."));
        return specialPageRepository.findByBook_Title(title);
     }

}
