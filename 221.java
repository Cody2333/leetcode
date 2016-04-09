public class Solution {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        if (matrix.length == 0) {
            return result;
        }
        int x_length = matrix.length;
        int y_length = matrix[0].length;
        int max = 0;
        for (int x = 0; x < x_length; x++) {
            int x_max = 0;
            for (int y = 0; y < y_length; y++) {
                if (matrix[x][y] == '1') {
                    int temp = find(x, y, matrix);
                    if (temp > x_max) {
                        x_max = temp;
                    }
                }
            }
            if (x_max > max) {
                max = x_max;
            }

        }
        result = max;
        return result;
    }

    private int find(int x, int y, char[][] matrix) {
        //按照正方形的方式遍历，参数为左上角
        int scale = 0;
        Boolean flag = true;
        int max_scale = (matrix.length - x) < (matrix[0].length - y) ? (matrix.length - x) : (matrix[0].length - y);
        while (flag) {
            if (scale == max_scale) {
                break;
            }
            scale++;
            for (int i = 0; i < scale; i++) {
                for (int j = 0; j < scale; j++) {
                    if ((x + i) < matrix.length && (y + j) < matrix[0].length) {
                        if (matrix[x + i][y + j] == '0') {
                            flag = false;
                            break;
                        }
                    }
                }
                if(!flag){
                    break;
                }
            }
            if(!flag){
                scale--;
            }
        }
        return (scale) * (scale);
    }
}