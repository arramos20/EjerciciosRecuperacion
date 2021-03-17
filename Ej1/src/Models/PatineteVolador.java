package Models;

public class PatineteVolador extends Vehiculo {

    int potenciaCaballos;

    public PatineteVolador(String matricula, double metrosTamanyo, int anyoFabricacion, int potenciaCaballos) {
        super(matricula, metrosTamanyo, anyoFabricacion);
        this.potenciaCaballos = potenciaCaballos;
    }

    public void avisarPatinete(){
        if(potenciaCaballos>20){
            System.out.println("¡Cuidado, patinete tuneado!\n");
        }
    }

}
