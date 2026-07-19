import java.util.*;

public class Bipartite_graph_BFS {

    static boolean bfs(int start, int[] color, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : adj.get(node)) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.offer(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(i, color, adj))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int V = 4;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(0).add(3);
        adj.get(3).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        System.out.println(isBipartite(V, adj));
    }
}

/*
TC: O(V + E)
SC: O(V)
*/