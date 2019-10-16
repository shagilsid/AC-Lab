package des;


public class DesCrpyto {
	char left[];
	char right[];
	char temp[];
	public DesCrpyto() {
		left=new char[32];
		right= new char[32];
		temp=new char[32];
	}
	void encryption(){
		
		for(int i=0;i<right.length;i++)
			temp[i]=right[i];
		right=performXor(left, right);
		left=temp;
		
		
		
	}
	
	void decryption() {
//		
		right=performXor(left, right);
		for(int i=0;i<right.length;i++)
			temp[i]=left[i];
		left=right;
		right=temp;
		
	}


	private char[] performXor(char[] left, char[] right) {
		
		for(int i=0;i<right.length;i++) {
			char xor=(char)(left[i]^right[i]);
			if(xor=='\u0000')
				right[i]='0';
			else
				right[i]=xor;
		}
		return right;
	}
	void divideIntoBlock(char[]pt) {
		for(int i=0;i<32;i++) {
			left[i]=pt[i];
			right[i]=pt[i+32];
			
		}
		
	}
	
	void printText() {
		for(int i=0;i<32;i++)
			System.out.print(left[i]);
		for(int i=0;i<32;i++)
			System.out.print(right[i]);
		System.out.println();
		
	}

}
