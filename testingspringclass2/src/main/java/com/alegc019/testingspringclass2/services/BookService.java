package com.alegc019.testingspringclass2.services;

import com.alegc019.testingspringclass2.domain.dtos.SaveBookDTO;
import com.alegc019.testingspringclass2.domain.entities.Book;

import java.util.List;


public interface BookService {
    void save(SaveBookDTO info);


    List<Book> findAll();

    Book findByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
