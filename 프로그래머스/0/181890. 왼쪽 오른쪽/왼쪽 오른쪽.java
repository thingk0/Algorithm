class Solution {
    public String[] solution(String[] str_list) {
        for (int i = 0; i < str_list.length; i++) {
            if ("l".equals(str_list[i])) {
                String[] answer = new String[i];
                System.arraycopy(str_list, 0, answer, 0, i);
                return answer;
            }
            if ("r".equals(str_list[i])) {
                String[] answer = new String[str_list.length - i - 1];
                System.arraycopy(str_list, i + 1, answer, 0, str_list.length - i - 1);
                return answer;
            }
        }
        
        return new String[0];
    }
}