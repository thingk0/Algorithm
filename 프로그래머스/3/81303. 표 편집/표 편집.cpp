#include <string>
#include <vector>
#include <stack>

using namespace std;

string solution(int n, int k, vector<string> cmd) {
    stack<int> deleted;
    vector<int> up(n), down(n);
    
    for (int i = 0; i < n; ++i) {
        up[i] = i - 1;
        down[i] = i + 1;
    }
    
    down[n - 1] = -1;

    for (const string& command : cmd) {
        char action = command[0];
        if (action == 'C') {
            deleted.push(k);
            
            if (up[k] != -1) down[up[k]] = down[k];
            if (down[k] != -1) up[down[k]] = up[k];
            
            k = (down[k] != -1) ? down[k] : up[k];
            
        } else if (action == 'Z') {
            int r = deleted.top();
            deleted.pop();
            
            if (up[r] != -1) down[up[r]] = r;
            if (down[r] != -1) up[down[r]] = r;
            
        } else {
            int sz = stoi(command.substr(2));
            if (action == 'U') {
                while (sz-- > 0) k = up[k];
            } else if (action == 'D') {
                while (sz-- > 0) k = down[k];
            }
        }
    }
    
    string answer(n, 'O');
    while (!deleted.empty()) {
        answer[deleted.top()] = 'X';
        deleted.pop();
    }
    
    return answer;
}