#include<iostream>
#include<vector>
#include <map>
#include<string>
#include<map>
#include<algorithm>
#include<queue>
#include<functional>


using namespace std;

#define MAX  200

const long long INF = 1e18;



void prim(int src, vector<pair<int, int>> graph[], int numberofNode, int Case);



int main() {

	int T;

	cin >> T;
	
	//string s;
	//cin >> s;

	int Case = 0;
	
	while (T-- > 0) {

		
		++Case;

		int N;
		cin >> N;
		
		map<string, int> cityIDmap;
		int id = 0;

		vector<pair<int, int>> graph[MAX];

		for (int i = 0; i < N; ++i) {

			string city1;
			string city2;
			int cost;
			cin >> city1;
			cin >> city2;
			cin >> cost;

			if (cityIDmap[city1] == 0) {
				++id;
				cityIDmap[city1] = id;
			}
			if (cityIDmap[city2] == 0) {
				++id;
				cityIDmap[city2] = id;
			}

			int node1 = cityIDmap[city1];
			int node2 = cityIDmap[city2];

			graph[node1].push_back(make_pair(node2, cost));
			graph[node2].push_back(make_pair(node1, cost));


		}



		/*for (const auto &x : cityIDmap) {
			cout <<"Output : " << x.first << " " << x.second <<endl;
		}*/

		prim(1, graph, id, Case);

		//cin >> s;
		

	}



	/*int N, M;
	cin >> N;
	cin >> M;
	vector<pair<int, int>> graph[MAX];
	for (int i = 0; i < M; ++i) {
		int x;
		int y;
		int w;
		cin >> x;
		cin >> y;
		cin >> w;
		graph[x].push_back(make_pair(y, w));
		graph[y].push_back(make_pair(x, w));
	}

	prim(1, graph);*/
	
	system("pause");

	return 0;
}

struct option {
bool operator() (const pair<int, int> &a, const pair<int, int> &b) const {
return a.second > b.second;
}
};
void prim(int src,  vector<pair<int,int>> graph[], int numberOfNode, int Case) {

	
	
	bool visited[MAX] ;
	long long dist[MAX];
	int path[MAX];

	
	for (int i = 0; i < MAX; ++i) {
		visited[i] = false;
		path[i] = -1;
		dist[i] = INF;
	}

	priority_queue <pair<int, int>, vector<pair<int, int>>, option> pq;

	dist[src] = 0;

	pq.push(make_pair(src, 0));


	while (!pq.empty()) {

		int u = pq.top().first;
		pq.pop();
		visited[u] = true;


		for (int i = 0; i < graph[u].size(); ++i) {

			int v = graph[u][i].first;
			int w = graph[u][i].second;

			
			if (!visited[v] && dist[v] >w) {
				dist[v] = w;
				path[v] = u;
				pq.push(make_pair(v, w));

			}


		}


	}

	long long ans = 0; 
	int tmpNumberNode = 0;
	for (int i = 0; i < MAX; ++i) {
		if (path[i] == -1) continue;
		++tmpNumberNode;
		ans += dist[i];
	}

	if (tmpNumberNode == numberOfNode - 1) {
		cout <<"Case "<<Case<<": "<< ans << endl;
	}else {
		cout << "Case " << Case << ": Impossible" << endl;
	}
	
	

	



}



