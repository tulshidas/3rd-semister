#include<stdio.h>


    char horizontalLine[] = "---- ";
    char playerIdentifier1[]=" H  ";
    char playerIdentifier2[]=" C  ";
    char space[] = "    ";
    char dotedSpace[] = "    .";
    char *boxContent[] = {space,space,space,space,space,space,space,space,space};
    char *row[]={dotedSpace,horizontalLine,horizontalLine,dotedSpace,horizontalLine,dotedSpace,dotedSpace,dotedSpace,dotedSpace,dotedSpace,dotedSpace,dotedSpace};
    char colom[]={' ','|','|',' ',' ',' ','|',' ',' ',' ',' ',' '};
    char rowIdentifier[]={'a','b','c','d'};

  void  printBox(){
    int i,j;
    printf("  1    2    3    4\n");
    for(i=0;i<3;i++){
        printf("%c .",rowIdentifier[i]);
       // printf(".");
        for(j=0;j<3;j++){
            printf("%s",row[i*3 +j]);
        }
        printf("\n  ");

        for(j=0;j<3;j++){
            printf("%c%s",colom[i*3 +j],boxContent[i*3+j]);
        }
        printf("%c\n  ",colom[i*3+3]);

        for(j=0;j<3;j++){
            printf("%c%s",colom[i*3 +j],space);
        }
        printf("%c\n",colom[i*3 +3]);

    }
        printf("%c .",rowIdentifier[3]);
        for(j=0;j<3;j++){
            printf("%s",row[3*3+j]);
        }

}

int main(){
    int i,j;
    for(int i=0;i<12;i++){

    }
    printf("My turn: I draw between b1 and c1\n");
    printBox();
return 0;
}
