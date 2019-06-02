#include<iostream>
#include<vector>
#include <map>
#include<string>
#include<map>

using namespace std;

#define MAX 10

struct node {

	struct node *child[MAX];
	int countWord;

};

struct node *newNode() {

	 node *Node = new  node;

	 Node->countWord = 0;
	 for (int i = 0; i < MAX; ++i) {
		 Node->child[i] = NULL;
	 }

	 return Node;

}

bool addWord(node *root, string s) {

	int ch;
	node *tmp = root;
	for (int i = 0; i < s.size(); ++i) {

		ch = s[i] -48;
		
		if (tmp->child[ch] == NULL) {
			tmp->child[ch] = newNode();
		}

		tmp = tmp->child[ch];

		if (tmp->countWord == 1) return true;

	}
	tmp->countWord++;
	return false;
}

bool findWord(node *root, string s) {
	int ch;
	node *tmp = root;
	for (int i = 0; i < s.size(); ++i) {
		ch = s[i] - 'a';
		if (tmp->child[ch] == NULL) {
			return false;
		}
		tmp = tmp->child[ch];
	}

	return tmp->countWord > 0;

}

bool isWord(node *pNode) {
	return (pNode->countWord != 0);
}

bool isEmpty(node *pNode) {
	for (int i = 0; i < MAX; ++i) {
		if (pNode->child[i] != NULL) {
			return false;
		}
	}
	return true;
}

bool removeWord(node *root, string s, int level, int len) {
	if (!root) return false;
	int ch = s[level] - 'a';
	if (level == len) {
		if (root->countWord > 0) {
			root->countWord--;
			return true;
		}
		return false;
	}

	int flag = removeWord(root->child[ch], s, level + 1, len);

	if (flag && !isWord(root->child[ch]) && isEmpty(root->child[ch])) {
		delete root->child[ch];
		root->child[ch] = NULL;
	}

	return flag;
}

void printWord(node *root, string s) {
	if (isWord(root)) {
		cout << s << endl;
	}
	for (int i = 0; i < MAX; ++i) {
		if (root->child[i]) {
			printWord(root->child[i], s +(char) ('a' + i));
		}
	}
}

int main() {

	//911 97625999 	91125426
	//113		12340 		123440 		12345 		98346

	int T;
	cin >> T;

	int CASE = 1;
	while (T-- > 0) {

		int N;
		cin >> N;
		node *root = newNode();

		bool r = false;
		while (N-- > 0) {

			string s;
			cin >> s;

			if (addWord(root, s)) {
				r = true;
			}
		}


		if (r) {
			cout <<"Case "<<CASE<<": NO" << endl;
		}
		else {
			cout << "Case " << CASE << ": YES" << endl;
		
		}

		//delete root->child;
		delete root;
		++CASE;
	}
	

	
	system("pause");

	return 0;
}



