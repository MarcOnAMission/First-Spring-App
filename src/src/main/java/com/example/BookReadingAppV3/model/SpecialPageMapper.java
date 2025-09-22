package com.example.BookReadingAppV3.model;

import com.example.BookReadingAppV3.repositories.BookRepository;

import java.util.Optional;

public class SpecialPageMapper {
    public SpecialPageDTO toDto(SpecialPage specialPage){
        return new SpecialPageDTO(specialPage.getQuote(), specialPage.getPageNumber(), specialPage.getBook().getTitle());
    }
    public SpecialPage toEntity(SpecialPageDTO dto,Book book ){
        SpecialPage page = new SpecialPage();
        page.setBook(book);
        page.setQuote(dto.getQuote());
        page.setPageNumber(dto.getPageNumber());
        return page;
    }
}
