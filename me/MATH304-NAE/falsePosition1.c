#include <stdio.h>
#include <math.h>
#define F(x) ((x)*(x))
#define G(x) (1-((x)*(x)))
#define H(x) (F(x) - G(x))
#define A 0.2
#define B 2.0
#define EPS 0.1e-6

int main()
{
	double a,b,root;
	a=A;
	b=B;
	
	if(H(a) *H(b) >=0)  return -1;
	
	Again:
	root = (a*H(b)-b*H(a))/(H(b)-H(a));
	
	if(fabs(H(root))<EPS){
		printf("Point = %lf\n", root);
		return 0;
	}
	
	if (H(a)*H(root) < 0) b=root;
		
	 else a=root;
		
	goto Again;
		

	return 0;

}
