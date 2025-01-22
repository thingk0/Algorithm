import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 의상 종류별 개수 세기
        Map<String, Long> categoryCounts = Arrays.stream(clothes)
            .collect(Collectors.groupingBy(cloth -> cloth[1], Collectors.counting()));

        // 2. 각 카테고리별 경우의 수를 곱한 결과 계산
        int combinations = categoryCounts.values()
            .stream()
            .mapToInt(Long::intValue)
            .map(count -> count + 1)
            .reduce(1, (a, b) -> a * b);

        // 3. 아무것도 안 입는 경우 제외
        return combinations - 1;
    }
}