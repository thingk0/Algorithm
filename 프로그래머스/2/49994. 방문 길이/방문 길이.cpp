#include <string>

using namespace std;

bool visited[11][11][4];

int dx[] = {0, 1, 0, -1};
int dy[] = {-1, 0, 1, 0};

int to_dir(char dir) {
    if (dir == 'U') 
        return 0;
    else if (dir == 'R') 
        return 1;
    else if (dir == 'D') 
        return 2;
    else 
        return 3;
    return -1;
}

bool is_not_valid(int x, int y) {
    return x < 0 || y < 0 || x > 10 || y > 10;
}

int opposite_direction(int dir) {
    return (dir + 2) % 4;
}

int solution(string dirs) {
    int answer = 0;
    int x = 5, y = 5;
    for (auto c : dirs) {
        int dir = to_dir(c);
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        if (is_not_valid(nx, ny)) {
            continue;
        }
        
        if (visited[y][x][dir] == false) {
            visited[y][x][dir] = true;
            visited[ny][nx][opposite_direction(dir)] = true;
            answer++;
        }
        
        x = nx;
        y = ny;
    }
    
    return answer;
}