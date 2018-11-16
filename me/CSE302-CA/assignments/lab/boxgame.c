#include<stdio.h>
#include<stdlib.h>
char board[5][10]={"  1 2 3 4\n",
	     		   "a . . . .\n",
				   "b . . . .\n",
				   "c . . . .\n",
				   "d . . . .\n"};

int m_w,m_z;
void printBoard(){
	int i,j;		
	for(i=0;i<5;i++){
		for(j=0;j<10;j++){
			printf("%c",board[i][j]);
		}
	}
}
unsigned int get_random()
{
	m_z = 36969 * (m_z & 65535) + (m_z >> 16);
	m_w = 18000 * (m_w & 65535) + (m_w >> 16);
	return (m_z << 16) + m_w; /* 32-bit result */
}
int main(){
			
	int myScore=0,yourScore=0;
	printf("Enter two positive numbers to initialize the random number generator.\n");
	printf("Number 1: ");
	scanf("%d",&m_w);
	printf("Number 2: ");
	scanf("%d",&m_z);
	
	
	int l=1,p=1;
	p=get_random()%10+1;
	l=l+p;
	int prev=0;
	int flag=1;
	
	while(l<=24+p){
		char str1[20],str2[20];
		unsigned int r1,r2,c1,c2;
		if(l%2==0){
			if(l!=prev && !flag){
				printf("\nYour turn:\n");
				prev=l;
			}
			if(flag){
				printf("\nYou will make the first move.\n\n");
				flag=0;
			}
			printf("  Enter coordinate of the first dot: ");
			scanf("%s",str1);
			r1=str1[0]-'a'+1;
			c1=str1[1]-'0';
			printf("  Enter coordinate of the second dot: ");
			scanf("%s",str2);
			r2=str2[0]-'a'+1;
			c2=str2[1]-'0';
		}else{
			if(flag){
				printf("\nI will make the first move.\n\n");
				flag=0;
			}
			
			r1=get_random()%4+1;
			r2=get_random()%4+1;
			c1=get_random()%4+1;
			c2=get_random()%4+1;
		}
		
		if(r1==r2){
			if(c1==c2+1||c1==c2-1){
				int min=c1<c2?c1:c2;
				if(board[r1][min*2+1]==' '){
					board[r1][min*2+1]='_';
					//check lower box
					if(r1!=4){
						if(board[r1+1][min*2]=='|'&& board[r1+1][min*2+2]=='|' && board[r1+1][min*2+1]=='_'){
							if(l%2==0){
								board[r1+1][min*2+1]='H';
								yourScore++;
							}
							else {
								board[r1+1][min*2+1]='C';
								myScore++;
							}
						}
					}
					//check upper box
					if(r1!=1){
						if(board[r1][min*2]=='|'&& board[r1][min*2+2]=='|' && board[r1-1][min*2+1]!=' '){
							if(l%2==0){
								board[r1][min*2+1]='H';
								yourScore++;
							}
							else{
								board[r1][min*2+1]='C';
								myScore++;
							}
						}
					}
					
					if(l%2!=0){
						printf("My turn: I draw between %c%d and %c%d\n\n",r1-1+'a',c1,r2-1+'a',c2);
						printBoard();
					}
					l++;
				}
				else {
					if(l%2==0)printf("There is already a line there.\n");
				}
			}
			else{
				if(l%2==0)printf("Coordinates must be adjacent\n");
			}
		}
		else{
			if((r1==r2+1||r1==r2-1)&&c1==c2){
				int max=(r1>r2?r1:r2);
				if(board[max][c1*2]!='|'){
					board[max][c1*2]='|';
					//check right box
					if(c1!=4){
						if(board[max][c1*2+1]=='_'&&board[max-1][c1*2+1]!=' '&&board[max][c1*2+2]=='|'){
							if(l%2==0){
								board[max][c1*2+1]='H';
								yourScore++;
							}
							else {
								board[max][c1*2+1]='C';
								myScore++;
							}
						}
					}
					//check left box
					if(c1!=1){
						if(board[max][c1*2-1]=='_'&&board[max-1][c1*2-1]!=' '&&board[max][c1*2-2]=='|'){
							if(l%2==0){
								board[max][c1*2-1]='H';
								yourScore++;
							}
							else{
								board[max][c1*2-1]='C';
								myScore++;
							}
						}
					}
					
					if(l%2!=0){
						printf("My turn: I draw between %c%d and %c%d\n\n",r1-1+'a',c1,r2-1+'a',c2);
						printBoard();
					}
					l++;
				}
				else{
					if(l%2==0)printf("There is already a line there.\n");
				}
			}
			else{
				if(l%2==0)printf("Coordinates must be adjacent\n");
			}
		}
	}
	
	if(yourScore>myScore)printf("\nYou win!!\n\n");
	else printf("\nI win!!\n\n");
	printBoard();
	
}
