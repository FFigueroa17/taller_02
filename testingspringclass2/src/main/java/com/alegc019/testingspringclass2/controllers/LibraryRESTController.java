package com.alegc019.testingspringclass2.controllers;

import com.alegc019.testingspringclass2.domain.dtos.SaveBookDTO;
import com.alegc019.testingspringclass2.domain.entities.Book;
import com.alegc019.testingspringclass2.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryRESTController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> findall(){

        List<Book> books = new ArrayList<>();
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    //Save book
    public ResponseEntity<String> saveBook(@RequestBody @Valid SaveBookDTO info, BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //TODO Sava Book

        bookService.save(info);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable String isbn){

        Book book = bookService.findByIsbn(isbn);

        if(book == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //TODO Delete book
        bookService.deleteByIsbn(isbn);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
