package com.task.app.demo.controllers;

import com.task.app.demo.repositories.entities.ProjectEntity;
import com.task.app.demo.services.IUserService;
import com.task.app.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private HashMap<String, Object> responseJson = new HashMap<>();
    private Object dateToday = LocalDate.now();

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/{userId}")
    private ResponseEntity<?> findAll(@PathVariable Long userId) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(projectService.findByUser(userId));
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, no se pudo traer los proyectos.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @GetMapping("/{userId}/{idProject}")
    public ResponseEntity<?> findById(@PathVariable Long userId, @PathVariable Long idProject) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(projectService.findById(iUserService.findById(userId),idProject));
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, no se pudo crear el proyecto.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> create(@RequestBody ProjectEntity project, @PathVariable Long userId) {
        try{
            projectService.create(project, userId);

            responseJson.put("mensaje", "Se creo el proyecto");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.OK);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseJson);
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, no se pudo crear el proyecto.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<?> update(@RequestBody ProjectEntity projectUpdated, @PathVariable Long projectId) {
        try{
            projectService.update(projectId, projectUpdated);

            responseJson.put("mensaje", "Se actualizo el proyecto");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.OK);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseJson);
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, no se pudo crear el proyecto.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            projectService.delete(id);

            responseJson.put("mensaje", "Se elimino el proyecto");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.OK);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseJson);
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, no se pudo crear el proyecto.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }
}
