#include <string>
#include <vector>
#include <utility>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    for (const auto& query : queries) {
        int a = query[0];
        int b = query[1];
        swap(arr[a], arr[b]);
    }
    return arr;
}