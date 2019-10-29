package hill;

public class EyncDec {
	int[][] pblocks;
	int[][] cblocks;
	int size;
	int a,b,c,d;
	public EyncDec(int[][] pblocks, int[][] cblocks, int size, int a, int b, int c, int d) {
		this.pblocks=pblocks;
		this.cblocks=cblocks;
		this.size=size;
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}

	public void encryption() {
		for(int j=0;j<size;j++) {
			
			
			int c1=(a*(pblocks[j][0]-65)+b*(pblocks[j][1]-65))%26;
			int c2=(c*(pblocks[j][0]-65)+d*(pblocks[j][1]-65))%26;
			cblocks[j][0]=c1;
			cblocks[j][1]=c2;
		}
		for(int j=0;j<size;j++) {
			for(int k=0;k<2;k++) {
				System.out.println((char)(cblocks[j][k]+65));
			}
		}
	}

	public void decryption() {
		for(int j=0;j<size;j++) {
			
			System.out.println((a*(cblocks[j][0])-b*(cblocks[j][1]))%26);
			int p1=(a*(cblocks[j][0])-b*(cblocks[j][1]))%26;
			if(p1<0)
				p1+=26;
			int p2=(d*(cblocks[j][1])-c*(cblocks[j][0]))%26;
			if(p2<0)
				p2+=26;
			pblocks[j][0]=p1;
			pblocks[j][1]=p2;
		}
		for(int j=0;j<size;j++) {
			for(int k=0;k<2;k++) {
				System.out.println((char)(pblocks[j][k]+65));
			}
		}
		
	}

}
