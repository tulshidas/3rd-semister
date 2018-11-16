#include<stdio.h>

int main()
{
    float x,y;
    int i;
    x = 1.0 / 1000000.0 ;
    y=0.0;

    for(i=0;i<1000000;i++) y +=x;

    printf("%f",y);

return 0;
}
