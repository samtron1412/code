/*
 * Listing all the solution for the equation: a^3 + b^3 = c^3 + d^3
 * Where a, b, c, d is in the range from 0 to 1000
 */
#include <iostream>
#include <unordered_map>
#include <list>

int main() {
    int max = 10;
    std::unordered_map<int, std::list<std::pair<int, int>>> map;
    for (int a = 0; a <= max; a++) {
        for (int b = 0; b <= max; b++) {
            map[a*a*a + b*b*b].push_back(std::pair<int, int>(a, b));
        }
    }
    int count = 0;
    for (auto& kv : map) {
        for (auto& p1 : kv.second) {
            for (auto& p2 : kv.second) {
                std::cout << p1.first << " " << p1.second << " "
                          << p2.first << " " << p2.second << std::endl;
                count += 1;
            }
        }
    }
    std::cout << count << std::endl;
}
