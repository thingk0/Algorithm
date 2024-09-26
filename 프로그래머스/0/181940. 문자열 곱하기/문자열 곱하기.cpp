#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string my_string, int k) {
    string ans = "";
    while(k-- > 0) {
        ans += my_string;
    }
    return ans;
}