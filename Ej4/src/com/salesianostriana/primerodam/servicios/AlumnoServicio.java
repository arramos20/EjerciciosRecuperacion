package com.salesianostriana.primerodam.servicios;

import com.salesianostriana.primerodam.dao.CrudAlumno;
import com.salesianostriana.primerodam.dao.CrudAlumnoEnMemoria;
import com.salesianostriana.primerodam.modelo.Alumno;

import java.time.LocalDate;
import java.util.*;

public class AlumnoServicio {

    Scanner scan = new Scanner(System.in);

    CrudAlumnoEnMemoria cAlumnoMemoria;

    //Envueltos de CrudAlumno:

    public String findAll(){
        cAlumnoMemoria.findAll().toString();
        return "Operación completada con éxito";
    }

    public String findOne(){
        System.out.println("Introduce el id del alumno que estás buscando: ");
        long idIntroducido = scan.nextLong();
        scan.close();

        System.out.println(cAlumnoMemoria.findOne(idIntroducido).toString());
        return "Operación completada con éxito";
    }

    public String insert(Alumno alumno){
        cAlumnoMemoria.insert(alumno);
        return "Operación completada con éxito";
    }

    public String edit(){
        System.out.println("Introduce el id del alumno a editar:");
        Long id = scan.nextLong();
        scan.close();

        cAlumnoMemoria.edit(cAlumnoMemoria.findOne(id));
        return "Operación completada con éxito";
    }

    public String delete(){
        System.out.println("Introduce el id del alumno que deseas borrar:");
        Long id = scan.nextLong();
        scan.close();

        cAlumnoMemoria.delete(cAlumnoMemoria.findOne(id));
        return "Operación completada con éxito";
    }

    //Métodos propios

    public List<Alumno> getByOrdenAlfabetico(){
        Collections.sort(cAlumnoMemoria.getListaAlumnos());
        return cAlumnoMemoria.findAll();
    }

    public List<Alumno> getByEdad(){ //Entendemos que los ordenamos por edad
        Collections.sort(cAlumnoMemoria.getListaAlumnos(), (a, b) -> a.getEdad() < b.getEdad() ? -1 : a.getEdad() == b.getEdad() ? 0 : 1);
        return cAlumnoMemoria.findAll();
    }

}
