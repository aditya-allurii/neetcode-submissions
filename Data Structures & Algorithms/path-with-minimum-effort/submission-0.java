class Solution {

    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // {effort, row, col}
        pq.add(new int[]{0, 0, 0});

        dist[0][0] = 0;

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int effort = current[0];
            int row = current[1];
            int col = current[2];

            if (effort > dist[row][col]) {
                continue;
            }

            if (row == n - 1 && col == m - 1) {
                return effort;
            }

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow < 0 || newRow >= n ||
                    newCol < 0 || newCol >= m) {
                    continue;
                }

                int difference =
                        Math.abs(heights[row][col] - heights[newRow][newCol]);

                int newEffort = Math.max(effort, difference);

                if (newEffort < dist[newRow][newCol]) {

                    dist[newRow][newCol] = newEffort;

                    pq.add(new int[]{
                            newEffort,
                            newRow,
                            newCol
                    });
                }
            }
        }

        return 0;
    }
}