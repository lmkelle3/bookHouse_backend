package com.bookhouse.bookHouse.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable int id) {
        Book book = booksService.getOneBook(id).orElseThrow(IllegalArgumentException::new);
        return book;
    }

    @PostMapping
    public Book addOneBook(@RequestBody Book newBook) {
//        if(newBook.getEmail() == null || newBook.getName() == null) {
//            throw new IllegalArgumentException("Not all fields are valid. Go back and make sure all fields are valid " +
//                    "before API call is made.");
//        }
        return booksService.addOneBook(newBook);
    }

    @PatchMapping
    public Book updateOneBook(@RequestBody Book updatedBook) {
        Book book = booksService.getOneBook(updatedBook.getId()).orElseThrow(IllegalArgumentException::new);
        return booksService.updateOneBook(updatedBook);
    }

    @DeleteMapping("/{id}")
    public String removeOneBook(@PathVariable int id) {
        Book book = booksService.getOneBook(id).orElseThrow(IllegalArgumentException::new);
        return booksService.removeOneBook(id);
    }
}