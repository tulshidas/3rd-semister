#include<iostream>
#include<string>
#include<list>
#include<istream>

using namespace std;


struct node{
    list<node*> childs;
    char chr;
} *root;
list<node*>leafs;


void insertInTree(char ch){
    node *temp;
    node *newLeaf;
    list<node*>::iterator it;

    newLeaf = new node[1];
    newLeaf[0].chr=ch;
    int i=0;
    for( it=leafs.begin();it!=leafs.end();it++){
        temp = *it;
        temp[0].childs.push_back(newLeaf);
        i++;
    }
    leafs.clear();
    leafs.push_back(newLeaf);

    node* temp1;

    for(list<node*>::iterator it1 = root[0].childs.begin();it1!=root[0].childs.end();it1++){
        temp1 = *it1;
        if((temp1!=newLeaf) &&(temp1[0].chr==ch)){
            leafs.push_back(temp1);
            return;
        }


    }
    root[0].childs.push_back(newLeaf);





}
node* createTree(string text){

   root = new node[1] ;
   root[0].chr = '\n' ;
   leafs.push_back(root);

    for(int i=0;i<text.size();i++){
        char ch= text[i];
        insertInTree(ch);
    }


}

bool checkPattern(string pattern){
    node *currenNode;
    list<node*> temp;
    currenNode = root;


    for(int i=0;i<pattern.size();i++){
        node *child;
        for(list<node*>::iterator it =currenNode[0].childs.begin(); ;it++){
            child = *it;
            if(child[0].chr ==pattern[i]) {
                    currenNode = child;
                    break;
            }
            it++;
            if(it==currenNode[0].childs.end()) return false;
            else it--;

        }

    }

    return true;

}


int main(){
    string text,pattern;
    bool isIn;

    getline(cin,text);
    getline(cin,pattern);
    if(pattern.size()>text.size()){
            cout<<"Not substring"<<endl;
            return 0;
    }
    createTree(text);
    isIn = checkPattern(pattern);

    if(isIn==true)cout<<"Substring"<<endl;
    else cout<<"Not Substring"<<endl;




return 0;
}

