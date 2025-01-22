import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 초기 사전 구성: A~Z를 1~26으로 매핑
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        List<Integer> output = new ArrayList<>();
        int dictSize = 27;
        int pos = 0;
        
        while (pos < msg.length()) {
            String current = "";
            int index = pos;
            
            // 2. 현재 위치에서 시작하여 사전에 존재하는 가장 긴 문자열 찾기
            while (index < msg.length() && dictionary.containsKey(msg.substring(pos, index + 1))) {
                current = msg.substring(pos, index + 1);
                index++;
            }
            
            // 3. 찾은 문자열 w에 해당하는 색인 번호를 출력 목록에 추가
            output.add(dictionary.get(current));
            
            // 4. w 다음 글자(c)가 존재하면 사전에 w+c 추가
            if (index < msg.length()) {
                String next = current + msg.charAt(index);
                dictionary.put(next, dictSize++);
            }
            
            // 5. 입력 문자열에서 w를 제거하고 다음 부분 처리
            pos += current.length();
        }
        
        return output.stream().mapToInt(i -> i).toArray();
    }
}