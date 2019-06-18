#include<iostream>
#include<vector>
#include <map>
#include<string>
#include<map>
#include<algorithm>
#include<queue>
#include<functional>
#include<set>
#include<stack>


using namespace std;

#define MAX 101
#define rep(i,a,b) for(int i = a; i<b;++i)

#define err 10e-9

struct Img {
	int real;
	int img;
};



int main() {		
	

	
	int N;

	cin >> N;

	stack<int> data;
	stack<int> maxdata;


	while (N-- > 0) {

		int cmd;
		cin >> cmd;

		if (cmd == 1) {

			int value;
			cin >> value;

			data.push(value);

			if (!maxdata.empty()&&maxdata.top()>value) {
				maxdata.push(maxdata.top());
			}else {
				maxdata.push(value);
			}

			} else if (cmd == 2) {

				maxdata.pop();
				data.pop();

			} else {
				cout << "Result : " << maxdata.top() << "\n";
			}


	}

	system("pause");

}


