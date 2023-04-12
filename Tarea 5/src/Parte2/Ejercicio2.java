package Parte2;

import java.io.IOException;
import java.util.ArrayList;

import modulo.Carga;

public class Ejercicio2 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        Carga carga = new Carga();
		FordFulkerson calculadora = new FordFulkerson();
        ArrayList<ArrayList<Integer>> matriz = carga.cargarMatriz(args[0]);

        long inicioTiempo = System.currentTimeMillis();
        int flujoMax = calculadora.flujoMax(matriz, Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		long finalTiempo = System.currentTimeMillis();

        System.out.println("El flujo maximo es: " + flujoMax);
		System.out.println("Tiempo Total (milisegundos): "+(finalTiempo-inicioTiempo));
    }
}
