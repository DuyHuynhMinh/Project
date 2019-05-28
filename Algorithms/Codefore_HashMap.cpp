#include<iostream>
#include<vector>
#include<iterator>
#include<algorithm>
#include <map>
#include<string>
#include <set>

using namespace std;
http://codeforces.com/problemset/problem/518/B
int main() {


	string s, t;
	cin >> s;
	cin >> t;

	set<char> UP;
	set<char> LOW;
	int lenS = s.length();
	int lenT = t.length();

	for (int i = 0; i < lenS; ++i) {

		char c = s.at(i);

		if (c >= 'a'&&c <= 'z'){
			LOW.insert(c);
		}
		else {
			UP.insert(c);
		}
	}

	int YA = 0;
	int WH = 0;

	for (int i = 0; i < lenT; ++i) {

		char c = t.at(i);				

		if (c >= 'a'&&c <= 'z') {

			if (UP.count(c - 32)) {
				++WH;
			}
			else if(LOW.count(c)==1){
				++YA;
			}

		}else {

			if (LOW.count(c + 32)) {
				++WH;
			}else if(UP.count(c)==1){
				++YA;
			}

		}


	}

	
	cout << YA << " " << WH;

	//system("pause");

	return 0;
}



	





