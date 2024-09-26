#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int ans = 0;
    bool isEven = n % 2 == 0;
    for (int i = (isEven ? 2 : 1); i <= n; i += 2) {
        ans += (isEven ? i * i : i);
    }
    return ans;
}