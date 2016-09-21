from random import randint

def merge_intervals(intervals):
    if len(intervals) == 0:
        return list()
    sorted_intervals = sorted(intervals, key=lambda x: x[0])
    it = iter(sorted_intervals)
    curr = next(it)
    l = list()
    for i in it:
        if i[0] <= curr[1]:
            curr[1] = max(i[1], curr[1])
        else:
            l.append(curr)
            curr = i
    l.append(curr)
    return l



if __name__ == '__main__':
    #intervals = [[1, 2], [6, 9], [3, 4], [2, 5], [18, 18], [9, 20], [16, 17], [6, 18], [4, 11], [8, 12], [3, 5], [7, 9], [9, 10], [8, 20]]
    #intervals = [[2, 4], [1, 5]]
    intervals = list()
    # Contruct list
    for i in range(10):
        r1 = randint(0, 20)
        r2 = randint(0, 20)
        intervals.append([min(r1, r2), max(r1, r2)])
    print(intervals)
    print(merge_intervals(intervals))
    
    
        