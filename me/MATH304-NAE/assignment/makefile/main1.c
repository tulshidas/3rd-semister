#include<stdio.h>
#include<stdlib.h>


void print_usage(char *bin_name) {
	fprintf(stderr, "Usage:\n\t %s [options] <pcapfile>\n\n", bin_name);
	fprintf(stderr, "Options:\n");
	fprintf(stderr, "    -h:      Help message\n");
	fprintf(stderr, "    -c:      print hexadecimal+ascii value\n");
	fprintf(stderr, "  <empty>:   print hexadecimal\n");

	fprintf(stderr, "\n");

	return;
}

int main(int argc, char **argv){

	int data, i=1, fileno=-1, arg_start = 1;
  	unsigned char c;
  	FILE *fp;

  	if (argc == 1 || argc>3) {
    	print_usage(argv[0]);
    	exit(-1);
  	}



    if (argv[i][0] != '-' ) {
		print_hex(fp,argv[1]); 
    }

    else {
      switch (argv[i][1]) {
	case 'h':
		print_usage(argv[0]);
		exit(0);
		break;

	case 'c':
		print_hex_and_ascii(fp, argv[2]);
		exit(0);
		break;
	default :
		printf("Input undifinded\n");
		exit(-1);
		break;

      }
    }
  

}