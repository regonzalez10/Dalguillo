package puntos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



//Ricardo Enrique Gonzalez Peñuela 201425733
//Camilo Zambrano 201515438
public class ProblemaA {

	public static void main (String args[]) throws IOException  // entry point from OS
    {

		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))

		{
			
//			primera linea para saber el tamaño de n1.. n2.. n3...
			String tamanio =br.readLine();
			while(tamanio!=null)
			{
				String[] values = tamanio.split(" ");
				int[] vals = new int[values.length-1];
				int[] nums = new int[3];
				
				int[] resp = new int[vals.length];
				boolean conseguimos = false;
				for(int k = 1;k< values.length ;k++)
				{
					vals[k-1]= Integer.parseInt(values[k]);
				}
				
				for(int i = 0; i<vals.length-1&& conseguimos == false;i++)
				{
					for(int j=i+1; j<vals.length&& conseguimos == false;j++)
					{
						nums = ExtendedEuclid(vals[i],vals[j]);
						if(nums[0]==1)
						{
							resp[i] = nums[1];
							resp[j] = nums[2];
							conseguimos = true;
						}
						
					}
				}
				
				if(conseguimos == true)
				{
					for(int f = 0; f<resp.length;f++)
					{
						System.out.print(resp[f]+" ");
					}
				}
				else
					System.out.println("*");
				
				conseguimos = false;
				tamanio = br.readLine();
			}
		}
    

    }
	
//Tomado de : https://cgi.csc.liv.ac.uk/~martin/teaching/comp202/Java/GCD.html
//Tomado el día: 28 de noviembre de 2016, 16:13 GMT:-5:00
//Autor: Rusell Martin
//O(log (max ({a, b})
    public static int[] ExtendedEuclid(int a, int b)
    /*  This function will perform the Extended Euclidean algorithm
        to find the GCD of a and b.  We assume here that a and b
        are non-negative (and not both zero).  This function also
        will return numbers j and k such that 
               d = j*a + k*b
        where d is the GCD of a and b.
    */
    { 
        int[] ans = new int[3];
        int q;

        if (b == 0)  {  /*  If b = 0, then we're done...  */
            ans[0] = a;
            ans[1] = 1;
            ans[2] = 0;
        }
        else
            {     /*  Otherwise, make a recursive function call  */ 
               q = a/b;
               ans = ExtendedEuclid (b, a % b);
               int temp = ans[1] - ans[2]*q;
               ans[1] = ans[2];
               ans[2] = temp;
            }

        return ans;
    }

}
