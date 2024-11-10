#include <string>
#include <cmath>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    
    vector<int> answer;
    vector<int> left_days;
    
    // 남은 일수를 계산하여 left_days에 추가
    for (size_t i = 0; i < progresses.size(); ++i) {
        left_days.push_back(ceil((100.0 - progresses[i]) / speeds[i]));
    }
    
    int max_day = left_days[0];
    int cnt = 1;

    // left_days를 순회하며 배포 일자를 정리
    for (size_t i = 1; i < left_days.size(); ++i) {
        if (left_days[i] > max_day) {
            answer.push_back(cnt);
            cnt = 1;
            max_day = left_days[i];
        } else {
            ++cnt;
        }
    }
    
    // 마지막 배포 추가
    answer.push_back(cnt);
    return answer;
}
