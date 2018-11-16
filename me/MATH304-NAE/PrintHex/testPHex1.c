#include <stdio.h>

int PrintHex(unsigned char, int);

main() {

  int data, i=0;
  unsigned char c;


  while (1) {
    data = getchar();
    if (data == EOF ) {
      putchar('\n');
      return;
    }
    c=data & 0xFF;
    PrintHex(c,i);
    i++;
  }

  putchar('\n');
}

int PrintHex(unsigned char c, int i) {
  if (i == 0 ) {
    printf("%06X\t",i);
  } 
  else {
    if (i%16 == 0)
      printf("\n%06X\t",i);
    else if (i%16 == 8)
      printf(" - ");
    else
      printf(" ");
  }    


  printf("%02X", c);

  return 0;
}


