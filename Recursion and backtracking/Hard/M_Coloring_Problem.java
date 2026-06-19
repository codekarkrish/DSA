import java.util.Arrays;

public class M_Coloring_Problem {

    // Function to check if it is safe to assign a color
    static boolean isSafe(int node, int[] color, boolean[][] graph, int n, int col) {
        for (int i = 0; i < n; i++) {
            if (graph[node][i] && color[i] == col) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function
    static boolean solve(int node, int[] color, int m, int n, boolean[][] graph) {

        // If all nodes are colored
        if (node == n) {
            return true;
        }

        // Try all colors
        for (int col = 1; col <= m; col++) {

            if (isSafe(node, color, graph, n, col)) {

                color[node] = col;

                if (solve(node + 1, color, m, n, graph)) {
                    return true;
                }

                // Backtrack
                color[node] = 0;
            }
        }

        return false;
    }

    // Function to solve M-Coloring Problem
    static boolean graphColoring(boolean[][] graph, int m, int n) {
        int[] color = new int[n];
        Arrays.fill(color, 0);

        return solve(0, color, m, n, graph);
    }

    public static void main(String[] args) {

        int n = 4; // Number of vertices
        int m = 3; // Number of colors

        boolean[][] graph = new boolean[n][n];

        // Adding edges
        graph[0][1] = graph[1][0] = true;
        graph[1][2] = graph[2][1] = true;
        graph[2][3] = graph[3][2] = true;
        graph[3][0] = graph[0][3] = true;
        graph[0][2] = graph[2][0] = true;

        if (graphColoring(graph, m, n)) {
            System.out.println("Graph can be colored with " + m + " colors.");
        } else {
            System.out.println("Graph cannot be colored with " + m + " colors.");
        }
    }
}