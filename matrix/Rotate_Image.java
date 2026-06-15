public class Rotate_Image {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // first triangle
        for(int i=0;i<n;i++){
            int x=0;
            int y=i;
            while(y>x){
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
                x++;
                y--;
            }
        }
        // second triangle

        for(int i=1;i<n;i++){
            int y=n-1;
            int x=i;
            while(y>x){
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][x];
                matrix[y][x] = temp;
                x++;
                y--;
            }
        }

        for(int i=0;i<n;i++){
            int x = 0;
            int y = n-1;
            while(y>x){
                int temp = matrix[i][x];
                matrix[i][x] = matrix[i][y];
                matrix[i][y] = temp;
                x++;
                y--;
            }
        }
        

    }
}