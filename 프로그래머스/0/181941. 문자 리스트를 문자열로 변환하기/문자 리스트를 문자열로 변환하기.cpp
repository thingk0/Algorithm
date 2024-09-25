#include <string>
#include <vector>

using namespace std;

string solution(vector<string> arr) {
    string answer;
    for (const string& s : arr) {
        answer += s;
    }
    return answer;
}