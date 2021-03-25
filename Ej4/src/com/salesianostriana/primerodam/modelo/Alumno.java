package com.salesianostriana.primerodam.modelo;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Objects;

public class Alumno implements Comparable{
    private long id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String email;

    public Alumno() {
    }

    public Alumno(long id, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return id == alumno.id && Objects.equals(nombre, alumno.nombre) && Objects.equals(apellidos, alumno.apellidos) && Objects.equals(fechaNacimiento, alumno.fechaNacimiento) && Objects.equals(email, alumno.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidos, fechaNacimiento, email);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", email='" + email + '\'' +
                '}';
    }

    //Otros métodos:

    public int getEdad(){
        LocalDate endOfYearDate= LocalDate.of(LocalDate.now().getYear(), Month.DECEMBER, 31);
        return Period.between(getFechaNacimiento(), endOfYearDate).getYears();
    }

    @Override
    public int compareTo(Object o) {
        Alumno a1 = (Alumno) o;
        return getApellidos().compareTo(a1.getApellidos());
    }
}
