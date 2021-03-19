import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Equipo {

    Scanner scan = new Scanner(System.in);

    List<Jugador> listaJugadores= new ArrayList<Jugador>();

    public Equipo(List<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public String addPlayer(){
        Jugador j1=null; int numJNuevo;

        System.out.println("Introduce el nombre del jugador nuevo: ");
        String nombreJNuevo = scan.nextLine();
        scan.close();
        j1.setNombre(nombreJNuevo);

        System.out.println("Introduce la posición del jugador nuevo: ");
        String PosicionJNuevo = scan.nextLine();
        scan.close();
        j1.setPosicion(PosicionJNuevo);

        System.out.println("Introduce el número de camiseta del jugador nuevo: ");
        numJNuevo = scan.nextInt()-1;
        scan.close();
        j1.setNumCamiseta(numJNuevo);

        listaJugadores.add(j1);
        return "Jugador añadido";
    }

    public String deleteChosenPlayer(){
        int numIntroducido;
        System.out.println("Lista de Jugadores:");
        toString();
        System.out.println("Introduce el número del jugador que quieras borrar");
        numIntroducido = scan.nextInt()-1;
        scan.close();
        listaJugadores.remove(numIntroducido);
        return "Jugador eliminado";
    }

    public void printPlayerList(){
        Jugador j1; int contador=1;
        Iterator it= listaJugadores.iterator();
        while(it.hasNext()){
            j1= (Jugador) it.next();
            System.out.println(contador +".- " + j1.toString() + "\n");
            contador++;
        }
    }

    public Jugador searchByName(){
        System.out.println("Introduce el nombre del jugador que buscas: ");
        String nombreIntroducido = scan.nextLine();
        scan.close();
        Jugador jBuscado = null;
        String nombreJugador="";
        for (int i = 0; i < listaJugadores.size(); i++) {
            nombreJugador=listaJugadores.get(i).nombre;
            if(nombreJugador==nombreIntroducido){
                jBuscado=listaJugadores.get(i);
                i=listaJugadores.size();
            }
        }
        if(jBuscado==null){
            System.out.println("No hay ningún jugador con ese nombre.");
        }

        return jBuscado;
    }

    public List<Jugador> getSamePositionPlayersList() {
        String posicionBuscada = scan.nextLine();
        scan.close();
        List<Jugador> listaJugadoresConLaMismaPosicion = null;
        for (int i = 0; i < listaJugadores.size(); i++) {
            if(listaJugadores.get(i).posicion==posicionBuscada){
                listaJugadoresConLaMismaPosicion.add(listaJugadores.get(i));
            }
        }
        if(listaJugadoresConLaMismaPosicion.isEmpty()){
            System.out.println("No hay ningún jugador con esa posición.");
        }
        return listaJugadoresConLaMismaPosicion;
    }

    public String editPlayerPosition(){
        Jugador j1=searchByName();
        System.out.println("Introduce la nueva posición para ese jugador: ");
        String nuevaPosicion = scan.nextLine();
        scan.close();
        j1.setPosicion(nuevaPosicion);
        return "Ahora " + j1.nombre + " es " + j1.getPosicion();
    }

    public List<Jugador> orderPlayerListByPosition(){
        List<Jugador> listaDelanteros = null;
        List<Jugador> listaCentrales = null;
        List<Jugador> listaLaterales = null;
        List<Jugador> listaDefensas = null;
        List<Jugador> listaPorteros = null;

        List<Jugador> listaOrdenada = null;

        for (int i = 0; i < listaJugadores.size(); i++) {
            if (listaJugadores.get(i).posicion == "delantero" || listaJugadores.get(i).posicion == "Delantero") {
                listaDelanteros.add(listaJugadores.get(i));
            } else if (listaJugadores.get(i).posicion == "central" || listaJugadores.get(i).posicion == "Central") {
                listaCentrales.add(listaJugadores.get(i));
            } else if (listaJugadores.get(i).posicion == "lateral" || listaJugadores.get(i).posicion == "Lateral") {
                listaLaterales.add(listaJugadores.get(i));
            } else if (listaJugadores.get(i).posicion == "defensa" || listaJugadores.get(i).posicion == "Defensa") {
                listaDefensas.add(listaJugadores.get(i));
            } else if (listaJugadores.get(i).posicion == "portero" || listaJugadores.get(i).posicion == "Portero") {
                listaPorteros.add(listaJugadores.get(i));
            }
        }
        listaOrdenada.addAll(listaDelanteros);
        listaOrdenada.addAll(listaCentrales);
        listaOrdenada.addAll(listaLaterales);
        listaOrdenada.addAll(listaDefensas);
        listaOrdenada.addAll(listaPorteros);
        listaJugadores.clear();
        listaJugadores=listaOrdenada;

        return listaJugadores;
    }

    public String toString(){
        String mensaje="";
        for (int i = 0; i < listaJugadores.size(); i++) {
            mensaje+= i+1 + ".- " + listaJugadores.get(i) + "\n";
        }
        return mensaje;
    }

}
