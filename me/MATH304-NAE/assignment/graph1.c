#include<stdio.h>
#include<math.h>

int main()
{
    float x,y,pi=3.14159;

    printf("x,y\n");
    for(x=0.0;x<8*pi;x=x+0.1)
    {
        y = x+ sin(x);
        printf("%f,%f \n",x,y);
    }


    return 0;
}

