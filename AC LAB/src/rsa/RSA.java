package rsa;

import java.util.Scanner;

public class RSA {

	public static void main(String[] args) {
		System.out.println("Enter value of p,q,e, plain text");
		Scanner scan=new Scanner(System.in);
		int p=scan.nextInt();
		int q=scan.nextInt();
		int e=scan.nextInt();
		int pt=scan.nextInt();
		int n=p*q;
		int phi=(p-1)*(q-1);
		
		int d=calculateD(e,phi);
		System.out.println("d: "+d);
		long c=power(pt,e,n);
		System.out.println("c: "+c);
		long pp=power((int)c,d,n);
		System.out.println("Ecnrypted message is "+c);
		System.out.println("Decrypted message is "+pp);
		


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
	private static int calculateD(int e, int phi) {
		int i=1;
		while((e*i)%phi!=1) {
			i++;
		}
		return i;
	}	
	

}
