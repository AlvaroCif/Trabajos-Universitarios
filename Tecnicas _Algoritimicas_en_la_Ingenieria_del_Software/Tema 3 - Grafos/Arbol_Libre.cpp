#include <fstream>
#include <iostream>
#include <vector>
#include <queue>
#include <stdexcept>

class DepthFirstPaths{
private:
	bool[] marked;
	int[] edgeTo;
	int s;

public:
	public DepthFirstPaths(Graph G, int s)
	{
		...
			dfs(G, s);
	}
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		for (int w : G.adj(v))
			if (!marked[w])
			{
				edgeTo[w] = v;
				dfs(G, w);
			}
	}
}