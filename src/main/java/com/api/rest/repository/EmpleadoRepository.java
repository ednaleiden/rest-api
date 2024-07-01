package com.api.rest.repository;

import com.api.rest.model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmpleadoRepository {

    private List<Empleado> empleados = new ArrayList<>();

    public EmpleadoRepository() {
        // Agregar algunos empleados de ejemplo
        empleados.add(new Empleado(1, "Juan", "Pérez", 30, 2500.0, "juan@example.com", 9));
        empleados.add(new Empleado(2, "María", "Gómez", 28, 2800.0, "maria@example.com", 4));
    }



    public EmpleadoRepository(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    //lsitar empleado
    public List<Empleado> getAllEmpleados() {
        return empleados;
    }

    //empleado por id
    public Empleado findById(int id) {
        for (int i = 0; i < empleados.size(); i++) {
            if(empleados.get(i).getId() == id){

                return empleados.get(i);
            }
        }
        return null;
    }

    // Método para buscar empleado por email (gmail)
    public Empleado findByGmail(String email) {
        for (Empleado empleado : empleados) {
            if (empleado.getEmail().equalsIgnoreCase(email)) {
                return empleado;
            }
        }
        return null; // Devuelve null si no se encuentra ningún empleado con ese email
    }
    public List<Empleado> findByExperiencia() {
        List<Empleado> mayor5anos = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getAnosExperiencia() > 5) {
                mayor5anos.add(empleado);
            }
        }
        return  mayor5anos;
    }


    public List<Empleado> search(String nombre){
        return empleados.stream()
                .filter(x -> x.getNombre().equals(nombre))
                .collect(Collectors.toList());
    }

    public  Empleado save(Empleado p){
        Empleado empleados1 = new Empleado();
        empleados1.setId(p.getId());
        empleados1.setNombre(p.getNombre());
        empleados1.setApellido(p.getApellido());
        empleados1.setEdad(p.getEdad());
        empleados1.setEmail(p.getEmail());
        empleados1.setSueldo(p.getSueldo());
        empleados1.setAnosExperiencia(p.getAnosExperiencia());

        empleados.add(empleados1);
        return empleados1;
    }

    public String delete(Integer id){
        empleados.removeIf(x -> x.getId() == id);
        return null;
    }
    //comprobar el producto y tener posicion
    public Empleado update(Empleado empleadoe){
        int idX=0;//1
        int id = 0;

        for(int i = 0; i < empleados.size(); i++){
            if (empleados.get(i).getId() == empleadoe.getId()){
                id = empleadoe.getId();
                idX = i;//posision id producto
                break;
            }
        }
        Empleado empleador = new Empleado();
        empleador.setId(id);
        empleador.setNombre(empleadoe.getNombre());
        empleador.setApellido(empleadoe.getApellido());
        empleador.setAnosExperiencia(empleadoe.getAnosExperiencia());
        empleador.setEdad(empleadoe.getEdad());
        empleador.setEmail(empleadoe.getEmail());
        empleador.setSueldo(empleadoe.getSueldo());
        empleados.set(idX, empleador);
        return empleador;
    }

    // Método para listar empleados con sueldos mayores a 1000
    public List<Empleado> listarPorSueldoMayorA1000() {
        List<Empleado> empleadosConSueldoMayorA1000 = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getSueldo() > 1000.0) {
                empleadosConSueldoMayorA1000.add(empleado);
            }
        }
        return empleadosConSueldoMayorA1000;
    }
}
