package com.api.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/api")
@RestController // se puede trabajar en formato json en cambio en @controller lo se puede
public class HelloController {
    int a = 2;
    int b = 2;

    @GetMapping("/hello")
    public String saludar(){
        return "Hola mundo con rest springboot";
    }

    @GetMapping("/mathe")
    public String mathe(){

        return "Hola a todos, esta API realiza operaciones matematicas";
    }

    @GetMapping("/suma")
    public int suma(){
        int sum =a+b;
        return sum;
    }
    @GetMapping("/resta")
    public int resta(){
        int resta =a-b;
        return resta;
    }

    @GetMapping("/multiplicacion")
    public int multi(){
        int multi =a*b;
        return multi;
    }

    @GetMapping("/division")
    public int division(){
        int division =a/b;
        return division;
    }

    @GetMapping("/numMayor")
    public String numMayor(){
        if (a>b){
            return "El numero mayor es : " +a;
        }else if(b>a){
            return "El numero mayor es : " +b;
        }else{
            return  "Los numeros son iguales";
        }

    }
}
