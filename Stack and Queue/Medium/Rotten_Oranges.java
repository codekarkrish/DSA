import java.util.*;

public class Rotten_Oranges {

    static class Solution {

        public int orangesRotting(int[][] grid) {

            if (grid.length == 0) return 0;

            int m = grid.length;
            int n = grid[0].length;

            int total = 0;
            int count = 0;

            Queue<int[]> q = new LinkedList<>();

            // Count oranges and store rotten oranges
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) total++;

                    if (grid[i][j] == 2) {
                        q.offer(new int[] {i, j});
                    }
                }
            }

            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            int minutes = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                count += size;

                for (int i = 0; i < size; i++) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1)
                            continue;

                        grid[nx][ny] = 2;
                        q.offer(new int[] {nx, ny});
                    }
                }

                if (!q.isEmpty()) minutes++;
            }

            return total == count ? minutes : -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows and columns: ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter grid:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        Solution obj = new Solution();
        int ans = obj.orangesRotting(grid);

        System.out.println("Minimum Minutes Required = " + ans);

        sc.close();
    }
}

/*
Time Complexity: O(M × N)
Space Complexity: O(M × N)
*/