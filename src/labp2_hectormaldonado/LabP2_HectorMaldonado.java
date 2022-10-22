/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labp2_hectormaldonado;
import java.util.ArrayList;
import java.util.Scanner; 
/**
 *
 * @author hecto
 */
public class LabP2_HectorMaldonado {

    public static void printMatriz(char[][] matriz) {
        int fila = matriz.length;
        int columna = matriz[0].length;

        for (int i = 0; i < fila; ++i) {
            for (int j = 0; j < columna; ++j) {
                System.out.print("|");
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }
    }

    public static char[][] iniciarMatriz(char[][] matriz) {
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                matriz[i][j] = ' ';
            }
        }
        return matriz;
    }

    public static char[][] llenarMatriz(char[][] matriz, int n_jugadores) {
        int x = 0;
        int y = 0;
        int muros = 0;
        int bots = (int) (0.25 * n_jugadores + 1);
        while (muros < 300) {
            x = (int) (Math.random() * 30);
            y = (int) (Math.random() * 30);
            if (matriz[x][y] != 'X') {
                matriz[x][y] = 'X';
                muros++;
            }
        }
        char[] caracter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'};
        int i = 0;
        while (i < n_jugadores) {
            x = (int) (Math.random() * 30);
            y = (int) (Math.random() * 30);
            if (matriz[x][y] == ' ') {
                matriz[x][y] = caracter[i];
                i++;
            }
        }
        int j = 0;
        while (j < bots) {
            x = (int) (Math.random() * 30);
            y = (int) (Math.random() * 30);
            if (matriz[x][y] == ' ') {
                matriz[x][y] = '*';
                j++;
            }
        }

        return matriz;
    }

    public static char[][] actualizarEstado(char[][] matriz, int n_jugadores, ArrayList<Jugador> jugadores) {
        char[][] tablero_temp = new char[30][30];
        tablero_temp = matriz;
        for (int i = 1; i < 29; ++i) {
            for (int j = 1; j < 29; ++j) {
                if (tablero_temp[i][j] != ' ' && tablero_temp[i][j] != 'X') {
                    if (tablero_temp[i + 1][j] == ' ') {
                        matriz[i + 1][j] = tablero_temp[i][j];
                        matriz[i][j] = ' ';

                    } else if (tablero_temp[i - 1][j] == ' ') {
                        matriz[i - 1][j] = tablero_temp[i][j];
                        matriz[i][j] = ' ';

                    } else if (tablero_temp[i][j + 1] == ' ') {
                        matriz[i][j + 1] = tablero_temp[i][j];
                        matriz[i][j] = ' ';

                    } else if (tablero_temp[i][j - 1] == ' ') {
                        matriz[i][j - 1] = tablero_temp[i][j];
                        matriz[i][j] = ' ';

                    }

                }
            }

        }
        for (int i = 0; i < 30; ++i) {
            for (int j = 0; j < 30; ++j) {
                if (tablero_temp[i][j] == '*') {
                    if (matriz[i][j] == 'a' || matriz[i][j] == 'b' || matriz[i][j] == 'c' || matriz[i][j] == 'd' || matriz[i][j] == 'e' || matriz[i][j] == 'f' || matriz[i][j] == 'g' || matriz[i][j] == 'h' || matriz[i][j] == 'i' || matriz[i][j] == 'j' || matriz[i][j] == 'k' || matriz[i][j] == 'l' || matriz[i][j] == 'm' || matriz[i][j] == 'n') {
                        System.out.println("Yupi derribó a Bryan");
                        System.out.println("*Audio PostMortem*");
                        matriz[i][j] = ' ';
                    }

                }
            }

        }

        return matriz;
    }

    static Scanner lea = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n_jugadores = 0;
        boolean menu = true;
        System.out.println("");
        System.out.println("-------------------------");
        System.out.println("Bienvenido a Evade");
        System.out.println("-------------------------");
        System.out.print("Ingrese la cantidad de Jugadores: ");
        n_jugadores = lea.nextInt();
        char[][] tablero = new char[30][30];
        tablero = iniciarMatriz(tablero);
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
        if (n_jugadores < 13) {
            char[] caracter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n'};
            for (int i = 0; i < n_jugadores; ++i) {
                Jugador jugador = new Jugador();
                jugador.setNombre("jugador" + i);
                jugador.setCaracter(caracter[i]);
                jugadores.add(jugador);
            }
            tablero = llenarMatriz(tablero, n_jugadores);
        }
        int numero_turnos = n_jugadores * 5;
        int k = 0;
        int contador = 0;
        System.out.println("Los jugadores son: ");
        for (int i = 0; i < jugadores.size(); ++i) {
            System.out.print(jugadores.get(i).getNombre());
            System.out.println(" caracter: " + jugadores.get(i).getCaracter());
        }
        System.out.println(" Cada jugador cuenta con 200 puntos. Si pierde se le reducira a 50 puntos");
        while (menu == true) {
            printMatriz(tablero);
            System.out.print("Cambiar estado.");
            k = lea.nextInt();
            tablero = actualizarEstado(tablero, n_jugadores, jugadores);
            numero_turnos++;
            if (contador == numero_turnos) {
                menu = true;
            }
        }

    }
}

