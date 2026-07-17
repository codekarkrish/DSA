import java.util.*;

public class Detect_a_cycle_in_an_undirected_graph_DFS {

    // DFS to detect cycle
    private boolean dfs(int node, int parent, List<Integer>[] adj, boolean[] vis) {
        vis[node] = true;

        for (int nei : adj[node]) {
            if (!vis[nei]) {
                if (dfs(nei, node, adj, vis))
                    return true;
            } else if (nei != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, adj, vis))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;

        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        // Graph:
        // 0 - 1
        //     | \
        //     2  4
        //     | /
        //     3

        adj[0].add(1);
        adj[1].add(0);

        adj[1].add(2);
        adj[2].add(1);

        adj[2].add(3);
        adj[3].add(2);

        adj[3].add(4);
        adj[4].add(3);

        adj[4].add(1);
        adj[1].add(4);

        Detect_a_cycle_in_an_undirected_graph_DFS obj =
                new Detect_a_cycle_in_an_undirected_graph_DFS();

        if (obj.isCycle(V, adj))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}

/*
Time Complexity: O(V + E)
Space Complexity: O(V)
*/