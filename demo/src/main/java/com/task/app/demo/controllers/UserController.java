package com.task.app.demo.controllers;

import com.task.app.demo.repositories.entities.Login;
import com.task.app.demo.repositories.entities.UserEntity;
import com.task.app.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;


@RestController
@RequestMapping("/usuario")
public class UserController {

    //RESPUESTA EN OBJETO
    private HashMap<String, Object> responseJson = new HashMap<>();
    private Object dateToday = LocalDate.now();

    @Autowired
    private IUserService iUserService;

    @GetMapping
    private ResponseEntity<?> findAll() {
        try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(iUserService.findAll());
        }catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, no se pudo traer los usuarios.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    //@CrossOrigin(originPatterns = "http://127.0.0.1:5500)", methods = RequestMethod.POST)
    @PostMapping("/login")
    private ResponseEntity<?> login(@RequestBody Login login) {

        try {
            UserEntity userLogin = iUserService.login(login.getEmail(), login.getPassword());

            if(userLogin == null) {
                responseJson.put("mensaje", "El correo no esta registrado, registrate en nuestro sistema.");
                responseJson.put("fecha", dateToday);
                responseJson.put("estado", HttpStatus.NOT_FOUND);

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(responseJson);
            }

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userLogin);
        } catch (Exception e) {
            responseJson.put("mensaje", "Ocurrio un error, vuelve a intentarlo.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }

    @PostMapping("/register")
    private ResponseEntity<?> create(@RequestBody UserEntity user) {
        try {

            if(iUserService.findByEmail(user.getEmail())) {

                responseJson.put("mensaje", "El Correo ya esta registrado.");
                responseJson.put("fecha", dateToday);
                responseJson.put("estado", HttpStatus.NOT_FOUND);

                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(responseJson);
            }

            iUserService.create(user);

            responseJson.put("mensaje", "Te has registrado exitosamente.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.OK);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(responseJson);
        }catch (Exception error) {
            responseJson.put("mensaje", "Ocurrio un error, intentalo más tarde.");
            responseJson.put("fecha", dateToday);
            responseJson.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseJson);
        }
    }
}
