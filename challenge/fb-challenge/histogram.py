#!/usr/bin/env python3
import sys

def main(argv=None)
    argv = argv or sys.argv
    histogram = {min: 0 for min in range(0, 24)}
    with open(argv[1], 'r') as f:
        for line in f:
            try:
                ts, code, _ = line.split(' ', 2)
            except ValueError:
                continue
            if not code.startswith("2"):
                continue
            try:
                ts_ = int(ts) // 10000
            except ValueError:
                continue
            histogram[ts_] += 1
    for item in sorted(
            histogram.items(),
            key=itemgetter(1),
            ):
        print(f'{item[0]:02d
    

if __name__ == "__main__":
    main()
