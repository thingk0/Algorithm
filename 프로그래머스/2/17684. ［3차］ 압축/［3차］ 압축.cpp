#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(string msg) {
    
    unordered_map<string, int> dict;
    dict.reserve(256);
    for (char c = 'A'; c <= 'Z'; ++c) {
        string s(1, c);
        dict.emplace(s, c - 'A' + 1);
    }

    vector<int> answer;
    int nextIndex = 27;

    int i = 0;
    const int n = msg.length();

    while (i < n) {
        
        string w;
        int j = i;

        // 현재 위치에서 가장 긴 문자열 찾기
        while (j < n) {
            w += msg[j];
            if (dict.find(w) == dict.end()) {
                w.pop_back();
                break;
            }
            ++j;
        }

        // 사전에 없는 경우, 마지막 문자를 제외한 문자열을 사용
        if (w.empty()) {
            w = string(1, msg[i]);
            j = i + 1;
        }

        // 색인 번호 출력
        answer.push_back(dict[w]);

        // 사전에 새로운 문자열 등록 (w + 다음 문자)
        if (j < n) {
            dict.emplace(w + msg[j], nextIndex++);
        }

        i += w.length();
    }

    
    return answer;
}