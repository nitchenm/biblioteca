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
        listaLibros.add(new LibroModel(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new LibroModel(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new LibroModel(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new LibroModel(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new LibroModel(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new LibroModel(7, "9780321127426", "Effective Java", "Addison-Wesley", 2008, "Joshua Bloch"));
    }

    public List<LibroModel> obtenerLibros(){
        return listaLibros;
    }

    public LibroModel obtenerLibroPorIsbn(String isbn){
        for (LibroModel libro : listaLibros){
            if (libro.getIsbn() == isbn){
                return libro;
            }
        }
        return null;
    }

    public ArrayList<LibroModel> obtenerLibrosPorAutor(String autor){
        ArrayList<LibroModel> listaLibrosPorAutor = new ArrayList<>();
        for (LibroModel libro : listaLibros){
            if(libro.getAutor() == autor){
                listaLibrosPorAutor.add(libro);
            }
        }
        return listaLibrosPorAutor;
    }

    public ArrayList<LibroModel> obtenerLibrosPorAnio(int anioPublicacion){
        ArrayList<LibroModel> listaLibroPorAnio = new ArrayList<>();

        for (LibroModel libro: listaLibros){
            if (libro.getFechaPublicacion() == anioPublicacion){
                listaLibroPorAnio.add(libro);
            }
        }
        return listaLibroPorAnio;
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