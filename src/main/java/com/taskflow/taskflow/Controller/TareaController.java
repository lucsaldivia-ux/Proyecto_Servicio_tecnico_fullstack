package com.taskflow.taskflow.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskflow.taskflow.Model.Estado;
import com.taskflow.taskflow.Model.Tarea;
import com.taskflow.taskflow.Service.TareaService;


@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService service;

    /*Retorna la lista completa de tareas */
    @GetMapping
    public ResponseEntity<List<Tarea>> getAll() {
        return ResponseEntity.ok(service.listarTodas());
    }
 
/*retorna tarea especifica por id */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Tarea> tarea = service.buscarPorId(id);
        if (tarea.isPresent()) {
            return ResponseEntity.ok(tarea.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Tarea no encontrada"));
    }

/*Registra una tarea nueva en el sistema */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Tarea tarea) {
        try {
            Tarea nueva = service.crear(tarea);
            return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

/*actualiza los datos de una tarea existente */ 
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Tarea tarea) {
        try {
            Optional<Tarea> actualizada = service.actualizar(id, tarea);
            if (actualizada.isPresent()) {
                return ResponseEntity.ok(actualizada.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Tarea no encontrada"));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

/*elimina una tarea del sistema */   
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        if (eliminado) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Tarea no encontrada"));
    }

/*retorna tareas filtradas por estado */    
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> getByEstado(@PathVariable Estado estado) {
        List<Tarea> resultado = service.listarPorEstado(estado);
        return ResponseEntity.ok(resultado);
    }
}