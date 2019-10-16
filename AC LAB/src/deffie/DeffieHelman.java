package deffie;

import java.util.Scanner;

public class DeffieHelman {
	long calculateKey(int a,int x,int n) {
		return power(a,x,n);
	}
	
	static long power(int a, int b, int mod) {
		long t;
		if(b==1)
			return a;
		t=power(a,b/2,mod);
		if(b%2==0)
			return (t*t)%mod;
		else
			return (((t*t)%mod)*a)%mod;
		
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the value of n and g");
		int n=scan.nextInt();
		int g=scan.nextInt();
		System.out.println("Enter the value of x");
		int x=scan.nextInt();
		int a=(int) power(g,x,n);
		System.out.println("Enter the value of y");
		int y=scan.nextInt();
		int b=(int) power(g,y,n);
		System.out.println("Key for the first person is "+ power(b,x,n) );
		System.out.println("key for the second person is "+power(a,y,n));
		

	}

}
