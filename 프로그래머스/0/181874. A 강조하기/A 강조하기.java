import java.util.stream.Collectors;

class Solution {
    public String solution(String myString) {
        return myString.chars()
            .mapToObj(c -> {
                char ch = (char) c;
                if (ch == 'a' || ch == 'A') return "A";
                else if (Character.isUpperCase(ch)) return String.valueOf(Character.toLowerCase(ch));
                else return String.valueOf(ch);
            })
            .collect(Collectors.joining());
    }
}