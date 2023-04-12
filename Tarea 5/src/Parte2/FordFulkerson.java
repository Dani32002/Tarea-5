package Parte2;

import java.util.*;

public class FordFulkerson {

    public int flujoMax(ArrayList<ArrayList<Integer>> matriz, int source, int sink){
        ArrayList<ArrayList<Integer>> residual = new ArrayList<>();
        for (int i = 0; i < matriz.size(); i++){
            residual.add(new ArrayList<Integer>());
            for (int j = 0; j < matriz.size(); j++){
                if (matriz.get(i).get(j) != 2147483647){
                    residual.get(i).add(matriz.get(i).get(j));
                } else {
                    residual.get(i).add(0);
                }
                
            }
        }
        boolean hayCamino = true;
        while (hayCamino){
            int[] predecesores = BFS(residual, source);
            if (predecesores[sink] == -2){
                hayCamino = false;
            } else {
                int minimo = minimoCapacidad(residual, predecesores, sink);
                actualizarFlujoCamino(residual, minimo, predecesores, sink);
            }
        }
        int flujoMax = 0;
        for(int k = 0; k < matriz.size(); k++){
            if (matriz.get(source).get(k)  != 2147483647){
                flujoMax += matriz.get(source).get(k) - residual.get(source).get(k);
            }
        }
        return flujoMax;
    }

    public void actualizarFlujoCamino(ArrayList<ArrayList<Integer>> residual, int minimo, int[] predecesores, int sink){
        int actual = sink;
        while (predecesores[actual] != -1){
            residual.get(predecesores[actual]).set(actual, residual.get(predecesores[actual]).get(actual) - minimo);
            residual.get(actual).set(predecesores[actual], residual.get(actual).get(predecesores[actual]) + minimo);
            actual = predecesores[actual];
        }
    }

    public int minimoCapacidad(ArrayList<ArrayList<Integer>> residual, int[] predecesores, int sink){
        int actual = sink;
        int minimo = (int)Double.POSITIVE_INFINITY;
        while (predecesores[actual] != -1){
            if (residual.get(predecesores[actual]).get(actual) < minimo) {
                minimo = residual.get(predecesores[actual]).get(actual);
            }

            actual = predecesores[actual];
        }
        return minimo;
    }


    public int[] BFS(ArrayList<ArrayList<Integer>> matriz, int source){
        int[] predecesores = new int[matriz.size()];
        Arrays.fill(predecesores, -2);
        boolean[] visitados = new boolean[matriz.size()];
        Queue<Integer> fila = new LinkedList<Integer>();
        fila.add(source);
        visitados[source] = true;
        predecesores[source] = -1;
        while(!fila.isEmpty()){
            int actual = fila.remove();
            for (int i = 0; i < matriz.size(); i++){
                if (matriz.get(actual).get(i) != 0 && !visitados[i]){
                    visitados[i] = true;
                    predecesores[i] = actual;
                    fila.add(i);
                }
            }
        }
        return predecesores;
    }

}
