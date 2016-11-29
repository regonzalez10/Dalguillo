package puntos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Ricardo Enrique Gonzalez Peñuela 201425733
//Camilo Zambrano 201515438

public class ProblemaB 
{
	
	
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
