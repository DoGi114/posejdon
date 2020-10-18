package com.damiannguyen.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {
    @Autowired
    private BooksRepository booksRepository;
//    private static final List<BooksEntity> BOOKS_ENTITIES = List.of(
//            new BooksEntity().setId(1L).setTitle("Lorem 1").setAuthor("Author 1"),
//            new BooksEntity().setId(1L).setTitle("Lorem 2").setAuthor("Author 2"),
//            new BooksEntity().setId(1L).setTitle("Lorem 3").setAuthor("Author 3")
//    );

    @GetMapping(value = "/rest/books/{id}")
    public BooksEntity getBook(@PathVariable("id") Long id){
        return booksRepository.findById(id).get();
//        return BOOKS_ENTITIES.stream().filter(book -> book.getId().equals(id)).findFirst().get();
    }

    @GetMapping("/rest/books")
    public List<BooksEntity> getBooks(){
//        return BOOKS_ENTITIES;
        return booksRepository.findAll();
    }

    @PostMapping("/rest/books")
    public BooksEntity newBooks(@RequestBody BooksEntity booksEntity){
        return booksRepository.saveAndFlush(booksEntity);
    }

    @DeleteMapping("/rest/books/{id}")
    public void deleteBook(@PathVariable("id") Long id){
        booksRepository.delete(getBook(id));
    }

    @PutMapping("/rest/books/{id}")
    public BooksEntity updateBook(@PathVariable("id") Long id, @RequestBody BooksEntity booksEntity){
        return booksRepository.saveAndFlush(booksEntity.setId(id));
    }
}
