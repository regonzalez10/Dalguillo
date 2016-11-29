package puntos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemaB 
{
	
	
//	B Credibilidad
//	Supóngase que se dispone de un arreglo A[0..n-1]:int, con n>0, que guarda el
//	estado de una cuenta bancaria durante el intervalo de tiempo 0..n-1. Para 0≤p≤q≤n,
//	se define cred(p,q), la credibilidad de la cuenta en el intervalo p..q-1,
//	como la diferencia entre el número de valores positivos y negativos en el segmento, i.e.,
//	cred(p,q) = (#i| p≤i<q : A[i]>0) - (#i| p≤i<q : A[i]<0).
//	Problema
//	Encontrar p,q tales que cred(p,q)sea máxima.
//	Ejemplo:
//	Supóngase A[0..9] =[-43,-43,-12,-20,39,42,27,-32,24,-47].
//	En este caso se puede responder p=4, q=9. El segmento [39,42,27,-32,24] tiene 4 valores 
//	positivos y uno negativo, de modo que cred(4,9)=3. Este valor es maximal dentro de A, 
//	aunque también cred(4,7)=3, de modo que también se podría responder p=4, q=7.
	
	public static void main(String[] args) throws IOException 
	{
	
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))

		{
			
//			primera linea para saber el tamaño de n1.. n2.. n3...
			String tamanio = br.readLine();
			
//			mientras existan mas casos (mas lineas)
			while(!tamanio.equals(""))
			{
				int tam = Integer.parseInt(tamanio);
//				 Segunda linea contiene los numeros
				String valores = br.readLine();
//				Se obtiene los valores, 1 recorrido tam n1.. n2..n3..
				String[] vals = valores.split(" ");
				

//				Credibilidad		
				int r =0;
//				Credibilidad centinela
				int rcampeon = 0;
				int p = 0;
				int pcampeon = 0;
				int qcampeon = -1;
//				Ciclo interno, se calcula en cada paso la credibilidad y se compara con el centinela, si en algun momento la credibilidad se vuelve negativa, se asume que ese subconjunto no es util, y se mueve el p(donde inicia el subconjunto)
				for (int q = 0; q<tam;q++)
					{

					if(vals[q].startsWith("-"))
					{
						r--;
					}
					else
					{

						r++;
					}
					if(r < 0)
					{
						r= 0;
						p = q +1;
					}
					if(rcampeon<r)
					{
						rcampeon = r;
						pcampeon = p;
						qcampeon = q;
						


					
					}
				
				
				
				
				
			
				}
//				Se le suma 1 para que marque el rango correcto en expresion natural
				qcampeon++;
//				Al p no se le tiene que sumar porque comienza sobre la posicion correcta
				System.out.println(rcampeon+" "+pcampeon+" "+qcampeon);
				 tamanio = br.readLine();
			
				
			   
			}
		}
	}
	
}
