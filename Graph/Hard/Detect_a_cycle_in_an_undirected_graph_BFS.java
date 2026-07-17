import java.util.*;

public class Detect_a_cycle_in_an_undirected_graph_BFS {

    static class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!vis[i] && bfs(i, adj, vis))
                return true;
        }

        return false;
    }

    private boolean bfs(int src, List<Integer>[] adj, boolean[] vis) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(src, -1));
        vis[src] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            for (int nei : adj[curr.node]) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    q.offer(new Pair(nei, curr.node));
                } else if (nei != curr.parent) {
                    return true;
                }
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
        // 0
        //
        // 1 -- 2 -- 3
        adj[1].add(2);
        adj[2].add(1);
        adj[2].add(3);
        adj[3].add(2);

        Detect_a_cycle_in_an_undirected_graph_BFS obj = new Detect_a_cycle_in_an_undirected_graph_BFS();

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