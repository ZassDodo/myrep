package pt.upacademy.example1;

public class AppScanner {
	
	private ScannerUtils scUtil = new ScannerUtils();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppScanner app = new AppScanner();
		app.start();
				

	}
	private void start() {
		int[] values = {1, 2, 3, 4};
		int result = scUtil.getInt("Escreva um numero de: 1 a 4.", values);
		System.out.println(result);
	}
}
	
	
//	private void start() {
//		
//		int loopcount = scUtil.getInt("Escreva um enteiro.", 1, 20);
//		System.out.println(loopcount);
//
//	}
//		
//	};

//import java.util.Scanner;
//
//public class AppScanner {
//	
//	private Scanner sc = new Scanner(System.in);
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		AppScanner app = new AppScanner();
//		app.start();
//				
//
//	}
//	
//	private void start() {
//		System.out.println("FizzBuzzLigther quer jerar novo numaro!!! Me ajuda-me:");
//		String loopcount = sc.nextLine();
//		long count = Long.parseLong(loopcount);
//		if(count <= 50) {
//		resolveFizz(count);
//	} else {
//    	System.out.println("O numaro tem de ser entre 0 a 50!");
//    	start();
//
//	}
//		
//	};
//	
//	private void resolveFizz(long count) {
//
//	    for (int i=0; i < count; i++) {
//
//	    if (i%3 == 0 && i%5 == 0){
//	    	System.out.println("Numero " + i + " : FizzBuzz");
//
//
//	    } else if (i%5 == 0) {
//	        System.out.println("Numero " + i + " : Buzz");
//
//	    } else if (i%3 == 0) {
//	    	System.out.println("Numero " + i + " : Fizz");
//	  
//
//	    } 
//	    
//	    };
//
//		
//	}
//
//}
