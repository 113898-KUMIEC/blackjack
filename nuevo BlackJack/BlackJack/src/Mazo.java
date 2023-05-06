import java.util.Arrays;
import java.util.Collections;

public class Mazo {
    Cartas cartas[] = new Cartas[52];
    int posicion;

    public void createCartas(){
        String simbolos = "23456789TJQKA";
        String tipos = "SCDH";
        int index = 0;

        for (int i=0; i<tipos.length();i++){
            for (int j=0; j<simbolos.length();j++){
                Cartas c = new Cartas();
                c.setSimbolo(simbolos.charAt(j));
                c.setType(tipos.charAt(i));
                this.cartas[index] = c;
                index++;
            }
        }
        mezclarCartas();
    }
    private void mezclarCartas(){
        Collections.shuffle(Arrays.asList(this.cartas));
    }

    public Cartas getCartas(){
        if (posicion == 51){
            System.out.println("No hay mas cartas que repartir");
            return null;
        }
        Cartas c = this.cartas[posicion];
        posicion++;
        return c;
    }
}
