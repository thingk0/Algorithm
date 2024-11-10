#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> participant_count;

    // 참가자 목록을 해시맵에 추가
    for (const string& p : participant) {
        participant_count[p]++;
    }

    // 완주자 목록을 차감
    for (const string& c : completion) {
        participant_count[c]--;
        if (participant_count[c] == 0) {
            participant_count.erase(c);
        }
    }

    // 남아 있는 참가자 반환
    return participant_count.begin()->first;
}