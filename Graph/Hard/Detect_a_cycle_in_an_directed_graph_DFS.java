import java.util.*;

public class Detect_a_cycle_in_an_directed_graph_DFS {

    // DFS to detect cycle
    private boolean dfs(int node, List<Integer>[] adj,
                        boolean[] vis, boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        for (int nei : adj[node]) {
            if (!vis[nei]) {
                if (dfs(nei, adj, vis, pathVis))
                    return true;
            } else if (pathVis[nei]) {
                return true;
            }
        }

        pathVis[node] = false;
        return false;
    }

    public boolean isCyclic(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 4;

        List<Integer>[] adj = new ArrayList[V];
        for (int i = 0; i < V; i++)
            adj[i] = new ArrayList<>();

        // Graph:
        // 0 -> 1 -> 2 -> 3
        //      ^         |
        //      |_________|

        adj[0].add(1);
        adj[1].add(2);
        adj[2].add(3);
        adj[3].add(1);

        Detect_a_cycle_in_an_directed_graph_DFS obj =
                new Detect_a_cycle_in_an_directed_graph_DFS();

        if (obj.isCyclic(V, adj))
            System.out.println("Cycle Detected");
        else
            System.out.println("No Cycle");
    }
}

/*
Time Complexity: O(V + E)
Space Complexity: O(V)
*/