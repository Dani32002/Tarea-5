package Parte1;

import java.io.IOException;
import java.util.ArrayList;

import modulo.Carga;

public class Ejercicio1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Carga carga = new Carga();
		Prim calculadora = new Prim();
        ArrayList<ArrayList<Integer>> matriz = carga.cargarMatriz(args[0]);

        long inicioTiempo = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> arb_rec = calculadora.ejesArbol(matriz);
		long finalTiempo = System.currentTimeMillis();

        System.out.println(arb_rec);

    }
}
