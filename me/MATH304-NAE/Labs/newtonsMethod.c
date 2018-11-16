#include<stdio.h>
#include<math.h>
#define f(x) ((x)*(x)*(x)*(x)-11*(x)+8)
#define f1(x) (4*(x)*(x)*(x)-11)
#define er(p,q) (((p)-(q))/(q))
#define TOL 0.000001
#define A 2

int main(){
    double a1,a2,t;

   a1=2;
    while(1){
        a2= a1 - f(a1)/f1(a1) ;
        printf("%lf\n",a2);

        if(fabs(er(a2,a1))<= TOL){ printf("sol=%lf\n",a2);break;}
        a1=a2;

    }

    return 0;
}
