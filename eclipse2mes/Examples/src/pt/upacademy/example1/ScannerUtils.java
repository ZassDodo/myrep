package pt.upacademy.example1;

import java.util.Scanner;

public class ScannerUtils {
	
	private Scanner sc = new Scanner(System.in);
	
	public int getInt(String msg) {
		System.out.println(msg);
	
	      while (sc.hasNextInt() == false) {
	    	  System.out.println("Tens de escolher apenas as opessoas a cima disponiveis");
	    	  sc.nextLine();
	      }
	       int input = sc.nextInt();
	       return input;
		
	}
	
	public int getInt(String msg, int[] values) {
		int resultVal = 0;
		resultVal = getInt(msg);
		boolean testResult = false;
		
		
			
			for (int i=0; i< values.length; i++) {
				if (resultVal == values[i]) {
					testResult = true;
				} 
			}
			if (testResult == false) {
				resultVal = getInt("Tem de escrever um numaro: 1, 2 ,3 ou 4. Te dou mais 1 oportunidade", values);
			}
		
		return resultVal;
		
	}
}
	
	
//	public int getInt(String msg) {
//		System.out.println(msg);
//	
//	      while (sc.hasNextInt() == false) {
//	    	  System.out.println("Repito: escreva um enteiro!");
//	    	  sc.nextLine();
//	      }
//	       int input = sc.nextInt();
//	       return input;
//		
//	}
//	
//	public int getInt(String msg, int min, int max) {
//		int result = 0;
//		result = getInt(msg);
//
//    	
//		 do {
//
//			if (result > max  || result < min ) {
//		    	System.out.println("O numaro tem de ser entre 0 a 20");
//			sc.hasNextInt();
//		} 
//		 } while (result < min || result > max);
//		
//		 return result;
//		
//		
//	}
//
//}
//
