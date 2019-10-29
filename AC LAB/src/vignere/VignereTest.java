package vignere;

import java.util.Scanner;

public class VignereTest {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter plain text");
		String pt=scan.nextLine();
		System.out.println("Enter key");
		String key=scan.nextLine();
		StringBuilder sb=new StringBuilder();
		if(key.length()<pt.length()) {
			
			for(int i=0;i<pt.length();) {
				for(int j=0;j<key.length()&&i<pt.length();j++,i++) {
					sb.append(key.charAt(j));
				}
			}
			System.out.println(sb.toString());
		}
		else if(key.length()>pt.length()) {
			sb.append(key);
			sb=new StringBuilder(sb.substring(0, pt.length()));
			System.out.println(sb.toString());
		}
		else
			sb.append(key);
		
		Vignere vignere=new Vignere();
		StringBuilder cipher=new StringBuilder();
		
			cipher=vignere.encrypt(sb.toString(),pt);
		
		
		System.out.println("Encrypted text is: ");
		System.out.println(cipher.toString());
		
		System.out.println("Decrypted text is: ");
		
		StringBuilder plain=new StringBuilder();
		plain=vignere.decrypt(sb.toString(), cipher.toString());
		System.out.println(plain.toString());
		
	}
	

}
