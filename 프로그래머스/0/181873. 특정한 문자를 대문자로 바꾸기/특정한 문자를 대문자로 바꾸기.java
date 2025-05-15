import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, String alp) {
        char target = alp.charAt(0);
        return my_string.chars()
            .mapToObj(ch -> ch == target
                ? String.valueOf((char) Character.toUpperCase(ch))
                : String.valueOf((char) ch))
            .collect(Collectors.joining());
    }
}