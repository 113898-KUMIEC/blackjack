import java.util.ArrayList;

public class Mano {
    ArrayList<Cartas> arr = new ArrayList<Cartas>();
    int posicion = 0;

    public void agregarCarta(Cartas c){
        arr.add(c);
    }

    public int getValor(){
        int val = 0;
        boolean ace = false;
        for (int i=0; i<arr.size();i++){
         Cartas c = arr.get(i);
         int cartaValor = c.getValue();
         if (cartaValor>10){
             cartaValor = 10;
         }
         if (cartaValor ==1){
             ace = true;
         }
         val += cartaValor;
        }
        if (ace == true && val+10 <= 21){
            val = val + 10;
        }
        return val;
    }

    @Override
    public String toString() {
        String mano = "";
        for (int i=0; i<arr.size();i++){
            mano += arr.get(i).toString() + " ";
        }
        return mano;
    }
}
