#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

int solution(vector<vector<string>> clothes) {
    unordered_map<string, int> counter;

    for (const auto& cloth : clothes) {
        counter[cloth[1]]++;
    }

    int answer = 1;
    for (const auto& [_, category] : counter) {
        answer *= (category + 1);
    }

    return answer - 1;
}