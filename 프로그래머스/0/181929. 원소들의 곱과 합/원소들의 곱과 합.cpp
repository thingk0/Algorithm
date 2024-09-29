#include <string>
#include <vector>
#include <numeric>

using namespace std;

int solution(vector<int> num_list) {
    int sum = 0, prod = 1;
    for (int n : num_list) {
        sum += n;
        prod *= n;
    }
    return prod < (sum * sum) ? 1 : 0;
}