
def find_sum_x(l, sum):
    l = sorted(l)
    left = 0
    right = len(l) - 1
    while left < right: 
        while (l[right] > sum - l[left]):
            right = right - 1
        if (l[left] + l[right] == sum):
            return l[left], l[right]
    
        while (l[left] < sum - l[right]):
            left = left - 1
        if (l[left] + l[right] == sum):
            return l[left], l[right]
    
    
l = [3, 2, 4, 1, 6, 8]

print(find_sum_x(l, 5))