#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

struct Record {
    string cmd;
    string id;
    string nickname;
};

std::vector<std::string> solution(vector<string> record) {
    
    vector<std::string> answer;
    vector<Record> records;
    unordered_map<string, string> uid_map;
    
    // 첫 번째 루프: 레코드를 파싱하고 최신 닉네임을 업데이트
    for (const auto& line : record) {
        size_t pos1 = line.find(' ');
        string cmd = line.substr(0, pos1);
        
        size_t pos2 = line.find(' ', pos1 + 1);
        string id = line.substr(pos1 + 1, pos2 - pos1 - 1);
        
        string nickname;
        if (cmd != "Leave") {
            nickname = line.substr(pos2 + 1);
            uid_map[id] = nickname;
        }
        
        records.push_back(Record{cmd, id, nickname});
    }
    
    // 두 번째 루프: 메시지 생성
    for (const auto& rec : records) {
        if (rec.cmd == "Enter") {
            answer.emplace_back(uid_map[rec.id] + "님이 들어왔습니다.");
        } else if (rec.cmd == "Leave") {
            answer.emplace_back(uid_map[rec.id] + "님이 나갔습니다.");
        }
    }

    return answer;
}
