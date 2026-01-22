package org.example.hellomongodbspringboot2026.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "equipos")
public class Team {
    @Id
    private String _id;
    private String nombre;
    private String ciudad;
    private Integer año_creacion;
    private String conferencia;
    private String entrenador;
    private Integer presupuesto;
    private String propietario;
    private List<String> jugadores = new ArrayList<>();
}
