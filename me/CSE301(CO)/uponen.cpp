#include<iostream>
#include<string>
#include<list>

using namespace std;

struct node{
    list<node> *next;
    char *nextChars;

}*root;

int main(){

    string s="actaatc";
    root[0].nextChars[0]='a';
    root[0].next[0] = NULL;
    cout<< root[0].nextChars[0];

return 0;
}
