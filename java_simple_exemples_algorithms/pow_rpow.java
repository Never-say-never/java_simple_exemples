/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	
	public static double pow(int power, double value) {
		if(power == 0 || value == 1) {
			return 1;
		}
		
		if(value == 0) {
			return value;
		}
		
		double tmp = value;
		
		boolean powerIsNegative = false;
		if(power < 0) {
			power *= -1;
			powerIsNegative = true;
		}
		
		for(int ix = 0; ix < power - 1; ++ix) {
			value *= tmp;
		}
		
		if(powerIsNegative) {
			return 1/value;
		}
		
		return value;
	}
	
	public static double rpow(int power, double value) {
		System.out.println("next : " + power + " " + value);
		
		if(power == 0 || value == 1) {
			return 1;
		}
		
		if(value == 0) {
			return 0;
		}
		
		if(power == 1) {
			return value;
		}
		
		if(power == -1) {
			return 1 / value;
		}

		if(power < 0) {
			power++;
			
			return (1 / value) * ( Ideone.rpow(power, value) );
			
		} else {
			power--;
			
			return value * Ideone.rpow(power, value);
		}
	
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//System.out.println(Ideone.pow(12,2));
		//System.out.println(Ideone.pow(-6,2));
		
		System.out.println(Ideone.rpow(2,3));
		System.out.println(Ideone.rpow(-3,2));
	}
}
