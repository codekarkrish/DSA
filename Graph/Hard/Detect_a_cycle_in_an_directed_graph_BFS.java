import java.util.*;

public class Detect_a_cycle_in_an_directed_graph_BFS {

    public boolean isCyclic(int V, List<Integer>[] adj) {

        int[] indegree = new int[V];

        // Calculate indegree of every vertex
        for (int i = 0; i < V; i++) {
            for (int nei : adj[i]) {
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Add all vertices with indegree 0
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        int count = 0;

        // Kahn's Algorithm (BFS)
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int nei : adj[node]) {
                indegree[nei]--;

                if (indegree[nei] == 0)
                    q.offer(nei);
            }
        }

        // If all vertices are not processed, graph contains a cycle
        return count != V;
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

        Detect_a_cycle_in_an_directed_graph_BFS obj =
                new Detect_a_cycle_in_an_directed_graph_BFS();

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