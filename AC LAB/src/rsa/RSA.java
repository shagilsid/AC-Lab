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
		int c=(int)(Math.pow(pt,e))%n;
		int pp=(int)(Math.pow(c,d))%n;
		System.out.println("Ecnrypted message is "+Math.pow(pt,e)%n);
		System.out.println("Decrypted message is "+pp);
		


	}
	private static int calculateD(int e, int p) {
		int i=1;
		while((e*i)%p!=1) {
			i++;
		}
		return i;
	}	
	

}
