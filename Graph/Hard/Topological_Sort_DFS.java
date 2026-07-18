import java.util.*;

public class Topological_Sort_DFS {

    static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;

        for (int v : adj.get(node)) {
            if (vis[v] == 0) {
                dfs(v, vis, adj, st);
            }
        }

        st.push(node);
    }

    static void topoSort(int N, ArrayList<ArrayList<Integer>> adj) {

        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
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
        adj.get(2).add(3);
        adj.get(3).add(1);

        topoSort(N, adj);
    }
}

/*
Output:
5 4 2 3 1 0

TC: O(V + E)
SC: O(V)
Auxiliary SC: O(V)
*/