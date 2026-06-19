import java.util.*;

public class Rat_in_a_Maze {

    // Function to check whether the next cell is valid
    static boolean isSafe(int x, int y, int n, int[][] maze, boolean[][] visited) {
        return (x >= 0 && x < n &&
                y >= 0 && y < n &&
                maze[x][y] == 1 &&
                !visited[x][y]);
    }

    // Backtracking function
    static void solve(int x, int y, int n, int[][] maze,
                      boolean[][] visited, String path,
                      List<String> ans) {

        // Destination reached
        if (x == n - 1 && y == n - 1) {
            ans.add(path);
            return;
        }

        // Mark current cell as visited
        visited[x][y] = true;

        // Move Down
        if (isSafe(x + 1, y, n, maze, visited)) {
            solve(x + 1, y, n, maze, visited, path + "D", ans);
        }

        // Move Left
        if (isSafe(x, y - 1, n, maze, visited)) {
            solve(x, y - 1, n, maze, visited, path + "L", ans);
        }

        // Move Right
        if (isSafe(x, y + 1, n, maze, visited)) {
            solve(x, y + 1, n, maze, visited, path + "R", ans);
        }

        // Move Up
        if (isSafe(x - 1, y, n, maze, visited)) {
            solve(x - 1, y, n, maze, visited, path + "U", ans);
        }

        // Backtrack
        visited[x][y] = false;
    }

    // Function to find all paths
    static List<String> findPath(int[][] maze, int n) {

        List<String> ans = new ArrayList<>();

        // If start or destination is blocked
        if (maze[0][0] == 0 || maze[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, n, maze, visited, "", ans);

        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        int n = maze.length;

        List<String> paths = findPath(maze, n);

        if (paths.isEmpty()) {
            System.out.println("No path exists.");
        } else {
            System.out.println("Possible Paths:");
            for (String path : paths) {
                System.out.println(path);
            }
        }
    }
}