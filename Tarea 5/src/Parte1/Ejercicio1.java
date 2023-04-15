package Parte1;

import java.io.IOException;
import java.util.ArrayList;

import modulo.Carga;

public class Ejercicio1 {
    public static void main(String[] args) throws NumberFormatException, IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Carga carga = new Carga();		
		String ejeArbol = Ejercicio1.class.getPackage().getName() + "." + args[0];
		@SuppressWarnings("deprecation")
		ArbolRecubrimiento calculadora = (ArbolRecubrimiento) Class.forName(ejeArbol).newInstance();
        ArrayList<ArrayList<Integer>> matriz = carga.cargarMatriz(args[1]);

        long inicioTiempo = System.currentTimeMillis();
        ArrayList<ArrayList<Integer>> arb_rec = calculadora.ejesArbol(matriz);
		long finalTiempo = System.currentTimeMillis();

        System.out.println(arb_rec);

    }
}
