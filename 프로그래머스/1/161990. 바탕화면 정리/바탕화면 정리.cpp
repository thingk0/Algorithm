#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    int lux = wallpaper.size(), luy = wallpaper[0].size();
    int rdx = 0, rdy = 0;

    for (int i = 0; i < wallpaper.size(); ++i) {
        for (int j = 0; j < wallpaper[i].size(); ++j) {
            if (wallpaper[i][j] == '#') {
                lux = min(lux, i);
                luy = min(luy, j);
                rdx = max(rdx, i + 1);
                rdy = max(rdy, j + 1);
            }
        }
    }

    return {lux, luy, rdx, rdy};
}