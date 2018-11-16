#include<iostream>
#include<string>
#include<list>
#include<istream>

using namespace std;



struct node{
    list<node*> childs;
    char chr;
} *root;


list<node*>  insertInTree( list<node*>leafs,char ch){
    node *temp,*newLeaf;
    for(list<node*>::iterator it=leafs.begin();it!=leafs.end();it++){
        temp = *it;
        newLeaf = new node[1];
        newLeaf[0].chr=ch;
        temp[0].childs.push_back(newLeaf);
        leafs.erase(it);
        leafs.push_back(newLeaf);

    }

    node* temp1;

    for(list<node*>::iterator it1 = root[0].childs.begin();it1!=root[0].childs.end();it1++){
        temp1 = *it1;
        if(temp1[0].chr==ch){
            leafs.push_back(temp1);
            break;
        }

    }

    return leafs;

}
node* createTree(string text){
    list<node*>leafs;
    root = new node[1] ;
    root[0].chr = '\n' ;
    leafs.push_back(root);

    for(int i=0;i<text.size();i++){
        char ch= text[i];
        leafs = insertInTree(leafs,ch);
    }


}

bool checkPattern(string pattern){
    node *currenNode;
    list<node*> temp;
    currenNode = root;


    for(int i=0;i<pattern.size();i++){
        temp = currenNode[0].childs;
        for(list<node*>::iterator it =currenNode[0].childs.begin(); ;it++){
            node *child;
            child = *it;
            if(child[0].chr ==pattern[i]) currenNode = child;
            if(it==currenNode[0].childs.end()) return false;

        }

    }

    return true;

}


int main(){
    string text,pattern;
    bool isIn;

    getline(cin,text);
    getline(cin,pattern);



    createTree(text);
    isIn = checkPattern(pattern);

    if(isIn)cout<<"True"<<endl;
    else cout<<"False"<<endl;




return 0;
}
