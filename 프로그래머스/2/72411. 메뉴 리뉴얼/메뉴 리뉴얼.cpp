#include <algorithm>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

void generateCombinations(const string& order, int start, int depth, string& current, unordered_map<string, int>& combi) {
    if (current.size() == depth) {
        combi[current]++;
        return;
    }
    for (int i = start; i < order.size(); ++i) {
        current += order[i];
        generateCombinations(order, i + 1, depth, current, combi);
        current.pop_back();
    }
}

vector<string> solution(vector<string> orders, vector<int> course) {
    
    // 모든 주문을 알파벳 순으로 정렬
    for (auto& order : orders) {
        sort(order.begin(), order.end());
    }
    
    vector<string> answer;
    
    for (const int len : course) {
        unordered_map<string, int> combi;
        // 각 주문에 대해 길이가 len인 모든 조합을 생성하고 카운트
        for (const auto& order : orders) {
            if (order.size() < len) continue; // 주문의 길이가 len보다 작으면 건너뜀
            
            string current;
            generateCombinations(order, 0, len, current, combi);
        }
        
        // 가장 많이 나온 조합의 개수를 찾음
        int maxCount = 0;
        for (const auto& [key, cnt] : combi) {
            if (cnt > maxCount) {
                maxCount = cnt;
            }
        }
        
        // 가장 많이 나온 조합이 2번 이상 나온 경우에만 정답에 추가
        if (maxCount >= 2) {
            for (const auto& [key, cnt] : combi) {
                if (cnt == maxCount) {
                    answer.emplace_back(key);
                }
            }
        }
    }
    
    // 최종 정답을 알파벳 순으로 정렬
    sort(answer.begin(), answer.end());
    return answer;
}
