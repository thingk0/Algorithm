#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> sum;
    
    for (int i = 0; i < numbers.size(); ++i) {
        for (int j = i + 1; j < numbers.size(); ++j) {
            sum.push_back(numbers[i] + numbers[j]);
        }
    }
    
    sort(sum.begin(), sum.end());
    sum.erase(unique(sum.begin(), sum.end()), sum.end());
    
    return sum;
}