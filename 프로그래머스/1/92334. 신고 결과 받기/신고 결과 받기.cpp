#include <string>
#include <vector>
#include <unordered_map>
#include <unordered_set>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    
    unordered_map<string, unordered_set<string>> reported_user;
    unordered_map<string, int> count;
    
    // 보고된 사용자와 보고한 사용자 기록
    for (const auto& r : report) {
        size_t space_pos = r.find(' ');
        if (space_pos != string::npos) {
            string user_id = r.substr(0, space_pos);
            string reported_id = r.substr(space_pos + 1);
            reported_user[reported_id].insert(user_id);
        }
    }
    
    // 정지된 사용자에 대해 보고한 사용자에게 메일 발송
    for (const auto& [reported_id, user_set] : reported_user) {
        if (user_set.size() >= k) {
            for (const auto& uid : user_set) {
                count[uid]++;
            }
        }
    }
    
    // 결과 벡터 미리 할당 및 채우기
    vector<int> answer;
    answer.reserve(id_list.size());
    for (const auto& id : id_list) {
        answer.emplace_back(count[id]);
    }
    
    return answer;
}