import java.util.*;

public class Topological_Sort_BFS {

    public void topoSort(int N, ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[N];

        for (int i = 0; i < N; i++) {
            for (int v : adj.get(i)) {
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int v : adj.get(node)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {

        int N = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);

        new Topological_Sort_BFS().topoSort(N, adj);
    }
}

/*
Output:
4 5 2 0 3 1

TC: O(V + E)
SC: O(V)
*/