#include<iostream>
#include<vector>
#include <map>
#include<string>
#include<map>
#include<algorithm>
#include<queue>
#include<functional>
#include<set>


using namespace std;

#define MAX 101
#define rep(i,a,b) for(int i = a; i<b;++i)

#define err 10e-9

struct Img {
	int real;
	int img;
};



int main() {		
	

	
	vector<int> v = { 2, 7, 11, 15 };
	int target = 9;
	map<int,int> m; 

	vector<int> result;

	for (int i = 0; i < v.size();++i) {

		int value = target - v.at(i);

		if (m.count(value) > 0) {

			result.push_back(m[value]);
			result.push_back(i);
		}else {
			m[v.at(i)] = i;
		}
		
	}

	for (auto &x : result) {
		cout << x << "\n";
	}

	system("pause");

}


