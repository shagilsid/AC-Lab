package deffie;

import java.util.Scanner;

public class DeffieHelman {
	long calculateKey(int a,int x,int n) {
		return power(a,x,n);
	}
	
	static long power(int a, int b, int q) {
		long t;
		if(b==1)
			return a;
		t=power(a,b/2,q);
		if(b%2==0)
			return (t*t)%q;
		else
			return (((t*t)%q)*a)%q;
		
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the value of q and alpha");
		int q=scan.nextInt();
		int alpha=scan.nextInt();
		System.out.println("Enter the value of x for user A");
		int x=scan.nextInt();
		int a=(int) power(alpha,x,q);
		System.out.println("Enter the value of x for user B");
		int y=scan.nextInt();
		int b=(int) power(alpha,y,q);
		System.out.println("Key for the first person is "+ power(b,x,q) );
		System.out.println("key for the second person is "+power(a,y,q));
		

	}

}
