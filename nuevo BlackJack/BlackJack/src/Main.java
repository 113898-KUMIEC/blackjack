import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean cambio = true;
        boolean cambioTotal = true;

        Mazo m = new Mazo();
        m.createCartas();

        int contadorJugador = 0;
        int contadorComputadora = 0;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Scanner s = new Scanner(System.in);

        String teclado = "";

        while (cambioTotal){
            Mano manoComputadora = new Mano();
            Mano manoJugador = new Mano();

            manoComputadora.agregarCarta(m.getCartas());
            manoComputadora.agregarCarta(m.getCartas());

            manoJugador.agregarCarta(m.getCartas());
            manoJugador.agregarCarta(m.getCartas());

            while (manoComputadora.getValor()<=16){
                manoComputadora.agregarCarta(m.getCartas());
            }
            System.out.println("Tus cartas "+ manoJugador.toString());
            System.out.println("Que desea hacer? Otra [o] p Plantarse [p]");
            while ((teclado = s.nextLine()) != null){
                while (teclado.equalsIgnoreCase("o")){
                    manoJugador.agregarCarta(m.getCartas());
                    if (manoJugador.getValor() > 21){
                        System.out.println("Tus cartas "+ manoJugador.toString());
                    }else {
                        System.out.println("Tus cartas "+ manoJugador.toString());
                        System.out.println("Que desea hacer? Otra [o] p Plantarse [p]");
                        teclado = s.nextLine();
                    }

                     if (manoJugador.getValor() == 21) {
                        System.out.println("Tus cartas "+ manoJugador.toString());
                        System.out.println("las cartas de la casa "+ manoComputadora.toString());
                        System.out.println("Ganaste vos!!");
                        contadorJugador++;
                        break;
                    }
                }
                if (teclado.equalsIgnoreCase("p")){
                    System.out.println("las cartas de la casa "+ manoComputadora.toString());
                    System.out.println("Tus cartas "+ manoJugador.toString());
                    if (manoComputadora.getValor() == 21 || manoJugador.getValor() > 21){
                        System.out.println("La casa gana");
                        contadorComputadora++;
                    } else if (manoJugador.getValor() == 21 || manoComputadora.getValor() > 21) {
                        System.out.println("Ganaste vos!!");
                        contadorJugador++;

                    } else if (manoComputadora.getValor() > manoJugador.getValor() && manoComputadora.getValor() < 21){
                        System.out.println("La casa gana");
                        contadorComputadora++;

                    } else if (manoComputadora.getValor() < manoJugador.getValor() && manoJugador.getValor() < 21) {
                        System.out.println("Ganaste vos!!");
                        contadorJugador++;

                    }else {
                        System.out.println("Es un empate!!");

                    }
                }

                System.out.println("\nQueres volver a jugar?\n" +
                        "1- si\n" +
                        "2- no");
                String respuesta = s.nextLine();

                if (respuesta.equals("1")){
                    break;
                }else if (respuesta.equals("2")){
                    cambioTotal = false;
                    cambio = false;
                    System.out.println("La casa gano: " + contadorComputadora + " partidas");
                    System.out.println("El jugador gano: " + contadorJugador + " partidas");
                    break;
                }
            }
        }
    }
}