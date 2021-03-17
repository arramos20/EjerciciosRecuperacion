package Models;

import java.util.Scanner;

public class Main {

    public static void main(String[] argv){

        Scanner scan = new Scanner(System.in);

        Alquiler alquiler=new Alquiler("Alejandro", "278365289K", 3, (new Vehiculo("28937T", 25.56, 2010), new Batmovil("2938H", 22.02, 2016,4), new PatineteVolador("273Y", 1.22, 3033,200));

        int numIntroducido=0;

        do {

            System.out.println("Bienvenido a la terminal.\n" +
                            "Pulse 0 para salir.\n" +
                            "Pulse 1 para mostrar el total de los vehículos de la lista.\n" +
                            "Pulse 2 para ver todos los datos de los vehículos de la lista\n" +
                            "Pulse 3 para calcular el alquiler del vehículo a escoger de entre la lista.\n");
            numIntroducido = scan.nextInt();
            scan.close();

            switch(numIntroducido){
                case 0:
                    break;
                case 1:
                    System.out.println("El total recaudado es " + alquiler.calcularTotalRecaudado());
                    break;
                case 2:
                    System.out.println("Los vehículos de la lista son: ");
                    alquiler.mostrarListado();
                    break;
                case 3:
                    System.out.print("De la lista de vehículos, introduzca la posición de aquel del que quiere saber su alquiler: ");
                    int numDetalleAlquiler = scan.nextInt();
                    scan.close();
                    numDetalleAlquiler+=1;
                    alquiler.calcularAlquilerUnVehiculo((Vehiculo) alquiler.getListaVehiculos(numDetalleAlquiler));
                    break;
                default:
                    System.out.println("Ese número no está comtemplado.");
            }

        }while (numIntroducido!=0);
    }
}
