import java.util.stream.IntStream;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        int r1 = arr1.length;
        int c2 = arr2[0].length;
        int c1 = arr1[0].length;

        return IntStream.range(0, r1)
            .mapToObj(i -> IntStream.range(0, c2)
                      .map(j -> IntStream.range(0, c1)
                           .map(k -> arr1[i][k] * arr2[k][j])
                           .sum())
                      .toArray())
            .toArray(int[][]::new);
    }
}