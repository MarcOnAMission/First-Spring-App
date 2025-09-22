package com.example.BookReadingAppV3.model;

public class BookMapper {
    public BookDTO toDTO(Book book){
        return new BookDTO(book.getTitle(),
                book.getAuthor(),
                book.getNumberOfPages(),
                book.getPublication());
    }
    public static Book toEntity(BookDTO dto){
        Book localBook = new Book();
        localBook.setAuthor(dto.getAuthor());
        localBook.setTitle(dto.getTitle());
        localBook.setPublication(dto.getPublication());
        localBook.setNumberOfPages(dto.getNumberOfPages());
        return localBook;
    }
}
