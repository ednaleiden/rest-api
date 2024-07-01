package com.api.rest.service;

import com.api.rest.model.Empleado;
import com.api.rest.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado saveEmpleado(Empleado empleado) {

        return empleadoRepository.save(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleadoRepository.getAllEmpleados();
    }


    public Empleado getEmpleadoById(int id){
        return empleadoRepository.findById(id);
    }


    // Método para buscar empleado por email (gmail)
    public Empleado findByGmail(String email) {
        return empleadoRepository.findByGmail(email);
    }

    public List<Empleado> findByExperiencia () {
        return (List<Empleado>) empleadoRepository.findByExperiencia();
    }
    public String deleteEmpleado(int id){
        empleadoRepository.delete(id);
        return "Producto eliminado"+ id;
    }

    public Empleado updateEmpleado(Empleado empleado){
        return empleadoRepository.update(empleado);
    }

    public List<Empleado> listarPorSueldoMayorA1000() {
        return empleadoRepository.listarPorSueldoMayorA1000();
    }
}


