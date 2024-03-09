package com.task.app.demo.controllers;

import com.task.app.demo.repositories.entities.TaskEntity;
import com.task.app.demo.repositories.entities.UserEntity;
import com.task.app.demo.services.IUserService;
import com.task.app.demo.services.ProjectService;
import com.task.app.demo.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    //RESPUESTA EN OBJETO
    private HashMap<String, Object> responseJson = new HashMap<>();
    private Object dateToday = LocalDate.now();

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IUserService iUserService;

    @GetMapping("/project/{idProject}")
    public ResponseEntity<?> allTaskByProject(@PathVariable Long idProject) {
        try {
            List<TaskEntity> task = taskService.allTaskByProject(idProject);

            if(task == null) {
                responseJson.put("mensaje", "Ocurrio un error, no existe ninguna tarea");
                responseJson.put("fecha", dateToday);
                responseJson.put("estado", HttpStatus.NOT_FOUND);

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(responseJson);
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(task);
        }catch (Exception e) {
            responseJson.put("mensaje", e.getMessage());
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @PostMapping("/{userId}/{idProject}")
    public ResponseEntity<?> create(@RequestBody TaskEntity task, @PathVariable Long userId ,@PathVariable Long idProject) {
        try {
            UserEntity user = iUserService.findById(userId);

            task.setProject(projectService.findById(user, idProject));
            taskService.createTask(task);

            responseJson.put("mensaje", "se registro la tarea exitosamente.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.OK);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseJson);
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, vuelve a intentarlo.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @GetMapping("/{idTask}")
    public ResponseEntity<?> findById(@PathVariable Long idTask) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(taskService.findById(idTask));
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, vuelve a intentarlo.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @DeleteMapping("/{idTask}")
    public ResponseEntity<?> deleteById(@PathVariable Long idTask) {
        try {
            taskService.deleteTask(idTask);

            responseJson.put("mensaje", "se elimino la tarea exitosamente.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.OK);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseJson);
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, vuelve a intentarlo.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }
}
