package com.example.BookReadingAppV3.controller;

import com.example.BookReadingAppV3.model.*;
import com.example.BookReadingAppV3.service.BookService;
import com.example.BookReadingAppV3.service.SpecialPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookReaderApp")
public class Controller {
    @Autowired
    private BookService bookService;
    @Autowired
    private SpecialPageService pageService;

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody BookDTO bookDTO) {
        BookMapper mapper = new BookMapper();
        return ResponseEntity.ok(bookService.saveBook(BookMapper.toEntity(bookDTO)));
    }

    @PostMapping("/specialpage/{title}")
    public ResponseEntity<SpecialPage> savePage(@PathVariable String title, @RequestBody SpecialPageDTO pageDTO) {
        SpecialPageMapper pageMapper = new SpecialPageMapper();
        return ResponseEntity.ok(pageService.savePage(title, pageMapper.toEntity(pageDTO,bookService.findByTitle(title).orElseThrow(()->new RuntimeException("Book not found.")))));
    }
    @PostMapping("/specialpagenodto/{title}")
    public ResponseEntity<SpecialPage> savePage(@PathVariable String title, @RequestBody SpecialPage pageDTO){
        return ResponseEntity.ok(pageService.savePage(title,pageDTO));
    }

    @GetMapping("/getpages")
    public ResponseEntity<Iterable<SpecialPage>> getAllPages() {
        return ResponseEntity.ok(pageService.getAll());
    }

    @GetMapping("/getbooks")
    public ResponseEntity<Iterable<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookByID(id));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Optional<Book>> findByTitle(@PathVariable String title) {
        return ResponseEntity.ok(bookService.findByTitle(title));
    }

    @GetMapping("/{title}/specialpages")
    public ResponseEntity<List<SpecialPage>> getPagesByTitle(@PathVariable String title) {
        return ResponseEntity.ok(pageService.findByBook_Title(title));
    }

    @GetMapping("/title/number/{title}/{number}")
    public ResponseEntity<Optional<SpecialPage>> findPageByTitleAndNumber(@PathVariable String title, @PathVariable Long number) {
        return ResponseEntity.ok(pageService.findByBook_TitleAndPageNumber(title, number));
    }

    @DeleteMapping("/deletebook/id/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/deletepage/id/{id}")
    public ResponseEntity<Void> deletePageById(@PathVariable Long id){
        pageService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/deletepage/id/title/{id}/{title}")
    public ResponseEntity<Void> deletePageByIdAndTitle(@PathVariable Long id,@PathVariable String title){
        pageService.deleteByBook_TitleAndId(title,id);
        return ResponseEntity.noContent().build();
    }
}
