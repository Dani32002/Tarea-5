package modulo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Carga {
	
	public ArrayList<ArrayList<Integer>> cargarMatriz(String nomArchivo) throws NumberFormatException, IOException {
		BufferedReader lector = new BufferedReader(new FileReader("./datos/" + nomArchivo));
		String linea;
		ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();
		while ((linea = lector.readLine()) != null) {
			String[] strNums = linea.split("\t");
			ArrayList<Integer> lineaNums = new ArrayList<>();
			for (int i = 0; i < strNums.length; i++) {
				if (!strNums[i].equals("-1")) {
					lineaNums.add(Integer.parseInt(strNums[i]));
				} else {
					lineaNums.add(Math.abs((int)Double.POSITIVE_INFINITY));
				}
			}
			matriz.add(lineaNums);
		}
		lector.close();
		return matriz;
	}
}
