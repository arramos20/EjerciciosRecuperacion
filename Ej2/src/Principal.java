import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] argv) {

        Scanner scan = new Scanner(System.in);

        Jugador j1 = new Jugador("Alejandro", "Delantero", 1);
        Jugador j2 = new Jugador("Sergio", "Defensa", 5);
        Jugador j3 = new Jugador("Rodolfo", "Portero", 4);
        Jugador j4 = new Jugador("Alberto", "Delantero", 2);
        Jugador j5 = new Jugador("Luis", "Central", 3);
        Jugador j6 = new Jugador("Federico", "Defensa", 7);
        Jugador j7 = new Jugador("Eustaquio", "Delantero", 6);
        Jugador j8 = new Jugador("Ramón", "Lateral", 8);

        List<Jugador> listaJugadores = null;
        listaJugadores.add(j1);
        listaJugadores.add(j2);
        listaJugadores.add(j3);
        listaJugadores.add(j4);
        listaJugadores.add(j5);
        listaJugadores.add(j6);
        listaJugadores.add(j7);
        listaJugadores.add(j8);

        Equipo e1 = new Equipo(listaJugadores);

        int numIntroducido = 0;

        do {

            System.out.println("Bienvenido a la terminal.\n" +
                    "Pulse 0 para salir.\n" +
                    "Pulse 1 para añadir un nuevo jugador.\n" +
                    "Pulse 2 para borrar un jugador de la lista. \n" +
                    "Pulse 3 para imprimir todos los jugadores de la lista.\n" +
                    "Pulse 4 para buscar un jugador por nombre. \n" +
                    "Pulse 5 para buscar todos los jugadores que estén en una posición concreta. \n" +
                    "Pulse 6 para modificar la posición de un jugador concreto. \n" +
                    "Pulsa 7 para ordenar la lista por posiciones de juego. \n");

            numIntroducido = scan.nextInt();
            scan.close();

            switch (numIntroducido) {
                case 0:
                    break;
                case 1:
                    e1.addPlayer();
                    break;
                case 2:
                    e1.deleteChosenPlayer();
                    break;
                case 3:
                    e1.printPlayerList();
                    break;
                case 4:
                    e1.searchByName();
                    break;
                case 5:
                    e1.getSamePositionPlayersList();
                    break;
                case 6:
                    e1.editPlayerPosition();
                    break;
                case 7:
                    e1.orderPlayerListByPosition();
                    break;
                default:
                    System.out.println("Ese valor no está reconocido.\n" +
                            "Volviendo al menú principal...");
                    break;
            }
        } while (numIntroducido != 0);
    }
}