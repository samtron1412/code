#!/usr/bin/env python3
import sys

def main()
    with open(sys.argv[1]) as f:
        content = f.readlines()
    content = [x.strip() for x in content]
    total = 0
    for i in content:
        i = i.split()
        if i[1] == '404':
            total += 1
    print(total)

if __name__ == "__main__":
    main()
