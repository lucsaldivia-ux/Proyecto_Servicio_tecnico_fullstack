package com.taskflow.taskflow.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.taskflow.Model.Estado;
import com.taskflow.taskflow.Model.Tarea;
import com.taskflow.taskflow.Repository.TareaRepository;

/*servicio que contiene la logica de negocio para la gestion de tareas */
/*coordina las operaciones entre el Controller y el Repository */

@Service
public class TareaService {

    /*inyecta dependencias a los atributos */
    @Autowired
    private TareaRepository repository;

  
    public List<Tarea> listarTodas() {
        return repository.findAll();
    }

   
    public Optional<Tarea> buscarPorId(Long id) {
        return repository.findById(id);
    }

  /*crea tareas validando que los campos obligatorios no esten vacios, que fecha limite no sea nula,
   y asigna automaticamente la fecha de creacion */
    public Tarea crear(Tarea tarea) {
       
        if (tarea.getTitulo() == null || tarea.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El campo titulo no puede estar vacío");
        }
        
        if (tarea.getDescripcion() == null || tarea.getDescripcion().isBlank()) {
            throw new IllegalArgumentException("El campo descripcion no puede estar vacío");
        }
       
        if (tarea.getResponsable() == null || tarea.getResponsable().isBlank()) {
            throw new IllegalArgumentException("El campo responsable no puede estar vacío");
        }
     
        if (tarea.getFechaLimite() == null) {
            throw new IllegalArgumentException("La fecha limite es obligatoria");
        }
   
        tarea.setFechaCreacion(LocalDate.now());
        
        return repository.save(tarea);
    }
  /*actualizar tareas validando que los campos obligatorios no esten vacios, que fecha limite no sea nula,
   y asigna automaticamente la fecha de creacion */
    public Optional<Tarea> actualizar(Long id, Tarea tarea) {
       
        if (tarea.getTitulo() == null || tarea.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El campo titulo no puede estar vacío");
        }
        if (tarea.getResponsable() == null || tarea.getResponsable().isBlank()) {
            throw new IllegalArgumentException("El campo responsable no puede estar vacío");
        }
        if (tarea.getFechaLimite() == null) {
            throw new IllegalArgumentException("La fecha limite es obligatoria");
        }
        return repository.update(id, tarea);
    }

    public boolean eliminar(Long id) {
        return repository.delete(id);
    }

    public List<Tarea> listarPorEstado(Estado estado) {
        return repository.findAll().stream()
                .filter(t -> t.getEstado() == estado)
                .collect(Collectors.toList());
    }
}