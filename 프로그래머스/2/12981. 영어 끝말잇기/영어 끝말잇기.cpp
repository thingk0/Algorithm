#include <string>
#include <vector>
#include <iostream>
#include <unordered_set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    unordered_set<string> used;
    used.insert(words[0]);
    
    for (int i = 1; i < words.size(); ++i) {
        if (!used.insert(words[i]).second || words[i].front() != words[i-1].back()) {
            return vector<int>{i % n + 1, i / n + 1};
        }
    }
    
    return vector<int>{0, 0};
}
