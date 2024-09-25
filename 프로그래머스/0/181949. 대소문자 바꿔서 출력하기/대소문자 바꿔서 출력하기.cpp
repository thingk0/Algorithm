#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    
    transform(str.begin(), str.end(), str.begin(), [](unsigned char c) {
        return islower(c) ? toupper(c) : tolower(c);
    });
    
    cout << str << endl;
    return 0;
}