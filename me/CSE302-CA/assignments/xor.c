#include<stdio.h>

int main(){
    int x,y,z;

    printf("Enter a hexadecimal number:");
    scanf("%x",&x);
    printf("Enter another hexadecimal number:");
    scanf("%x",&y);

    z = x^y;

    printf("xor of two number:%x\n",z);

    z = ~(x | y);

    printf("NOR of two number:%x\n",z);

    z = (x | y);

    printf("OR of two number:%x\n",z);



}
