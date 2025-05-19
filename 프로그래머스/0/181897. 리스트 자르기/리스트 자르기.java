import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0], b = slicer[1], c = slicer[2];
        switch (n) {
            case 1:
                // 0 ~ b
                return Arrays.copyOfRange(num_list, 0, b + 1);
            case 2:
                // a ~ 끝
                return Arrays.copyOfRange(num_list, a, num_list.length);
            case 3:
                // a ~ b
                return Arrays.copyOfRange(num_list, a, b + 1);
            case 4:
                // a ~ b, c 간격
                return IntStream.iterate(a, i -> i <= b, i -> i + c)
                        .map(i -> num_list[i])
                        .toArray();
            default:
                return new int[0];
        }
    }
}