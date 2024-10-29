#include <string>
#include <stack>

using namespace std;

int solution(string s) {
    stack<char> st;

    for (char ch : s) {
        if (!st.empty() && st.top() == ch) {
            st.pop();
        } else {
            st.push(ch);
        }
    }

    return st.empty() ? 1 : 0;
}
