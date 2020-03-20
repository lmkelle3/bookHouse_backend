package com.bookhouse.bookHouse.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> getAllBooks() {
        return this.booksRepository.findAll();
    }

    public Optional<Book> getOneBook(int id) {
        return booksRepository.findById(id);
    }

    public Book addOneBook(Book newBook) {
        return booksRepository.save(newBook);
    }

    public Book updateOneBook(Book updatedBook) {
        return booksRepository.save(updatedBook);
    }

    public String removeOneBook(int id) {
        booksRepository.deleteById(id);
        return "Id " + id + " was removed";
    }
}
