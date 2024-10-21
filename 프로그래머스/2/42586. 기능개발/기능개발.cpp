#include <cmath>
#include <vector>

using namespace std;

int calculate_days_left(int progress, int speed) {
    return ceil((100.0 - progress) / speed);
}

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int n = progresses.size();
    
    int count = 1;
    int max_day = calculate_days_left(progresses[0], speeds[0]);

    for (int i = 1; i < n; ++i) {
        int current_day = calculate_days_left(progresses[i], speeds[i]);

        if (current_day <= max_day) {
            count++;
        } else {
            answer.push_back(count);
            count = 1;
            max_day = current_day;
        }
    }

    answer.push_back(count);
    return answer;
}
