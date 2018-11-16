#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define F(x) sin(x)
#define PI 3.14159265 
int main(void){
	// trapozoid rule
	double  a=0.0, b=2*PI,res =0.0;
	int i, n=1000;
	double dx = (b-a)/n;
	for(i=i ; i<n ; i++){
		res+=F(i*dx);
	}
	printf("%lf\n",res*0.5);
	
	//simpson's rule
	double  a=0.0, b=2*PI,sum =0.0;
	int i, n=200;
	double dx = (b-a)/n;
	for (i = 1; i < n; ++i)
	{
		if(i%2 == 0){
			sum += (2*F(i*dx));
		}
		else{
			sum += (4*F(i*dx));
		}

	}
	sum+=F(a);
	sum+=F(b);
	printf("%lf\n",sum*dx/3);
	return 0;

}