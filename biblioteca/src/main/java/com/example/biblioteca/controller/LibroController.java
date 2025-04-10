package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.LibroService;

@RestController
@RequestMapping("api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<LibroModel> getLibros(){
        return libroService.getLibros();
    }
}
