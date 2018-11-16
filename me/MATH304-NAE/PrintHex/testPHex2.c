#include <stdio.h>
#include "PrintHex.h"

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

#include "PrintHex.c"

