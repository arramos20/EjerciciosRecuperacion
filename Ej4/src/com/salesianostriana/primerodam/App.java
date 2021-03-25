package com.salesianostriana.primerodam;

import com.salesianostriana.primerodam.modelo.Alumno;
import com.salesianostriana.primerodam.servicios.AlumnoServicio;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class App {
    public static void main(String[] argv) {

        Scanner scan = new Scanner(System.in);

        AlumnoServicio as1=new AlumnoServicio();

        Alumno a1=new Alumno(11111111, "Alfonso", "Sánchez", LocalDate.of(1997, Month.FEBRUARY, 24), "alfosan24@gmail.com");
        Alumno a2=new Alumno(22222222, "Rigoberto", "Martínez", LocalDate.of(1998, Month.JULY, 16), "rigomar16@gmail.com");
        Alumno a3=new Alumno(33333333, "Francisco", "Xenotrop", LocalDate.of(1997, Month.APRIL, 23), "franxeno23@gmail.com");
        Alumno a4=new Alumno(44444444, "Sergio", "Libai", LocalDate.of(1996, Month.AUGUST, 13), "serliba13@gmail.com");
        Alumno a5=new Alumno(55555555, "Marco", "Aragón", LocalDate.of(1999, Month.AUGUST, 6), "marcara06@gmail.com");

        as1.insert(a1); as1.insert(a2);
        as1.insert(a3); as1.insert(a4);
        as1.insert(a5);

        int numIntroducido = 0;

        do {

            System.out.println("Bienvenido a la terminal.\n" +
                    "Pulse 0 para salir.\n" +
                    "Pulse 1 para añadir un nuevo alumno a la lista.\n" +
                    "Pulse 2 para imprimir todos los alumnos de la lista por orden alfabético de apellidos.\n" +
                    "Pulse 3 para editar un alumno por id. \n" +
                    "Pulse 4 para mostrar los alumnos por orden de edad a final de año \n");

            numIntroducido = scan.nextInt();
            scan.close();

            switch (numIntroducido) {
                case 0:
                    break;
                case 1:
                    System.out.println("Introduce el id del alumno:");
                    Long id = scan.nextLong();
                    scan.close();

                    System.out.println("Introduce el nombre del alumno:");
                    String nombre = scan.nextLine();
                    scan.close();

                    System.out.println("Introduce los apellidos del alumno:");
                    String apellidos = scan.nextLine();
                    scan.close();

                    System.out.println("Introduce el año de nacimiento del alumno:");
                    int anyoNac = scan.nextInt();
                    scan.close();
                    System.out.println("Introduce el año de nacimiento del alumno:");
                    int mesNac = scan.nextInt();
                    scan.close();
                    System.out.println("Introduce el año de nacimiento del alumno:");
                    int diaNac = scan.nextInt();
                    scan.close();
                    LocalDate fechaNac=LocalDate.of(anyoNac, mesNac, diaNac);

                    System.out.println("Introduce el email del alumno:");
                    String email = scan.nextLine();
                    scan.close();

                    Alumno alumnoNuevo=new Alumno(id, nombre, apellidos, fechaNac, email);

                    as1.insert(alumnoNuevo);
                    break;
                case 2:
                    as1.getByOrdenAlfabetico();
                    break;
                case 3:
                    as1.edit();
                    break;
                case 4:
                    as1.getByEdad();
                    break;
                default:
                    System.out.println("Ese valor no está reconocido.\n" +
                            "Volviendo al menú principal...");
                    break;
            }
        } while (numIntroducido != 0);
    }
}

