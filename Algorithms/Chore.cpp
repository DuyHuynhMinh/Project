#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
bool f(int i, int j) {
	return i > j;
}
int main() {

	int n, pJ, vJ,x;
	vector<int> v;
	cin >> n;
	cin >> pJ;
	cin >> vJ;

	for (int i = 0; i < n; ++i) {
		cin >> x;
		v.push_back(x);
	}

	sort(v.begin(),v.end(),f);

	cout << (v.at(pJ - 1) - v.at(pJ));

	//system("pause");
	
	return 0;
}