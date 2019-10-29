package vignere;

public class Vignere {
StringBuilder encrypt(String key,String plain){
		
		StringBuilder cipher=new StringBuilder();
		

		for(int i=0;i<plain.length();i++){
			if(Character.isUpperCase(plain.charAt(i))){
				char ch=(char)(((int)plain.charAt(i)-65+(int)key.charAt(i)-65)%26+65);
				cipher.append(ch);
			}
			else{
				char ch=(char)(((int)plain.charAt(i)-97+(int)key.charAt(i)-97)%26+97);
				cipher.append(ch);
			}
			
		}

		return(cipher);
	}


StringBuilder decrypt(String key,String cipher ){
	StringBuilder plain=new StringBuilder();

	for(int i=0;i<cipher.length();i++){
		if(Character.isUpperCase(cipher.charAt(i))){
			int keyMod=((int)cipher.charAt(i)-65)-((int)key.charAt(i)-65);
			if(keyMod<0){
				keyMod=keyMod+26;}
			char ch=(char)((keyMod)%26+65);
			
			plain.append(ch);
		}
		else{
			int keyMod=((int)cipher.charAt(i)-97)-((int)key.charAt(i)-97);
			if(keyMod<0){
				
				keyMod=keyMod+26;}
			
			char ch=(char)((keyMod)%26+97);
			
			plain.append(ch);
		}
}

return plain;
}

}
