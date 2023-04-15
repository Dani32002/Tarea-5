package Parte1;

import java.util.ArrayList;

public class Prim implements ArbolRecubrimiento {

    @Override
    public ArrayList<ArrayList<Integer>> ejesArbol(ArrayList<ArrayList<Integer>> matriz) {
        ArrayList<ArrayList<Integer>> prueba = new ArrayList<>();

        for (int i=0 ; i<matriz.size(); i++){
            prueba.add(i, matriz.get(i));
        }

        return prueba;
    }
    
}
