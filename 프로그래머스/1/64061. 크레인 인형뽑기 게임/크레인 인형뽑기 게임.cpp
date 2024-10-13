#include <string>
#include <vector>
#include <stack>

int solution(std::vector<std::vector<int>> board, std::vector<int> moves) {
    int rows = board.size();
    int cols = board[0].size();
    
    std::vector<std::stack<int>> lanes(cols);
    for (int i = rows - 1; i >= 0; --i) {
        for (int j = 0; j < cols; ++j) {
            if (board[i][j] != 0) {
                lanes[j].push(board[i][j]);
            }
        }
    }
    
    std::stack<int> bucket;
    int score = 0;
    
    for (int move : moves) {
        int lane_index = move - 1;
        if (!lanes[lane_index].empty()) {
            int doll = lanes[lane_index].top();
            lanes[lane_index].pop();
            
            if (!bucket.empty() && bucket.top() == doll) {
                bucket.pop();
                score += 2;
            } else {
                bucket.push(doll);
            }
        }
    }
    
    return score;
}