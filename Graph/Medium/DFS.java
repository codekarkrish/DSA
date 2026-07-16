import java.util.*;

public class DFS {

    // DFS Traversal
    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();

        dfs(0, adj, visited, result);

        return result;
    }

    private void dfs(int node, List<List<Integer>> adj,
                     boolean[] visited, List<Integer> result) {

        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(1);

        adj.get(4).add(2);

        DFS graph = new DFS();

        List<Integer> dfsTraversal = graph.dfsOfGraph(V, adj);

        System.out.println("DFS Traversal:");
        for (int node : dfsTraversal) {
            System.out.print(node + " ");
        }
    }
}

/*
TC: O(V + E)
SC: O(V)
*/