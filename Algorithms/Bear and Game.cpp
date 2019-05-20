#include<iostream>
#define N 90
using namespace std;
int main() {

	int n,x;
	cin >> n;

		
	int a[N] ;

	a[0] = 0;
	a[n + 1] = 90;

	int prev = 0;
	bool found = false;
	int result = 0;

	for (int i = 1; i <= n; ++i) {
		cin >> x;
		a[i] = x;
		if (!found &&a[i] > a[prev] + 15) {
			found = true;
			result = a[prev] + 15;
		}
		prev = i;
	}

	if (found) {
		cout << result;
	}
	else {
		if (a[n] + 15 < a[n + 1]) {
			cout << a[n]+15;
		}
		else {
			cout << 90;
		}
	}

	
	return 0;
}