#include<stdio.h>

#define F(x) ((x)*(x)-1)
#define A 0.5
#define B 1.33
#define EPS 0.1E-6
#include<math.h>
#include<stdlib.h>
int main(){
    float root,a,b;
    a = A;
    b= B ;


        while((F(a)-F(b))<0){
           root =(float)(a+b)/2.0;
           if(fabs(root)<EPS){
               printf("root = %f",root);
               break;
           }
           else {
               if((F(a)-F(b))<0) b=root;
               else a = root;
           }
       }


return 0;
}

