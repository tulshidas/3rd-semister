#include <stdio.h>

struct Date{

	/*
	char d;
	char m;
	short int y;
	*/
	unsigned int d:5;
	unsigned int m:4;
	unsigned int y:15;
	unsigned int t:8;
	//unsigned int s:1;

};

union pack{
	unsigned int a;
	struct Date s;

};

int main(void)
{
	printf("Size of date is %lu\n",sizeof(union pack));	
	 union pack p;
	 p.s.d=6;
	 p.s.m=3;
	 p.s.y=2016;
	 p.s.t=128;
	 printf("%.02d/%.02d/%.02d\n",p.s.d,p.s.m,p.s.y);
	 //printf("%d\n",p.a);
	 //printf("%0X\n",p.a);
	 printf("%u\n",p.a);
	 
	
	
	
	
	/*
	printf("Size of date is %lu\n",sizeof(struct Date));	
	struct Date dt={6,3,2017};
	printf("%.02d/%.02d/%.02d\n",dt.d,dt.m,dt.y);
	*/
	//printf("%d/%d/%d\n",dt.d,dt.m,dt.y);
	/*
	printf("Size of a char is %lu\n",sizeof(char));
	printf("Size of a  unsigned char is %lu\n",sizeof(unsigned char));
	printf("Size of a int  is %lu\n",sizeof(int));
	printf("Size of a short int  is %lu\n",sizeof(short int));
	printf("Size of a unsigned int is %lu\n",sizeof(unsigned int));
	*/

	return 0;
}
