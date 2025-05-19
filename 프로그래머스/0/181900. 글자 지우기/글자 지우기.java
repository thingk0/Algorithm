import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> indexSet = Arrays.stream(indices).boxed().collect(Collectors.toSet());
        return IntStream.range(0, my_string.length())
                        .filter(i -> !indexSet.contains(i))
                        .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                        .collect(Collectors.joining());
    }
}