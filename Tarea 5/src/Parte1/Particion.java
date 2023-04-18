package Parte1;
import java.util.*;

public class Particion {
	int n;
	int[] subsets; //Indices = elementos, Valor = conjunto al que pertenecen.

	public Particion(int n){
		//Complejidad de O(n)
		subsets = new int[n];
		for(int i = 0; i < n; i++){
			subsets[i] = i;
		}
	}

	public int find(int v){
		//Complejidad de O(1)
		return subsets[v];
	}

	public boolean sameSubset(int v1, int v2){
		//Complejidad O(1)
		boolean valor = false;
		if(find(v1) == find(v2)) {
			valor = true;
		}
		return valor;
	}

	public void union(int v1, int v2){
		//Complejidad de O(n)
		int s1 = find(v1);
		int s2 = find(v2);
		for(int i=0; i < n; i++){
            if(subsets[i] == s1){
                subsets[i] = s2;
            }
        }
	}

	public static void main(String[] args) {
		
	}
}
