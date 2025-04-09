package com.example.biblioteca.repository;

import com.example.biblioteca.model.LibroModel;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    private List<LibroModel> listaLibros = new ArrayList<>();

    @PostConstruct
    public void init(){
        listaLibros.add(new LibroModel(2,"978-1617294945","Spring in action","Addison-Wesley", 2018,"Joshua Bloch"));
    }

    public List<LibroModel> obtenerLibros(){
        return listaLibros;
    }

    public LibroModel obtenerLibroPorId(int id){
        for (LibroModel libro : listaLibros){
            if (libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public LibroModel guardarLibro(LibroModel libro){
        listaLibros.add(libro);
        return libro;
    }

    public LibroModel actualizarLibro(LibroModel libro){
        int id = 0;
        int idPosicion = 0;

        for (int i= 0 ; i< listaLibros.size(); i++ ){
            if (listaLibros.get(i).getId() == libro.getId()){
                id = libro.getId();
                idPosicion = i;
            }
        } 
        LibroModel libro1 = new LibroModel();

        libro1.setId(idPosicion);
        libro1.setAutor(libro.getAutor());
        libro1.setEditorial(libro.getEditorial());
        libro1.setFechaPublicacion(libro.getFechaPublicacion());
        libro1.setIsbn(libro.getIsbn());
        libro1.setTitulo(libro.getTitulo());

        listaLibros.set(idPosicion, libro1);
        return libro1;

    }

    public void eliminarLibro(int id){
        LibroModel libro = obtenerLibroPorId(id);

        if (libro != null){
            listaLibros.remove(id);
        }
    }

}