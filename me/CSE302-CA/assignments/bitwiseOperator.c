#include<stdio.h>

void makeNot(int *p){
    *p = ~(*p);

}

int main()
{

    struct num{
        unsigned a:1 ;

    };
    union a{
        int x;
        struct num bits[32];

    };
    union a ab;
    int i;
    scanf("%d",&ab.x);
    printf("%d\n",ab.x);
    makeNot(&ab.x);

    for(i=0;i<32;i++){
        printf("%d",ab.bits[i].a) ;
    }

    printf("\n%d",ab.x);

    return 0;
}
