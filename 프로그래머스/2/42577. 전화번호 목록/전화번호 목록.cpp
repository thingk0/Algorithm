#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

bool hasPrefixConflict(const unordered_map<string, int>& phone_number_map, const string& current_number) {
    string prefix = "";
    for (char digit : current_number) {
        prefix += digit;
        if (phone_number_map.find(prefix) != phone_number_map.end() && prefix != current_number) {
            return true;
        }
    }
    return false;
}

bool solution(vector<string> phone_list) {
    unordered_map<string, int> phone_number_map;
    
    for (const string& current_number : phone_list) {
        phone_number_map[current_number] = 1;
    }
    
    for (const string& current_number : phone_list) {
        if (hasPrefixConflict(phone_number_map, current_number)) {
            return false;
        }
    }
    
    return true;
}
