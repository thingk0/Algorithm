class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];
        
        // n번째부터 끝까지를 앞에 복사
        System.arraycopy(num_list, n, answer, 0, num_list.length - n);
        
        // 0번째부터 n-1번째까지를 뒤에 복사
        System.arraycopy(num_list, 0, answer, num_list.length - n, n);
        
        return answer;
    }
}
