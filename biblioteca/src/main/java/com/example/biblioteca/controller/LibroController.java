package com.example.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblioteca.model.LibroModel;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<LibroModel> getLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    public LibroModel agregarLibro (@RequestBody LibroModel libro){
        return libroService.saveLibro(libro);
    }

    @GetMapping("{id}")
    public LibroModel getLibroPorId(@PathVariable int id){
        return libroService.getLibroId(id);
    }

    @PutMapping("{id}")
    public LibroModel actualizarLibro(@PathVariable int id, @RequestBody LibroModel libro){
        return libroService.saveLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id){
        return libroService.eliminarLibro(id);
    }

    @GetMapping("total")
    public int getTotalLibros() {
        return libroService.totalLibros();
    }

    @GetMapping("{isbn}")
    public LibroModel obtenerLibroPorIsbn(@RequestParam String isbn) {
        return libroService.obtenerLibroPorIsbn(isbn);
    }

    @GetMapping("{anio}")
    public List<LibroModel> obtenerLibroPorAnio(@RequestParam int anio) {
        return libroService.obtenerLibrosPorAnio(anio);
    }

    @GetMapping("{libroporautor}")
    public List<LibroModel> getLibrosPorAutor(@RequestParam String libroporautor) {
        return libroService.obtenerLibrosPorAutor(libroporautor);
    }
    
    @GetMapping("LibroMasAntiguo")
    public LibroModel obtenerLibroMasAntiguo() {
        return libroService.obtenerLibroMasAntiguo();
    }
    
    
    
    
}
