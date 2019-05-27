#include<iostream>
#include<vector>
#include<iterator>
#include<algorithm>
#include <map>
#include<string>
#include <cmath>

using namespace std;

int main() {


	int n, s;
	int x, y;

	int p;

	cin >> n;
	cin >> s;

	int value = 1000000 - s;

	map<long long, int> m;

	for (int i = 0; i < n; ++i) {
		cin >> x;
		cin >> y;
		cin >> p;
		long long r = (x*x + y*y);

		if (m[r] != 0) {
			int tmp = m[r]+p;			
			m[r] = tmp;
		} else {			
			m[r] = p;
		}
		

	}

	int sum = 0;
	for (const auto &x : m) {
		sum += x.second;

		if (sum >= value) {
			printf("%.6f", sqrt(x.first));			
			break;
		}
	}
	
	if (sum < value) {
		cout << -1;
	}

	//system("pause");

	return 0;
}



	





