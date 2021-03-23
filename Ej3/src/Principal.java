import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] argv) {

        Scanner scan = new Scanner(System.in);

        int numIntroducido = 0;

        Mensaje m1=new Mensaje("Luis", "Buenos días compañero.");
        Mensaje m2=new Mensaje("Alberto", "Hey colega. Juguemos a un juego.");
        Mensaje m3=new Mensaje("Azazel", "Siento lo de ayer. Tenías razón y me pasé de la ralla...");
        Mensaje m4=new Mensaje("Xion", "Baja, que se enfría la comida.");

        List<Mensaje> listaMsgs= new ArrayList<Mensaje>();
        listaMsgs.add(m1); listaMsgs.add(m2);
        listaMsgs.add(m3); listaMsgs.add(m4);

        WhatsApp whats=new WhatsApp(listaMsgs);

        do {

            System.out.println("Bienvenido a la terminal.\n" +
                    "Pulse 0 para salir.\n" +
                    "Pulse 1 para añadir un nuevo mensaje a la lista.\n" +
                    "Pulse 2 para buscar un mensaje por el nombre del contacto. \n" +
                    "Pulse 3 para borrar un mensaje buscando por el nombre del contacto.\n" +
                    "Pulse 4 para imprimir todos los mensajes de la lista. \n" +
                    "Pulse 5 para modificar el cuerpo de un mensaje. \n" +
                    "Pulse 6 para ordenar la lista por contacto. \n");

            numIntroducido = scan.nextInt();
            scan.close();

            switch (numIntroducido) {
                case 0:
                    break;
                case 1:
                    whats.addMessage();
                    System.out.println("Volviendo al menú principal...\n");
                    break;
                case 2:
                    whats.searchMsg();
                    System.out.println("Volviendo al menú principal...\n");
                    break;
                case 3:
                    whats.deleteSearchedMsg();
                    System.out.println("Volviendo al menú principal...\n");
                    break;
                case 4:
                    whats.printMsgList();
                    System.out.println("Volviendo al menú principal...\n");
                    break;
                case 5:
                    whats.modifyMsgBody();
                    System.out.println("Volviendo al menú principal...\n");
                    break;
                case 6:
                    whats.orderListByContact();
                    System.out.println("Volviendo al menú principal...\n");
                    break;
            }
        }while (numIntroducido!=0);

        System.out.println("Programa terminado.");
    }
}