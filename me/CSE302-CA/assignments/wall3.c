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
    double startTime = getWallTime();
    long int i;
    double endTime;

    for(i=0;i<100000;i++){
        printf("%ld\n",i);
    }
    endTime = getWallTime();

    printf("Wall time=%lf",endTime - startTime);

return 0;
}
