package Parte1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Kruskal implements ArbolRecubrimiento{

    @Override
    public ArrayList<ArrayList<Integer>> ejesArbol(ArrayList<ArrayList<Integer>> matriz) {
    	//Declaración de estructuras
    	ArrayList<ArrayList<Integer>> conjuntoArcos = new ArrayList<>();
    	ArrayList<ArrayList<Integer>> mst = new ArrayList<>();
        //Conjunto de arcos del grafo
        for (int i = 0; i < matriz.size(); i++) {
            for (int j = 1 + i; j < matriz.size(); j++) {
                if (matriz.get(i).get(j) != Math.abs((int)Double.POSITIVE_INFINITY)) {
                	ArrayList<Integer> arco = new ArrayList<>();
                	arco.add(i);
                	arco.add(j);
                	arco.add(matriz.get(i).get(j));
                	conjuntoArcos.add(arco);
                }
            }
        }
        //Ordenar arcos segun su peso
        Collections.sort(conjuntoArcos, (a, b) -> a.get(2) - b.get(2));
        Particion particion = new Particion(matriz.size());
        //Proceso de Kruskal
        for (ArrayList<Integer> arco : conjuntoArcos) {
            int u = arco.get(0);
            int v = arco.get(1);
            if (particion.sameSubset(u, v) == false) {
                particion.union(u, v);
                ArrayList<Integer> arcoValido = new ArrayList<>();
                arcoValido.add(u);
                arcoValido.add(v);
                mst.add(arcoValido);
            }
        }
        return mst;
    }
}
