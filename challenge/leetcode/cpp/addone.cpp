#include <vector>
#include <iostream>

std::vector<int> addOne(std::vector<int> arr) {
    int carry = 1;
    int sum = 0;
    for (int i = arr.size() - 1; i >= 0; i--) {
        sum = arr[i] + carry;
        carry = sum / 10;
        arr[i] = sum % 10;
        if (carry == 0) {
            return arr;
        }
    }
    std::vector<int> newArr = std::vector<int>(arr.size() + 1);
    newArr[0] = carry;
    for (int i = 0; i < arr.size(); i++) {
        newArr[i + 1] = arr[i];
    }
    return newArr;
}

int main() {
    std::vector<int> arr{9};
    std::vector<int> newArr = addOne(arr);
    for (int i : newArr) {
        std::cout << i << ", ";
    }
}
