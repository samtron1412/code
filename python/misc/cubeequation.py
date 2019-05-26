"""Listing all solutions of the equation a^3 + b^3 = c^3 + d^3"""

def cubeequation():
    max = 11
    map = {}
    count = 0
    for a in range(max):
        for b in range(max):
            key = a*a*a + b*b*b;
            if key not in map:
                map[key] = []
            map[key].append([a, b])
    for lst in map.values():
        for p1 in lst:
            for p2 in lst:
                print(p1[0], p1[1], p2[0], p2[1])
                count += 1
    print(count)

