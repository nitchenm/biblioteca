package com.example.biblioteca.service;

import java.util.ArrayList;
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

    public int totalLibros(){
        return libroRepository.obtenerLibros().size();
    }

    public LibroModel obtenerLibroPorIsbn(String isbn){
        return libroRepository.obtenerLibroPorIsbn(isbn);
    }

    public List<LibroModel> obtenerLibrosPorAnio(int anioPublicacion){
        List<LibroModel> listaLibroPorAnio = libroRepository.obtenerLibros();

        for (LibroModel libro: listaLibroPorAnio){
            if (libro.getFechaPublicacion() == anioPublicacion){
                listaLibroPorAnio.add(libro);
            }
        }
        return listaLibroPorAnio;
    }

    public List<LibroModel> obtenerLibrosPorAutor(String autor){
        List<LibroModel> listalibros = libroRepository.obtenerLibros();
        List<LibroModel> listLibrosPorAutor = new ArrayList<>();
        for (LibroModel libro: listalibros){
            if (libro.getAutor() == autor){
                listLibrosPorAutor.add(libro);
            }
        }
        return listLibrosPorAutor;
    }

    public LibroModel obtenerLibroMasAntiguo(){
        List<LibroModel> listalibros = libroRepository.obtenerLibros();
        LibroModel libroMasAntiguo = listalibros.get(0);

        for (LibroModel libro : listalibros){
            if (libro.getFechaPublicacion() < libroMasAntiguo.getFechaPublicacion()){
                libroMasAntiguo = libro;
            }
        }
        return libroMasAntiguo;
    }

    public LibroModel obtenerLibroMasNuevo(){
        List<LibroModel> listaLibros = libroRepository.obtenerLibros();
        LibroModel libroMasNuevo = listaLibros.get(0);

        for(LibroModel libro : listaLibros){
            if(libro.getFechaPublicacion() > libroMasNuevo.getFechaPublicacion()){
                libroMasNuevo = libro;
            }
        }
        return libroMasNuevo;
    }

    
}
