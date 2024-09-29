#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

void generate_numbers(int l, int r, int length, string current, vector<int>& result) {
    if (current.length() == length) {
        int num = stoi(current);
        if (l <= num && num <= r) {
            result.push_back(num);
        }
        return;
    }

    if (current.empty()) {
        generate_numbers(l, r, length, "5", result);
    } else {
        generate_numbers(l, r, length, current + '0', result);
        generate_numbers(l, r, length, current + '5', result);
    }
}

vector<int> solution(int l, int r) {
    vector<int> result;
    
    int min_length = to_string(l).length();
    int max_length = to_string(r).length();

    for (int length = min_length; length <= max_length; ++length) {
        generate_numbers(l, r, length, "", result);
    }

    if (result.empty()) {
        return {-1};
    }

    sort(result.begin(), result.end());
    return result;
}