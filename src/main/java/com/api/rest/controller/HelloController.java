package com.api.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // se puede trabajar en formato json en cambio en @controller lo se puede
public class HelloController {
    @GetMapping("/hello")
    public String saludar(){
        return "Hola mundo con rest springboot";
    }
}
