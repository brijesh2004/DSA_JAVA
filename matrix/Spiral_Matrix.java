public class Spliral_Matrix{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // top row
            for (int i = startCol; i <= endCol; i++)
                ans.add(matrix[startRow][i]);
            startRow++;

            // right column
            for (int i = startRow; i <= endRow; i++)
                ans.add(matrix[i][endCol]);
            endCol--;

            // bottom row
            if (startRow <= endRow) {
                for (int i = endCol; i >= startCol; i--)
                    ans.add(matrix[endRow][i]);
                endRow--;
            }

            // left column
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--)
                    ans.add(matrix[i][startCol]);
                startCol++;
            }
        }

        return ans;

    }
}