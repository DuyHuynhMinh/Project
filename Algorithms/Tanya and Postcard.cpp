#include<iostream>
#include<vector>
#include<iterator>
#include<algorithm>
#include <map>
#include<string>
#include <cmath>

using namespace std;

int main() {


	string s, t;
	cin >> s;
	cin >> t;

	int lenS = s.length();
	int lenT = t.length();

	int sm[123];
	int st[123];

	for (int i = 0; i < 123; ++i) {
		
		sm[i] = 0;
		st[i] = 0;

	}


	for (int i = 0; i < lenS; ++i) {

		char c = s.at(i);
		++sm[c];

	}

	
	for (int i = 0; i < lenT; ++i) {
		char c = t.at(i);		
		++st[c];
	}

	int YA = 0;
	int WH = 0;

	for (int i = 0; i < 123; ++i) {
		int t = min(sm[i], st[i]);
		YA +=t ;
		sm[i] -= t;
		st[i] -= t;
	}

	for (int i = 65; i <= 90; ++i) {
		int t = min(sm[i], st[i + 32])+min(st[i],sm[i+32]);
		WH += t;
	}

	cout << YA << " " << WH;

	//system("pause");

	return 0;
}