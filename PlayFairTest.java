package PlayFair;

import java.util.*;

public class PlayFairTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String pt=scanner.nextLine();
        pt=pt.replaceAll("\\s+","");
        pt=pt.toUpperCase();
        System.out.println(pt);
        ArrayList<String> chunks=new ArrayList<>();

        for (int i = 0; i < pt.length();i=i+2) {

            StringBuilder sb=new StringBuilder();

            for (int j = i; j < i+2; j++) {

                if (j==i+1&&j<pt.length()&&pt.charAt(j-1)==pt.charAt(j)) {
                    sb.append('X');
                    i--;
                    break;

                }
                else if (j==pt.length()) {
                    sb.append('X');
                }
                else {
                    sb.append(pt.charAt(j));

                }


            }

            chunks.add(sb.toString());


        }

        System.out.println(chunks.toString());

        char[][] matrix=new char[5][5];

        Set<Character> noDup=new LinkedHashSet<>();
        for (char c :
                pt.toCharArray()) {
            noDup.add(c);
        }

        System.out.println(noDup.toString());
        char[] ndpt=new char[noDup.size()];
        Iterator<Character> it=noDup.iterator();
        int k=0;
        while (it.hasNext()){
            ndpt[k++]=it.next();
        }


        k=0;

        int ascii=65;


        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < 5; j++) {

                if (k<noDup.size())
                    matrix[i][j] = ndpt[k++];
                else{
                    if ((char)ascii=='J')
                        ascii++;
                    for (int l = 0; l < ndpt.length; l++) {
                        if ((char)ascii==ndpt[l]) {
                            ascii++;

                        }
//                        if (ndpt[l]=='I'||ndpt[l]=='J')
//                            ascii++;
                    }
                    matrix[i][j]=(char)ascii++;
                }

            }
        }

        for (int l = 0; l < 5; l++) {
            for (int m = 0; m <5; m++) {
                System.out.print(matrix[l][m]);
            }
            System.out.println();
        }


        Iterator<String> chunksIterator=chunks.iterator();

        while (chunksIterator.hasNext()){
            String ch=chunksIterator.next();
            char a=ch.charAt(0);
            char b=ch.charAt(1);

            System.out.println("chunks "+a+" "+b);

            int arow=0,brow=0;
            int acol=0,bcol=0;
            for (int i = 0; i < 5; i++) {

                for (int j = 0; j < 5; j++) {
                    if (a==matrix[i][j]) {
                        arow = i;
                        acol = j;
                        System.out.println(a+" "+arow+" "+acol);
                        continue;
                    }

                    if (b==matrix[i][j]) {
                        brow = i;
                        bcol = j;
                        System.out.println(b+" "+brow+" "+bcol);
                        break;

                    }


                }


            }
            System.out.println(a+": "+acol+" ,"+b+": "+bcol);
            if (arow==brow)
                System.out.printf("%c %c",matrix[arow][(acol+1)%5],matrix[brow][(bcol+1)%5]);

        }




    }
}