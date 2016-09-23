# Find the second largest and second smallest in a given array in single traversal.


def find_second_max(a):
    if len(a) <= 1:
        return None
    elif len(a) == 2:
        return min(a[0], a[1])
    else:
        l = sorted(a[:2])
        for i in range(2, len(a), 1):
            n = a[i]
            if n > l[1]:
                del l[0]
                l.append(n)
            elif n > l[0]:
                l[0] = n
        return l

# Slightly different approach (using sorted)                
def find_second_min(a):
    if len(a) <= 1:
        return None
    elif len(a) == 2:
        return sorted(a)[1]
    else:
        l = sorted(a[:2])
        for i in range(2, len(a), 1):
            l.append(a[i])
            l = sorted(l)
            l.pop()
        return l

def fixed_to_poli(s, k):
 
    fixed = 0
    s = list(s)
    for i in range(int(len(s)/2)):
        if (s[i] != s[len(s) - 1 - i]):
            if (fixed == k):
                return "-1"
            else:
                s[i] = s[len(s) - 1 - i]
                fixed += 1
    return "".join(s)


if __name__ == '__main__':
    a = [13, 4, 2, 18, 9, 21, 5, 1, 34]
    a = [2, 2, 2]
    
    #print(find_second_max(a))
    #print(find_second_min(a))
    s = '12437324'
    k = 3
                
    print(fixed_to_poli(s, k))