package Models;

import java.util.ArrayList;
import java.util.List;

public class Alquiler {

    String nombreCreador;
    String dni;
    int diasAlquiler;
    List<Vehiculo> listaVehiculos= new ArrayList<Vehiculo>();

    public Alquiler(String nombreCreador, String dni, int diasAlquiler, List<Vehiculo> listaVehiculos) {
        this.nombreCreador = nombreCreador;
        this.dni = dni;
        this.diasAlquiler = diasAlquiler;
        this.listaVehiculos = listaVehiculos;
    }

    public double calcularAlquilerUnVehiculo(Vehiculo v){
        double alquiler=(v.metrosTamanyo*v.anyoFabricacion)/100;
        if(v instanceof Batmovil){
            alquiler+=10% ((Batmovil) v).numRuedas;
        } else if(v instanceof PatineteVolador){
            alquiler+= ((PatineteVolador) v).potenciaCaballos;
        }
        return alquiler;
    }

    public void mostrarListado(){
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo vActual=listaVehiculos.get(i);
            if (vActual instanceof PatineteVolador){
                ((PatineteVolador) vActual).avisarPatinete();
            }
            System.out.println(vActual);
        }
    }

    public double calcularTotalRecaudado(){
        double recaudadoTotal = 0;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo vActual=listaVehiculos.get(i);
                recaudadoTotal+= calcularAlquilerUnVehiculo(vActual);
        }
        return recaudadoTotal;
    }

    public List<Vehiculo> getListaVehiculos(int index) {
        return (List<Vehiculo>) listaVehiculos.get(index);
    }

}
