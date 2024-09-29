#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr, vector<vector<int>> queries) {
    vector<int> result;

    for (const auto& query : queries) {
        int s = query[0];
        int e = query[1];
        int k = query[2];

        int min_val = -1;

        for (int i = s; i <= e; ++i) {
            if (arr[i] > k) {
                if (min_val == -1 || arr[i] < min_val) {
                    min_val = arr[i];
                }
            }
        }

        result.push_back(min_val);
    }

    return result;
}