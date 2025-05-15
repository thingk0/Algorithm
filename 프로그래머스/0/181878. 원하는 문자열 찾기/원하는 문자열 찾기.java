class Solution {
    public int solution(String myString, String pat) {
        // 모두 소문자(또는 대문자)로 변환
        String lowerMyString = myString.toLowerCase();
        String lowerPat = pat.toLowerCase();
        
        // 포함되어 있으면 1, 아니면 0 반환
        return lowerMyString.contains(lowerPat) ? 1 : 0;
    }
}