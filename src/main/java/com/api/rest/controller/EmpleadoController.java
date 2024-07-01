package com.api.rest.controller;

import com.api.rest.model.Empleado;
import com.api.rest.model.Product;
import com.api.rest.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado agregarEmpleado (@RequestBody Empleado empleado){
        return empleadoService.saveEmpleado(empleado);
    }

    @GetMapping
    public List<Empleado> listarEmpleados(){
        return  empleadoService.getEmpleados();
    }

    @GetMapping("/{id}")
    public Empleado buscarEmpleados(@PathVariable int id){
        return empleadoService.getEmpleadoById(id);
    }

    // Método para buscar empleado por email (gmail)
    @GetMapping("/gmail/{email}")
    public Empleado buscarPorGmail(@PathVariable String email) {
        return empleadoService.findByGmail(email);
    }
    @PutMapping
    public Empleado actualizarEmpleado (@RequestBody Empleado empleado){
        return empleadoService.updateEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public String eliminarEmpleado (@PathVariable int id){
        return empleadoService.deleteEmpleado(id);
    }

    @GetMapping("/sueldosMayores")
    public List<Empleado> listarEmpleadosSueldoMayorA1000() {
        return empleadoService.listarPorSueldoMayorA1000();
    }

    @GetMapping("/experiencia")
    public List<Empleado> mayor5anos() {
        return empleadoService.findByExperiencia();
    }
}
