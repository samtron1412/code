#!/usr/bin/env python3
import sys

def main()
    count = 0
    start = int(sys.argv[2])
    end = int(sys.argv[3])
    assert start <= end, "%r is greater than %r" % (start, end)
    with open(sys.argv[1]) as log_file:
        for log_line in log_file:
            log_bits = log_line.split(' ', 2)
            if len(log_bits) < 2:
                continue
            try:
                ts = int(log_bits[0])
                code = int(log_bits[1])
            except ValueError:
                continue
            if ts < start or ts >= end:
                continue
            if code < 500 or code > 599:
                continue
            count = count + 1
    print(count)

if __name__ == "__main__":
    main()
