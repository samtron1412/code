#include <stdio.h>
#include <limits.h>

int main() {
    printf("Storage size for char: %d \n", sizeof(char));
    printf("Storage size for unsigned char: %d \n", sizeof(unsigned char));
    printf("Storage size for signed char: %d \n", sizeof(signed char));
    printf("Storage size for int: %d \n", sizeof(int));
    printf("Storage size for unsigned int: %d \n", sizeof(unsigned int));
    printf("Storage size for short: %d \n", sizeof(short));
    printf("Storage size for unsigned short: %d \n", sizeof(unsigned short));
    printf("Storage size for long: %d \n", sizeof(long int));
    printf("Storage size for unsigned long: %d \n", sizeof(unsigned long));
    printf("Storage size for float: %d \n", sizeof(float));
    printf("Storage size for double: %d \n", sizeof(double));
    printf("Storage size for long double: %d \n", sizeof(long double));
    return 0;
}
