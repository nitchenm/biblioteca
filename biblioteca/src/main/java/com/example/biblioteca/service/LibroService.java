package com.example.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.biblioteca.repository.LibroRepository;
import com.example.biblioteca.model.LibroModel;


@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<LibroModel> getLibros(){
        return libroRepository.obtenerLibros();
    }

    public LibroModel saveLibro(LibroModel libro){
        return libroRepository.guardarLibro(libro);
    }

    public LibroModel getLibroId(int id){
        return libroRepository.obtenerLibroPorId(id);
    }

    public String eliminarLibro(int id){
        libroRepository.eliminarLibro(id);
        return "Libro eliminado de la lista.";
    }

    public LibroModel updateLibro(LibroModel libro){
        return libroRepository.actualizarLibro(libro);
    }
}
