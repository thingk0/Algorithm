#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> ptn_a = {1, 2, 3, 4, 5};
vector<int> ptn_b = {2, 1, 2, 3, 2, 4, 2, 5};
vector<int> ptn_c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> count = {0, 0, 0};
    
    for (int i = 0; i < answers.size(); ++i) {
        const int ans = answers[i];
        if (ans == ptn_a[i % 5]) {
            count[0]++;
        }
        
        if (ans == ptn_b[i % 8]) {
            count[1]++;
        }
        
        if (ans == ptn_c[i % 10]) {
            count[2]++;
        }
    }
    
    int max_count = *max_element(count.begin(), count.end());
    for (int i = 0; i < 3; ++i) {
        if (count[i] == max_count) {
            answer.push_back(i + 1);
        }
    }
    
    return answer;
}