import java.util.*;

public class Traversal_Techniques {

    // BFS Traversal
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }

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

        // Undirected Graph
        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(1);

        adj.get(4).add(2);

        Traversal_Techniques graph = new Traversal_Techniques();

        System.out.println("BFS Traversal:");
        List<Integer> bfs = graph.bfsOfGraph(V, adj);
        for (int node : bfs) {
            System.out.print(node + " ");
        }

        System.out.println();

        System.out.println("DFS Traversal:");
        List<Integer> dfs = graph.dfsOfGraph(V, adj);
        for (int node : dfs) {
            System.out.print(node + " ");
        }
    }
}

/*
BFS
TC: O(V + E)
SC: O(V)

DFS
TC: O(V + E)
SC: O(V)
*/