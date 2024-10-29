#include <string>
#include <stack>
#include <unordered_map>

using namespace std;

bool isValid(const string &s) {
    unordered_map<char, char> bracketPair = {
        {')', '('}, {']', '['}, {'}', '{'}
    };
    stack<char> stk;

    for (char ch : s) {
        if (bracketPair.count(ch)) {
            if (stk.empty() || stk.top() != bracketPair[ch]) {
                return false;
            }
            stk.pop();
        } else {
            stk.push(ch);
        }
    }

    return stk.empty();
}

int solution(string s) {
    int answer = 0;
    int n = s.size();

    for (int i = 0; i < n; ++i) {
        string rotated = s.substr(i) + s.substr(0, i);
        if (isValid(rotated)) {
            ++answer;
        }
    }

    return answer;
}
