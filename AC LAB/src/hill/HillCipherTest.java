package hill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class HillCipherTest {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter text");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String text=br.readLine();
		System.out.println("Enter values of a,b,c,d");
		int a=Integer.parseInt(br.readLine());
		int b=Integer.parseInt(br.readLine());
		int c=Integer.parseInt(br.readLine());
		int d=Integer.parseInt(br.readLine());
		int size=text.length()/2;
		int[][] pblocks=new int[size][2];
		int[][] cblocks=new int[size][2];
		int l=0;
		for(int j=0;j<size;j++) {
			for(int k=0;k<2;k++) {
				pblocks[j][k]=text.charAt(l++);
			}
		}
		EyncDec eyncDec=new EyncDec(pblocks,cblocks,size,a,b,c,d);
		eyncDec.encryption();
		eyncDec.decryption();
		
	}

}
