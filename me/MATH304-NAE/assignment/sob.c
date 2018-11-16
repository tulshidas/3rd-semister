#include <stdio.h>
#include <math.h>
#define F(x) (((x)*(x))-1)
#define G(x) 2*x
#define EPS 0.1E-06
double real_root;
int checker,checker1;

int bisectionMethod(double A, double B)
{

	double a,b,root;
	int i=0;
	a = A;
	b = B;

	
	if((F(a)*(F(b)))>=0){
		return -1;
	}
	while(1)
	{
		i++;
		root = (a+b)/2;
		if(fabs(F(root))<EPS){
			real_root = root;
			//printf("root is ::%lf\n",root);
			 
			
			break;
		}
		
		if((F(a)*F(root))<0) b=root;
		else a = root;
	
	}
		return i;


}


int falsePointMethod(double A , double B)
{
	double a,b,root;
	int i=0;
	a = A;
	b = B;

	
	if((F(a)*(F(b)))>=0){
		return -1;
	}
	while(1)
	{
		i++;
		root = ((a*F(b))-(b*F(a)))/((F(b))-((F(a))));
		if(fabs(F(root))<EPS){
			real_root = root;
			break;
		}
		
		if((F(a)*F(root))<0) b=root;
		else a = root;
	
	}
		return i;





}


int newtonRapson(double A)
{

	double a,root;
	int i=0;
	a = A;
	while(1){
		i++;
		root = a - (F(a)/(G(a)));
		if(fabs(F(root))<EPS){
			real_root = root;
			break;
		}
		a = root;
	}
	
	return i;

}

int succissiveAssumption(double A)
{

	double a,root;
	int i=0,j;
	a = A;
	for(j=0; j<100000; j++){
			i++;
			root = F(a);
			if(fabs(F(root))<EPS){
				real_root = root;
				break;
			}
			a = root;
		}
		return i;
}




int calc1variable(double  A,int(*f)(double)){
	return (*f)(A);
}




int calc2variable(double  A, double B ,int(*f)(double , double)){
	return (*f)(A,B);
}



int main(void)
{
	 checker = bisectionMethod(0.5,1.5);
	 checker1 = calc2variable(0.5,1.5,bisectionMethod);
	if(checker != -1)
	{
		printf("root in bisection mehtod is....%f\n",real_root);
	
	
	
	}
	else 
	{
		printf("there is no root in given range..\n");
	
	
	}

	printf("number of iteration for BISECTION method is :::: %d\n",bisectionMethod(0.5,1.5));
	printf("total number of iteration  for BISECTION is ....%d\n",calc2variable(0.5,1.5,bisectionMethod));
	printf(".........................................................................\n");
	
	
	checker = falsePointMethod(0.5,1.5);
	checker1 = calc2variable(0.5,1.5,falsePointMethod);
	if(checker != -1)
	{
		printf("root in falsePointMethod mehtod is....%f\n",real_root);
	
	
	
	}
	else 
	{
		printf("there is no root in given range..\n");
	
	
	}
	
	printf("number of iteration for FALSEPOINT method  is.....%d\n",falsePointMethod(0.5,1.5));
	printf("total number of iteration for FALSEPOINT method is...%d\n",calc2variable(0.5,1.5,falsePointMethod));
	printf(".........................................................................................\n");
	
	
	checker = newtonRapson(0.5);
	checker1 = calc1variable(0.5,newtonRapson);
	if(checker != -1)
	{
		printf("root in newtonRapson mehtod is....%f\n",real_root);
	
	
	
	}
	else 
	{
		printf("there is no root in given range..\n");
	
	
	}
	
	printf("number of iteration is :::: %d\n",newtonRapson(0.5));
	printf("total number of iteration is...%d\n",calc1variable(0.5,newtonRapson));
	
	
	checker = succissiveAssumption(0.5);
	checker1 = calc1variable(0.5,succissiveAssumption);
	
	
	if(checker < 100000)
	{
		printf("root in newtonRapson mehtod is....%f\n",real_root);
	
	
	
	}
	else 
	{
		printf("there is no root in given range..\n");
	
	
	}
	
	
	
	return 0;




}


