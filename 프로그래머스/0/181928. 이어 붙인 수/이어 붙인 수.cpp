#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    string even = "", odd = "";
    for (int n : num_list) {
        if (n % 2 == 0) {
            even += to_string(n);
        } else {
            odd += to_string(n);
        }
    }
    return stoi(odd) + stoi(even);
}