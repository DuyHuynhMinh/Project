#include<iostream>
#include<vector>
#include <map>
#include<string>

using namespace std;

int binarySearch(vector<int> v, int value);

int main() {


	vector<int>  v= {2,3,4,5,7,14,16};
	int value = 14;
	int index = binarySearch(v, value);	

	cout << index << endl;

	system("pause");

	return 0;
}

int binarySearch(vector<int> v,int value) {

	int size = v.size();

	if (value < v.at(0) || value > v.at(size-1)) return - 1;
	int left = 0;
	int right = size - 1;

	if (v.at(left) == value) return left;
	if (v.at(right) == value) return right;
	
	while (left <= right) {

		
		int mid = left + (right - left) / 2;

		if (v.at(mid) == value) return mid;

		if (v.at(mid) < value) {
			left = mid + 1;
		}

		if (v.at(mid) > value) {
			right = mid -1;
		}


	}

	return -1;

}