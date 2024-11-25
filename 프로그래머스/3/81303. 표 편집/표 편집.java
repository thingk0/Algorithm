import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 삭제된 행을 추적하기 위한 스택
        ArrayDeque<Integer> deletedRows = new ArrayDeque<>();
        
        // 연결 리스트를 시뮬레이션하기 위한 배열
        int[] upLinks = new int[n];
        int[] downLinks = new int[n];
        
        // 초기 연결 설정
        for (int i = 0; i < n; i++) {
            upLinks[i] = i - 1;
            downLinks[i] = i + 1;
        }
        
        // 현재 선택된 행 인덱스 조정
        int currentRow = k;
        
        for (String command : cmd) {
            switch (command.charAt(0)) {
                case 'C': // 현재 행 삭제
                    deletedRows.push(currentRow);
                    
                    // 현재 행의 위 아래 행 연결
                    int prevRow = upLinks[currentRow];
                    int nextRow = downLinks[currentRow];
                    
                    if (prevRow != -1) downLinks[prevRow] = nextRow;
                    if (nextRow != n) upLinks[nextRow] = prevRow;
                    
                    // 다음 선택할 행 결정
                    currentRow = nextRow != n ? nextRow : prevRow;
                    break;
                    
                case 'Z': // 최근 삭제된 행 복구
                    if (!deletedRows.isEmpty()) {
                        int restoredRow = deletedRows.pop();
                        int prevRestore = upLinks[restoredRow];
                        int nextRestore = downLinks[restoredRow];
                        
                        if (prevRestore != -1) downLinks[prevRestore] = restoredRow;
                        if (nextRestore != n) upLinks[nextRestore] = restoredRow;
                    }
                    break;
                
                default: // 상/하 이동
                    String[] parts = command.split(" ");
                    int move = Integer.parseInt(parts[1]);
                    
                    for (int i = 0; i < move; i++) {
                        currentRow = parts[0].equals("U")
                            ? upLinks[currentRow] 
                            : downLinks[currentRow];
                    }
            }
        }
        
        // 결과 문자열 생성
        char[] result = new char[n];
        Arrays.fill(result, 'O');
        
        for (int deletedRow : deletedRows) {
            result[deletedRow] = 'X';
        }
        
        return new String(result);
    }
}