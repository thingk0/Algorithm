#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    
    unordered_map<string, int> ranks;
    
    for (int i = 0; i < players.size(); i++) {
        ranks[players[i]] = i + 1;
    }
    
    for (const string& calling : callings) {
        int rank = ranks[calling];
        string prev_player = players[rank - 2];
        
        ranks[calling] = rank - 1;
        ranks[prev_player] = rank;
        
        swap(players[rank - 1], players[rank - 2]);
    }
    
    return players;
}