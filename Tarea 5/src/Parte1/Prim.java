package Parte1;

import java.util.ArrayList;
import java.util.Collections;

public class Prim implements ArbolRecubrimiento {

    @Override
    public ArrayList<ArrayList<Integer>> ejesArbol(ArrayList<ArrayList<Integer>> matriz) {
    	
    	int inicio = 0;
        ArrayList<Integer> keys = new ArrayList<>();
        ArrayList<Integer> padre = new ArrayList<>();
        ArrayList<ArrayList<Integer>> minA = new ArrayList<>();
        ArrayList<Integer> Vnovisit = new ArrayList<>();
        for(int v = 0; v<matriz.size(); v++) {
        	keys.add(v, (int) Double.POSITIVE_INFINITY);
        	padre.add(v, null);
        	Vnovisit.add(v);
        }
        keys.set(inicio, 0);
        while (!Vnovisit.isEmpty()) {
        	int u = keys.indexOf(Collections.min(keys));
        	keys.set(u, (int) Double.POSITIVE_INFINITY);
        	Vnovisit.remove(Vnovisit.indexOf(u));
        	for (int j = 0; j<matriz.get(u).size(); j++) {
        		if (matriz.get(u).get(j) != (int) Double.POSITIVE_INFINITY){
        			if(Vnovisit.contains(j) && matriz.get(u).get(j)<keys.get(j)) {
        				keys.set(j, matriz.get(u).get(j));
        				padre.set(j, u);
        			}
        		}
        		
        	}
        }
        ArrayList<Integer> verticeArb = new ArrayList<>();
        for (int k = 1; k<padre.size();k++) {
        	verticeArb.add(0, k);
        	verticeArb.add(1, padre.get(k));
        	minA.add(verticeArb);
        	verticeArb = new ArrayList<>();
        }
        return minA;
    }
    
}
