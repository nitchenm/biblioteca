package com.example.biblioteca.model;

import org.springframework.stereotype.Indexed;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Prestamo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prestamo;

    @OneToMany
    @JoinColumn(name="libro_id", nullable = false,referencedColumnName = "id")
    private LibroModel libro;

    @Column(nullable= false)
    private String run_solicitante;
    
    @Column(nullable= false)
    private Date fecha_solicitud;

    @Column(nullable= false)
    private Date fecha_entrega;

    @Column(nullable=false)
    private int cantidad_dias;

    @Column(nullable= false)
    private int multas= 0;
}
