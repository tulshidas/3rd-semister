#include <stdio.h>
#include <stdlib.h>
#include "PrintHex.h"

/*
 * print help text
 */
void print_usage(char *bin_name) {
	fprintf(stderr, "Usage:\n\t %s [options] <pcapfile>\n\n", bin_name);
	fprintf(stderr, "Options:\n");
	fprintf(stderr, "    -h                This message\n");
	fprintf(stderr, "\n");
	return;
}


int main(int argc, char **argv)  {

  int data, i=0, fileno=-1, arg_start = 1;
  unsigned char c;
  FILE *fp;


  if (argc == 1) {
    print_usage(argv[0]);
    exit(-1);
  }

  for (i = arg_start; i < argc ; i++) {
    if (argv[i][0] != '-' ) {
      fileno = i;
    }
    else {
      switch (argv[i][1]) {
	case '?':
	case 'h':
		print_usage(argv[0]);
		exit(0);
		break;
	default :
		printf("Unknown option '%s'\n", argv[i]);
		exit(-1);
		break;

      }
    }
  }

  if (fileno < 0 ) {
    print_usage(argv[0]);
    exit(-1);
  }


  fp = fopen(argv[fileno],"rb");
  if ( fp == NULL ) {
    printf("Error opening file: %s\n", argv[fileno]);
    exit(-1);
  }
  else {
    printf("Reading from file: %s\n", argv[fileno]);
  }

  i=0;

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
  fclose (fp);
}


#include "PrintHex.c"

