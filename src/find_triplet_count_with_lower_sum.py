


def find_count_pair(a, sum):
    i = 0
    j = len(a) - 1
    count = 0
    while j >= 0:
        if (i <= j):
            while (i < j and a[i] + a[j] < sum):
                i += 1
            count += i
        else:
            count += j
        j -= 1
    return count
    
def find_count(a, sum):
    
    
    
    
a = [1, 2, 5, 6, 10]
a = sorted(a)

print(find_count(a, 6.1))

