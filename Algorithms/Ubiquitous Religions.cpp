#include<iostream>
#include<vector>
#include <map>
#include<string>
#include<map>
#include<algorithm>
#include<queue>
#include<functional>


using namespace std;

#define MAX 50002


void init(int N);
int findSet(int u);
void unionSet(int v, int u);

int parent[MAX];
int ranks[MAX];


int main() {		
		
	

	int  N, M;
	cin >> N;
	cin >> M;

	int Case = 0;

	while (N!=0) {
		
		++Case;

		init(N);

		for (int i = 0; i < M; ++i) {
			int v;
			int u;
			cin >> v;
			cin >> u;
			unionSet(v, u);
		}

		int count = 0;

		for (int i = 1; i <= N; ++i) {
			if (parent[i] == i)  ++count;
		}

		cout << "Case " << Case << ": " << count << endl;
		

		cin >> N;
		cin >> M;

	}


	//system("pause");

}

void init(int N) {
	for(int i = 1; i <=N; ++i) {
		parent[i] = i;
		ranks[i] =0;
	}
}

int findSet(int u) {

	if (u != parent[u]) {
		parent[u] = findSet(parent[u]);
	}

	return parent[u];

}

void unionSet(int v, int u) {

	int vp = findSet(v);
	int up = findSet(u);
	

	if (vp == up) return;		

	if (ranks[up] > ranks[vp]) {		
		parent[vp] = up;
	}else if (ranks[up] < ranks[vp]) {		
		parent[up] = vp;
	}else {		
		parent[up] = vp;
		ranks[vp]++;
	}
	

}






