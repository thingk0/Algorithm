#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    unordered_map<string, int> target_items;
    
    for (int i = 0; i < want.size(); ++i) {
        target_items[want[i]] = number[i];
    }
    
    unordered_map<string, int> current_window;
    for (int i = 0; i < 10 && i < discount.size(); ++i) {
        current_window[discount[i]]++;
    }
    
    if (target_items == current_window) {
        answer++;
    }
    
    for (int i = 10; i < discount.size(); ++i) {
        current_window[discount[i]]++;
        current_window[discount[i - 10]]--;
        if (current_window[discount[i - 10]] == 0) {
            current_window.erase(discount[i - 10]);
        }
        
        if (target_items == current_window) {
            answer++;
        }
    }
    
    return answer;
}
