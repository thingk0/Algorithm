#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    vector<char> stack;
    stack.reserve(s.size());
    
    for (char ch : s) {
        if (!stack.empty() && stack.back() == ch) {
            stack.pop_back();
        } else {
            stack.push_back(ch);
        }
    }
    
    return stack.empty();
}