import java.util.Arrays;

public class Flood_fill_algorithm {

    private static final int[] dr = {-1, 0, 1, 0};
    private static final int[] dc = {0, 1, 0, -1};

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private static void dfs(int[][] image, int r, int c, int originalColor, int color) {
        int n = image.length;
        int m = image[0].length;

        image[r][c] = color;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m
                    && image[nr][nc] == originalColor) {
                dfs(image, nr, nc, originalColor, color);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int sr = 1, sc = 1, newColor = 2;

        int[][] result = floodFill(image, sr, sc, newColor);

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

/*
Time Complexity: O(n * m)
Space Complexity: O(n * m)
*/