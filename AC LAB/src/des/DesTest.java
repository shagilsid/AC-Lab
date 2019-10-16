package des;

import java.util.Scanner;

public class DesTest {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter text <= 64 length");
		char[] pt=new char[64];
		String stringpt=scan.nextLine();
		
		for(int i=0;i<stringpt.length();i++) {
			pt[i]=stringpt.charAt(i);
			
		}
		for(int j=stringpt.length();j<64;j++)
			pt[j]='0';
		
//		if(pt.) {
//			System.out.println("Error, bye");
//			return;
//		}
//		System.out.println(pt.bitCount(pt));
		DesCrpyto des=new DesCrpyto();
		des.divideIntoBlock(pt);
//		for(int i=0;i<16;i++)
		des.encryption();
		System.out.println("Enncrypted text is:");
		des.printText();
//		for(int i=0;i<16;i++)
		System.out.println("Decrypted text is:");
		des.decryption();
		
		des.printText();
//		System.out.print(pt.length());
		
	}

}
