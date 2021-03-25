package com.salesianostriana.primerodam.dao;

import com.salesianostriana.primerodam.modelo.Alumno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrudAlumnoEnMemoria implements CrudAlumno{

    Scanner scan = new Scanner(System.in);

    List<Alumno> listaAlumnos=new ArrayList<Alumno>();

    @Override
    public List<Alumno> findAll() {
        return listaAlumnos;
    }

    @Override
    public Alumno findOne(long id) {
        Alumno alFinal=null;
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).getId()==id){
                alFinal= listaAlumnos.get(i);
            }
        }
        if (alFinal==null){
            System.out.println("No hay ningún alumno cuyo id sea el introducido.");
        }
        return alFinal;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    @Override
    public void insert(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

    @Override
    public void edit(Alumno alumno) {

        System.out.println("Introduce el id del alumno:");
        Long idNuevo = scan.nextLong();
        scan.close();

        System.out.println("Introduce el nombre del alumno:");
        String nombreNuevo = scan.nextLine();
        scan.close();

        System.out.println("Introduce los apellidos del alumno:");
        String apellidosNuevo = scan.nextLine();
        scan.close();

        System.out.println("Introduce el año de nacimiento del alumno:");
        int anyoNacNuevo = scan.nextInt();
        scan.close();
        System.out.println("Introduce el año de nacimiento del alumno:");
        int mesNacNuevo = scan.nextInt();
        scan.close();
        System.out.println("Introduce el año de nacimiento del alumno:");
        int diaNacNuevo = scan.nextInt();
        scan.close();
        LocalDate fechaNacNueva=LocalDate.of(anyoNacNuevo, mesNacNuevo, diaNacNuevo);

        System.out.println("Introduce el email del alumno:");
        String emailNuevo = scan.nextLine();
        scan.close();

        Alumno alumnoEditado=new Alumno(idNuevo, nombreNuevo, apellidosNuevo, fechaNacNueva, emailNuevo);

        listaAlumnos.set(listaAlumnos.indexOf(alumno), alumnoEditado);

    }

    @Override
    public void delete(Alumno alumno) {
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if(listaAlumnos.get(i).equals(alumno)){
                listaAlumnos.remove(listaAlumnos.get(i));
            }
        }
    }

}
