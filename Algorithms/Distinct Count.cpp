#include<iostream>
#include<vector>
#include<iterator>
#include<algorithm>
#include <set>

using namespace std;

int main() {


	int T, N, X;
	cin >> T;
	

	while (T-- > 0) {

		cin >> N;
		cin >> X;
		set<int> s;
		for (int i = 0; i < N; ++i) {
			int tmp;
			cin >> tmp;
			s.insert(tmp);

		}

		int size = s.size();
		if (size == X) {
			cout << "Good";
		}
		else if (size<X) {
			cout << "Bad";
		}
		else {
			cout<<"Average";
		}

	}
	
	//system("pause");
	return 0;
}

int binary_search(vector<int> v, int value) {

	int left = 0;
	int right = v.size() - 1;
	

	while (left<=right) {

		int mid = left + (right - left) / 2;

		if (v[mid] == value) return mid;

		if (v[mid] > value) {
			right = mid-1;
		}
		else {
			left = mid+1;
		}

		

	}

	return -1*right;

}




