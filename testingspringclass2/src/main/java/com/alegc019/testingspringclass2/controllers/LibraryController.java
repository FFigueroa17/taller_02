package com.alegc019.testingspringclass2.controllers;

import com.alegc019.testingspringclass2.domain.dtos.SaveBookDTO;
import com.alegc019.testingspringclass2.domain.entities.Book;
import com.alegc019.testingspringclass2.services.BookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/library")
@Slf4j
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping("/alls")
    public String getAllBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "book-list";
    }

    @GetMapping("/rest")
    public String mainRest(Model model){
        model.addAttribute("books", bookService.findAll());
        return "rest-library";
    }

    @GetMapping("/")
    public String getSaveForm(){
        return "save-book";
    }

    @PostMapping("/save")
    public String saveBook(@Valid SaveBookDTO info, BindingResult result){
        if(result.hasErrors()){
            log.error("Error saving book: {}", result.getAllErrors());
            return "the-error";
        }

        bookService.save(info);

        return "redirect:/library/alls";
    }




}
