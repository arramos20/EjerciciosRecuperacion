package Models;

public class Batmovil extends Vehiculo {

    int numRuedas;

    public Batmovil(String matricula, double metrosTamanyo, int anyoFabricacion, int numRuedas) {
        super(matricula, metrosTamanyo, anyoFabricacion);
        this.numRuedas = numRuedas;
    }
}
