import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        int boardSize = board.length;
        ArrayDeque<Integer>[] lanes = initializeLanes(board);
        ArrayDeque<Integer> bucket = new ArrayDeque<>();
        int removedDolls = 0;
        
        for (int move : moves) {
            removedDolls += processMove(lanes[move - 1], bucket);
        }
        
        return removedDolls;
    }
    
    private ArrayDeque<Integer>[] initializeLanes(int[][] board) {
        
        int size = board.length;
        ArrayDeque<Integer>[] lanes = new ArrayDeque[size];
        
        // 각 레인을 초기화
        for (int i = 0; i < size; i++) {
            lanes[i] = new ArrayDeque<>();
        }
        
        // 보드의 인형들을 레인에 추가
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }
        
        return lanes;
    }
    
    private int processMove(ArrayDeque<Integer> lane, ArrayDeque<Integer> bucket) {
        // 레인이 비어있으면 처리하지 않음
        if (lane.isEmpty()) {
            return 0;
        }
        
        int doll = lane.pop();
        if (!bucket.isEmpty() && bucket.peek() == doll) {
            bucket.pop();
            return 2;  // 인형 2개가 제거됨
        } else {
            bucket.push(doll);
            return 0;
        }
    }
}