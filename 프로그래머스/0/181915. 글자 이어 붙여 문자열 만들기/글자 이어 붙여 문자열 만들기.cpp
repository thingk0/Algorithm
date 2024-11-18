#include <string>
#include <vector>

using namespace std;

string solution(string my_string, vector<int> index_list) {
    string answer;
    answer.reserve(index_list.size());

    for (int idx : index_list) {
        answer.push_back(my_string[idx]);
    }

    return answer;
}
