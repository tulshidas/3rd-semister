#include<iostream>
#include<string>
#include<list>
#include<istream>

using namespace std;


struct node{
    list<node*> childs;
    char chr;
};

node* createTree(string text){
    list<node>*leafs;
    node *tree;
    tree = new node[1] ;
    tree[0].chr = '\n' ;

    for(int i=0;i<text.size();i++){

    }


}

int main(){
    string text,pattern;

    getline(cin,text);
    getline(cin,pattern);

    createTree(text);




return 0;
}
