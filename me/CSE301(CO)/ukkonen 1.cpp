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
        //temp = currenNode[0].childs;
        node *child;
        for(list<node*>::iterator it =currenNode[0].childs.begin(); ;it++){
            child = *it;
            if(child[0].chr ==pattern[i]) {
                    currenNode = child;
                    break;
            }
            else if(it==currenNode[0].childs.end()) return false;

        }

    }

    return true;

}


int main(){
    string text,pattern;
    bool isIn;

    getline(cin,text);
    getline(cin,pattern);

  //  createTree(text);
    insertInTree('c');
   // isIn = checkPattern(pattern);

   // if(isIn==true)cout<<"True"<<endl;
   // else cout<<"False"<<endl;




return 0;
}
