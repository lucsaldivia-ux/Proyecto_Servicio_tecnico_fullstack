package com.taskflow.taskflow.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.taskflow.taskflow.Model.Tarea;


@Repository
public class TareaRepository {

   /*lista de tareas para el equipo*/
    private List<Tarea> tareas = new ArrayList<>();

  
    private Long contadorId = 1L;

    /*aqui cargamos datos de prueba*/
    public TareaRepository() {
        tareas.add(new Tarea(contadorId++, "Preparar informe", "informe sobre errores semanales",
                com.taskflow.taskflow.Model.Estado.PENDIENTE,
                com.taskflow.taskflow.Model.Prioridad.ALTA,
                "Pedro Vargas", java.time.LocalDate.now(), java.time.LocalDate.of(2026, 6, 01)));
        
            tareas.add(new Tarea(contadorId++, "servicio tecnico equipos", "Analizar errores y realizar mantencion",
                com.taskflow.taskflow.Model.Estado.EN_PROGRESO,
                com.taskflow.taskflow.Model.Prioridad.URGENTE,
                "Ramon Guttierrez", java.time.LocalDate.now(), java.time.LocalDate.of(2026, 4, 13)));

                tareas.add(new Tarea(contadorId++, "soporte tecnico a cliente", "el cliente requiere de ayuda por error de sistema operativo",
                com.taskflow.taskflow.Model.Estado.COMPLETADA,
                com.taskflow.taskflow.Model.Prioridad.MEDIA,
                "Josue Montiel", java.time.LocalDate.now(), java.time.LocalDate.of(2026, 5, 01)));

                 tareas.add(new Tarea(contadorId++, "instalacion de equipo", "una empresa nesecita de una instalacion de equipos",
                com.taskflow.taskflow.Model.Estado.COMPLETADA,
                com.taskflow.taskflow.Model.Prioridad.MEDIA,
                "Karla Barria", java.time.LocalDate.now(), java.time.LocalDate.of(2026, 3, 28)));
    }

    /*recorre lista para ver datos/tareas */
    public List<Tarea> findAll() {
        return tareas;
    }

    /*sirve para buscar datos por id */
    public Optional<Tarea> findById(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    /*guarda nuevo dato en la lista y los guarda*/
    public Tarea save(Tarea tarea) {
        tarea.setId(contadorId++);
        tareas.add(tarea);
        return tarea;
    }

    /*sirve para actualizar los parametros de la lista y se identifica por id */
    public Optional<Tarea> update(Long id, Tarea tareaActualizada) {
        Optional<Tarea> existente = findById(id);
        if (existente.isPresent()) {
            Tarea t = existente.get();
            t.setTitulo(tareaActualizada.getTitulo());
            t.setDescripcion(tareaActualizada.getDescripcion());
            t.setEstado(tareaActualizada.getEstado());
            t.setPrioridad(tareaActualizada.getPrioridad());
            t.setResponsable(tareaActualizada.getResponsable());
            t.setFechaLimite(tareaActualizada.getFechaLimite());
            return Optional.of(t);
        }
        return Optional.empty();
    }
/*sirve para eliminar datos de la lista*/
    public boolean delete(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}