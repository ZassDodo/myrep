package pt.upacademy.example1;

public class Hello {
	String s = "Hello"; 
	private String s2 = "Private Hello";
	static String s3 = "Static Hello";

	public Hello(String s, String s2) {
		super();
		this.s = s;
		this.s2 = s2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello app = new Hello("Public","Private");
		app.start();
	}
	private void  start() {
		System.out.println(s3);
		s3 = "New Hello Static";
		System.out.println(s3);
		System.out.println(s2);
		s2 = "New Hello Private";
		System.out.println(s2);
		System.out.println(s);
		s = "New Hello Public";
		System.out.println(s);
	}

}
