#include <string>
#include <vector>
#include <stack>

std::vector<int> solution(std::vector<int> prices) {
    std::vector<int> answers(prices.size());
    std::stack<int> index_stack;
    
    for (int idx = 0; idx < prices.size(); ++idx) {
        while (!index_stack.empty() && prices[index_stack.top()] > prices[idx]) {
            int top_index = index_stack.top();
            answers[top_index] = idx - top_index;
            index_stack.pop();
        }
        index_stack.push(idx);
    }
    
    while (!index_stack.empty()) {
        int top_index = index_stack.top();
        answers[top_index] = prices.size() - top_index - 1;
        index_stack.pop();
    }
    
    return answers;
}