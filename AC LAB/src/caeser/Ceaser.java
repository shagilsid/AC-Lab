package caeser;
import java.util.*;
class Ceaser{
	static Scanner input;

	public static void main(String[] args){
		input=new Scanner(System.in);
		System.out.println("Welcome to CEASER CYPHER\n");
		System.out.println("Enter Key value");
		int key=input.nextInt();
		StringBuilder cipher=encrypt(key);
		System.out.println("Encryted Text: "+cipher.toString());
		StringBuilder plain=decrypt(cipher,key);
		System.out.println("Decrypted Text: "+plain.toString());
		
	}

	static StringBuilder encrypt(int key){
		System.out.println("Enter plain text");
		input.nextLine();
		String temp=input.nextLine();
		StringBuilder plain=new StringBuilder(temp);
		StringBuilder cipher=new StringBuilder();
		
		

		for(int i=0;i<plain.length();i++){
			if(Character.isUpperCase(plain.charAt(i))){
				char ch=(char)(((int)plain.charAt(i)+key-65)%26+65);
				cipher.append(ch);
			}
			else{
				char ch=(char)(((int)plain.charAt(i)+key-97)%26+97);
				cipher.append(ch);
			}
			
		}

		return(cipher);
	}

	static StringBuilder decrypt(StringBuilder cipher,int key ){
		StringBuilder plain=new StringBuilder();

		for(int i=0;i<cipher.length();i++){
			if(Character.isUpperCase(cipher.charAt(i))){
				int keyMod=(int)cipher.charAt(i)-key-65;
				if(keyMod<0){
					keyMod=keyMod+26;}
				char ch=(char)((keyMod)%26+65);
				
				plain.append(ch);
			}
			else{
				int keyMod=(int)cipher.charAt(i)-key-97;
				if(keyMod<0){
					keyMod=keyMod+26;}
				char ch=(char)((keyMod)%26+97);
				
				plain.append(ch);
			}
	}

	return plain;
}
}
