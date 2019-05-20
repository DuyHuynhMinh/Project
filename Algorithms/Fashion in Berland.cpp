#include<iostream>
#include<vector>
using namespace std;
int main() {

	int n = 0, x;
	int count = 0;
	cin >> n;

	if (n == 1) {
		cin >> x;
		if (x == 1) {
			cout << "YES";
		}
		else {
			cout << "NO";
		}
	} else {		
		for (int i = 0; i < n; ++i) {
			cin >> x;
			if (x == 0) {
				++count;
			}
		}

		if (count == 1) {
			cout << "YES";
		}
		else {
			cout << "NO";
		}


	}

	

	
	
	

	return 0;
}