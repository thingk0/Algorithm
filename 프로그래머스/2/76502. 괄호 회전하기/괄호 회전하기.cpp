#include <string>
#include <vector>
#include <stack>

bool isValid(const std::string &s, size_t start) {
    std::stack<char> stk;
    size_t sz = s.size();
    
    auto getOpeningBracket = [&](char ch) -> char {
        switch(ch) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default: return '\0';
        }
    };
    
    for (size_t i = 0; i < sz; ++i) {
        char ch = s[(start + i) % sz];
        char matching = getOpeningBracket(ch);
        if (matching) {
            if (stk.empty() || stk.top() != matching)
                return false;
            stk.pop();
        } else {
            stk.push(ch);
        }
    }
    
    return stk.empty();
}

int solution(std::string s) {
    int answer = 0;
    size_t n = s.size();
    
    for (size_t i = 0; i < n; ++i) {
        if (isValid(s, i)) {
            answer++;
        }
    }
    return answer;
}