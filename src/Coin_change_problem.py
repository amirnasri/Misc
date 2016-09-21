N = 6 
C = [7, 11, 5]

def find_change_coin(N, C):
    C = sorted(C, reverse = True)
    M = len(C)
    table = []
    table.append([1]* M)
    
    for n in range(1, N + 1, 1):
        table.append([0] * M)
        for m in range(M):
            c = C[m]
            if m == 0:
                table[n][m] = 1 if n%c == 0 else 0
            else:  
                k = n
                while k >= 0:
                    table[n][m] += table[k][m - 1]
                    k -= c
    return table[N][-1]
            
            
            
print(find_change_coin(N, C))