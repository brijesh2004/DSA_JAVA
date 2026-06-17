public class Set_Matrix_Zeros{
     public void setZeroes(int[][] matrix) {
        boolean isRowZero = false;
        boolean isColZero = false;
        int n = matrix.length;
        int m = matrix[0].length;

        for(int j=0;j<m;j++){
            if(matrix[0][j]==0){
                isRowZero = true;
                break;
            }
        }

        for(int i=0;i<n;i++){
            if(matrix[i][0]==0){
                isColZero = true;
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }

        for(int j=1;j<m;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<n;i++){
                    matrix[i][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++){
                    matrix[i][j]=0;
                }
            }
        }

        if(isRowZero){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }

        if(isColZero){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }

    }
}