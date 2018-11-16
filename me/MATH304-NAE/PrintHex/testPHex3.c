#include <stdio.h>
#include "PrintHex.h"

main() {

  int data, i=0;
  unsigned char c;
  FILE *fp;

  fp = fopen("arp.pcap","rb");

  while (1) {
    data = fgetc(fp);
    if ( feof(fp) ) {
      putchar('\n');
      return 0;
    }
    c=data & 0xFF;
    PrintHex(c,i);
    i++;
  }

  putchar('\n');
}


#include "PrintHex.c"
