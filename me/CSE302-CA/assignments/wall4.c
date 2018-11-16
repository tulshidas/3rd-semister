#include<stdio.h>
#include<sys/time.h>

double getWallTime(){
    double wallTime;
    struct timeval time;

    gettimeofday(&time,NULL);
    wallTime = time.tv_sec + (double)(time.tv_usec) * 0.000001 ;
    return wallTime;

}

int main(){
    double startTime = getWallTime(); //wall clock time is count started here
    long int i;
    double endTime;

    for(i=0;i<100000;i++){
        printf("%ld\n",i);
    }
    endTime = getWallTime();  // end of the wall time

    printf("Wall time=%lf",endTime - startTime); // print the wall time spent by the for loop

return 0;
}
