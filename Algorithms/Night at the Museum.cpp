#include<iostream>
#include<string>
#include <algorithm>
using namespace std;
int main() {

	string s ;
	cin >> s;

	char start_point = 'a';

	int sum = 0;

	for (int i = 0; i < s.length(); ++i) {
		int dis = s.at(i) - start_point;
		sum += min(abs(dis), 26 - abs(dis));
		start_point = s.at(i);
	}
	
	cout<<sum<<endl;	

	return 0;
}