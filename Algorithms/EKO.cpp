#include<iostream>
#include<vector>
#include<iterator>
#include<algorithm>

using namespace std;
long long  binary_search(vector<int> v, long long value);

int main() {

	int n;
	long long m; 
	
	cin >> n;
	cin >> m;


	vector<int> v;
	for (int i = 0; i < n;++i) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());

	long long mid = v.size() / 2;

	int size = v.size() - 1;
	long long  left = v.at(0);
	long long right = v.at(v.size() - 1);

	long long midValue = v.at(mid);

	long long r = 0;

	while (left <right-1) {

		
		for (int i = size; i>=0; --i) {

			if (v.at(i) < midValue) break;

			r += v.at(i) - midValue;

		}
		
		if (r < m) {
			right = midValue;
			midValue = (right + left) / 2;
		} 

		if (r > m) {
			left = midValue;
			midValue = (right + left) / 2;
		}
		
		if (r == m) break;
		r = 0;
	}

	cout << midValue << endl;
	//system("pause");
	
	return 0;
}





