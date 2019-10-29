#include<stdio.h>
#include<string.h>
int  main()
{
//Key
unsigned int a[3][3]={{6,24,1},{13,16,10},{20,17,15}};
//Inverse of key
unsigned int b[3][3]={{8,5, 10},{21,8,21},{21,12,8}};

int i,j,t=0;
unsigned int c[20],d[20];
char msg[20];
//Input Logic
printf("Enter plain text\n");
scanf("%s",msg);
//Put Input string into 3X1 matrix
for(i=0;i<strlen(msg);i++)
{
c[i]=msg[i]-65;
printf("%d",c[i]);
}
//Encryption process
for(i=0;i<3;i++)
{ 	t=0;
for(j=0;j<3;j++)
{
t=t+(a[i][j]*c[j]);
}
d[i]=t%26;
}
//Display the matrix
printf("\nEncrypted Cipher  Text 	:");
for(i=0;i<3;i++)
printf("%c",d[i]+65);
//Decryption Logic
for(i=0;i<3;i++)
{
t=0;
for(j=0;j<3;j++)
{
t=t+(b[i] [j]*d[j]);
}
c[i]=t%26;
}
//Display the result
printf("\nDecrypted Ciper Text:");
for(i=0;i<3;i++)
printf("%c",c[i]+65);
return 0;
}
