package ar.edu.untref.aydoo;

import java.util.Vector;


public class FactoresPrimos {
	
	
	
	 public static Vector<Integer> factor(int numeroPasado)
	    {
		
		 Vector<Integer> vectorDevolver = new Vector<Integer>();
	         int nro = 2;

	         while(numeroPasado!=1)
	         {
	              while(numeroPasado%nro==0)
	              {
	            	  vectorDevolver.add(nro);
	                   numeroPasado /= nro;
	              }
	              nro++;
	         }
	         return vectorDevolver;
	    }
	
	

	
}