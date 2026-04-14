package com.taskflow.taskflow.Model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//declarar atributos que tendra mi sistema en cuanto a los datos sobre la tarea a realizar
//datos de usuario
public class Tarea {

    private Long id;

    private String titulo;

    private String descripcion;

    private Estado estado;

    private Prioridad prioridad;

    private String responsable;

    private LocalDate fechaCreacion;

    private LocalDate fechaLimite;
}