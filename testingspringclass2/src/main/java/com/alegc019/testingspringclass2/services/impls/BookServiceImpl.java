package com.alegc019.testingspringclass2.services.impls;

import com.alegc019.testingspringclass2.domain.dtos.SaveBookDTO;
import com.alegc019.testingspringclass2.domain.entities.Book;
import com.alegc019.testingspringclass2.services.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public final static List<Book> books = new ArrayList<>();
    static{
        books.add(new Book("978-0-306-40615-7   ", "The Art of Computer Programming"));
        books.add(new Book("978-0-13-110362-7   ", "Introduction to the Theory of Computation"));
        books.add(new Book("978-0-262-03384-8   ", "Introduction to Algorithms"));
    }

    @Override
    public void save(SaveBookDTO info) {

        Book book = books.stream()
                .filter(b -> b.getISBN().equals(info.getISBN()))
                .findAny()
                .orElse(null);

        if(book == null){
            book = new Book();
            book.setISBN(info.getISBN());
            books.add(book);
        }

        book.setTitle(info.getTitle());


    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findByIsbn(String isbn) {
        return books.stream()
                .filter(b -> b.getISBN().equals(isbn))
                .findAny().orElse(null);
    }

    @Override
    public void deleteByIsbn(String isbn) {


    }
}
