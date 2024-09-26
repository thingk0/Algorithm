#include <string>

using namespace std;

string solution(string code) {
    string answer = "";
    bool mode = false;
    
    for (int idx = 0; idx < code.length(); idx++) {
        if (code[idx] == '1') {
            mode = !mode;
        } else {
            if ((mode == false && idx % 2 == 0) || (mode == true && idx % 2 != 0)) {
                answer += code[idx];
            }
        }
    }
    
    return answer.empty() ? "EMPTY" : answer;
}