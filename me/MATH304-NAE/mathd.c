#include <stdio.h>
#include <math.h>
#define F(x) sin (x)
#define G(x) cos (x)

#define pi  3.1416
#define EPS 0.1e-6

int main()
{
	
	double x;
	int i;
    printf("\"x\",\"Sin (x)\",\"Cos (x)\"\n");
    
    for(i=0; i<=180; i+= 15) {
    
    	x=i*pi/180;
    
        
        printf("%d,%lf,%lf\n",i,F(x),G(x));
    }

	return 0;

}
