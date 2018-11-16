#include<stdio.h>

void print_hex(char *pcapFile);

void print_hex(char *pcapFile){
FILE *fp;
    unsigned char ch[16],c;
    int i;
    fp = fopen(pcapFile,"rb");
    while(!feof(fp)){
        fread(ch,sizeof(ch),1,fp);
        for(i=0;i<16;i++){
            printf("%.2X ",ch[i]);
            if(i==7)printf("  ");
        }
        
        printf("\n");
    }

}