package rsa;

import java.util.Random;
import java.util.Scanner;

public class RSA {

	static int n,e, d=1;
	static char val[] = new char[50];

	static char decode(int ch) {
		int i;
		int temp = ch;
		for (i = 1; i < d; i++)
			ch = (temp * ch) % n;
		return ((char)ch);
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return (gcd(b, a % b));

	}

	static boolean prime(int a) {
		int i;
		for (i = 2; i < a; i++) {
			if ((a % i) == 0)
				return false;

		}
		return true;
	}

	static char encode(char ch) {
		int i;
		int temp = ch;
		for (i = 1; i < e; i++)
			temp = (temp * ch) % n;
		return ((char)temp);
	}

	public static void main(String[] args) throws Throwable {
		int i;
		int p, q, phi;
		int c[] = new int[50];

		Random rand =  new Random();

		Scanner sc = new Scanner(System.in);

		String text;
		String cText;
		// char text[50],ctext[50];
		System.out.println("Enter the text to be encoded \n");
		text = sc.nextLine();
//	gets(text);
		System.out.println("text");
		
		do {
			p = rand.nextInt(10) + 1;
			
		} while (!prime(p) || p==1);
		
		do {
			q = rand.nextInt(10) + 1;
			
		} while (!prime(q) ||q==1||p==q);

		n = p * q;
		phi = (p - 1) * (q - 1);
		System.out.println("\n p="+p+"\t q="+q+" n="+n +" phi="+phi+" \n");
		boolean checkE=false;
		
		do {
			e = rand.nextInt(phi);
			
		} while (gcd(e, phi)!=1||e<=1);
		
		System.out.println("Value of e is: "+e);
		
		
		do {
			d++;
			
		} while ((d * e % phi) != 1||d==e);
		
		System.out.println("Value of d is: "+d);
		
		for (i = 0; i<text.length(); i++)
			val[i]= encode(text.charAt(i));
		val[i] = '\0';
		System.out.println("**** encoded message *** \n");
		for (i = 0; val[i] != '\0'; i++)
			System.out.println(val[i]);
		
		StringBuilder sb= new StringBuilder();
		for (i = 0; val[i] != '\0'; i++)
		{
			
			sb.append(decode((char)val[i]));
			
		}
		cText=sb.toString();
		
		System.out.println("\n **** decoded message :****\n"+ cText);
	}

}