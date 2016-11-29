package puntos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// Ricardo Enrique Gonzalez Peñuela 201425733
// Camilo Zambrano 201515438
public class ProblemaC {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			String r= br.readLine();
			while(!r.equals("")){
				String tam[] = r.split(" ");
				int m =Integer.parseInt(tam[0]);//filas
				int n =Integer.parseInt(tam[1]);//columnas
				//se crean variables para guardar el máximo
				int maxC=0;// guarda el valor de la máxima fila
				int actualC=0; //guarda el valor actual de la fila
				int [][] verticales = new int[n][2];//este arreglo guarda en la primera fila el tamaño maximo de cada columna y en la segunda el tamaño actual de cada columna.

				// ciclo para recorrer cada linea m veces y calcular la cantidad de 1 máximos en las filas y columnas.
				int i=0;
				int j=0;
				String fila=br.readLine();//string con la primera fila de la entrada
				while(i<m && j<=n){
					/**
					 * se recorren la fila hasta que j==n
					 */
					if(j<n){
						int pos= Character.getNumericValue(fila.charAt(j));
						/**
						 * al encontrar un 1 actualiza los contadores actuales de la columna y el de la fila en donde está
						 * si encuentra un 0 reviza los contadores máximos de la columna y el de esa fila y los actualiza.
						 */
						if(pos==1){
							verticales[j][1]++;
							actualC++;
							j++;
						}else if(pos==0){
							if(verticales[j][0]<verticales[j][1]){
								verticales[j][0]=verticales[j][1];
							}
							verticales[j][1]=0;
							if(actualC>maxC){
								maxC=actualC;
							}
							actualC=0;
							j++;
						}
						/**
						 * una vez que j==n se pide la siguiente fila, se actualizan los contadores de máximo
						 */
					}else{
						if(actualC>maxC){
							maxC=actualC;
						}
						actualC=0;
						j=0;
						i++;
						if(i!=m){						
							fila=br.readLine();
						}
					}
				}
				//ahora es necesario recorrer la primera fila de la matriz verticales para encontrar cual fue la columna máxima.
				int maxV=0;
				i=0;
				while(i<n){
					//si en lo que va se encuentra un valor mayor, se actualiza maxV.
					if(maxV<verticales[i][0] &&verticales[i][1]<verticales[i][0]){
						maxV=verticales[i][0];
					}else if(maxV<verticales[i][1] && verticales[i][0]<verticales[i][i]) {
						maxV=verticales[i][1];
					}
					i++;
				}

				//luego se revisa cual de los máximos es el más grande y se imprime la respuesta.
				if(maxC>maxV){
					System.out.println("H"+maxC);
				}else{
					System.out.println("V"+maxV);
				}
				r = br.readLine();
			}

		}catch (Exception e) {
			//evade excepciones.
		}
	}


}
