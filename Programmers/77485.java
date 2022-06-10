/*
    @date: 2022.06.10
    @source: https://programmers.co.kr/learn/courses/30/lessons/77485
    @email: ehye826@gmail.com
*/
class Solution {
    private int[][] matrix;
    private List<Integer> numList;

    public int[] solution(int rows, int columns, int[][] queries) {
        numList = new ArrayList<>();
        initMatrix(rows, columns);

        for(int [] query : queries) {
            rotateMatrix(query);
        }
        return numList.stream().mapToInt(i -> i).toArray();
    }


    private void rotateMatrix(int[] query) {
        int minNum = Integer.MAX_VALUE;
        int[] edges = { matrix[query[0]][query[1]], matrix[query[0]][query[3]], matrix[query[2]][query[3]], matrix[query[2]][query[1]]};

        for(int i = query[3] - 1; i > query[1]; i--) {
            matrix[query[0]][i + 1] =   matrix[query[0]][i];
            minNum = Math.min(minNum, matrix[query[0]][i]);
        }

        for (int i = query[2] - 1; i > query[0]; i--) {
            matrix[i + 1][query[3]] = matrix[i][query[3]];
            minNum = Math.min(minNum, matrix[i][query[3]]);
        }

        for(int i = query[1] + 1; i < query[3]; i++) {
            matrix[query[2]][i - 1] = matrix[query[2]][i];
            minNum = Math.min(minNum, matrix[query[2]][i]);
        }

        for (int i = query[0] + 1; i < query[2]; i++) {
            matrix[i - 1][query[1]] = matrix[i][query[1]];
            minNum = Math.min(minNum, matrix[i][query[1]]);
        }

        matrix[query[0]][query[1] + 1] = edges[0];
        matrix[query[0] + 1][query[3]] = edges[1];
        matrix[query[2]][query[3] - 1] = edges[2];
        matrix[query[2] - 1][query[1]] = edges[3];
        for (int edge : edges) {
            minNum = Math.min(minNum, edge);
        }

        numList.add(minNum);
    }

    private void initMatrix(int rows, int columns) {
        int k = 1;

        matrix = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                matrix[i][j] = k++;
            }
        }
    }

}
