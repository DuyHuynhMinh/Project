#include<iostream>
#include<vector>
#include<iterator>
#include<algorithm>

using namespace std;

int binary_search(vector<int> v, int value);

bool f(int i, int j) {
	return i > j;
}
int main() {

	int t, n, m;
	cin >> t;
	
	int k = 0;
	while (t-->0) {

		cin >> n;
		cin >> m;
		
		vector<int> v;
		int tmp;

		int count = 0;

		for (int i = 0; i < n; ++i) {
			cin >> tmp;
			v.push_back(tmp);
		}

		sort(v.begin(), v.end());

		int left = 0;
		int right = v.size() - 1;

		while(left<right){

			long long r = v[left] + v[right];

			if (r< m) {
				++left;
			}

			if (r > m) {
				--right;
			}

			if (r== m) {
				++count;
				++left;
				--right;
			}
		}

		cout << count << endl;
		
	}
	//system("pause");
	
	return 0;
}

int binary_search(vector<int> v, int value) {

	int left = 0;
	int right = v.size()-1;
	int mid = left+(right - left) / 2;

	

	while (left<right) {
		cout << "Here : " << left << " " << right << endl;
		if (v[mid] == value) return mid;

		if (v[mid] > value) {
			right = mid;
		}
		else {
			left = mid;
		}

		mid = left+(right - left) / 2;

	}

	return -1;

}