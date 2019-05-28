#include<iostream>
#include<vector>
#include<iterator>
#include<algorithm>
#include <map>
#include<string>
#include <set>

using namespace std;

int main() {


	int N;
	int M;
	cin >> N;
	set<int> s;
	for (int i = 0; i < N; ++i) {
		int tmp;
		cin >> tmp;
		s.insert(tmp);
	}

	int count=0;
	cin >> M;
	for (int i = 0; i < M; ++i) {

		int tmp;
		cin >> tmp;

		if (s.count(tmp) == 1) ++count;
		

	}

	cout << count;
	//system("pause");

	return 0;
}



	





