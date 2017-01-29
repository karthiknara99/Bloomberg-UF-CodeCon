#Problem        : Grasshopper
#Language       : Python
#Compiled Using : py_compile
#Version        : Python 2.7.8
#Input for your program will be provided from STDIN
#Print out all output from your program to STDOUT

def lc(m,n,k):
    cost = []
    for i in range(n):
        max_inc_lis = lis(m[i],k)
        cost.append(max_inc_lis)
    return cost

def lis(arr,n):
    lis = [1]*n
    for i in range(1,n):
        for j in range(0,i):
            if arr[i] > arr[j] and lis[i] < lis[j] + 1 :
                lis[i] = lis[j] + 1
    maximum = 0
    for i in range(n):
        maximum = max(maximum,lis[i])
    return maximum

def transform(m,n,k):
    transpose = [ list(i) for i in zip(*m) ]
    for element in range(k):
        column = transpose[element]
        if element % 2 == 0:
            transpose[element] = column[1:] + column[:1]
        else:
            transpose[element] = column[-1:] + column[:-1]
    m = [ list(i) for i in zip(*transpose) ]
    return m

d = int(raw_input())
n = int(raw_input())
k = int(raw_input())

matrix = [[0]*k for i in range(n)]

for i in range(n):
    matrix[i]= [int(inp) for inp in raw_input().split()]

laneCost = lc(matrix,n,k)
rabbit, grasshopper = 0, 0

for day in range(d):
    for lane in range(n):
        maxCost = max(laneCost)
        laneCost.remove(maxCost)
        if ( day + lane ) % 2 == 0:
            rabbit += maxCost
        else:
            grasshopper += maxCost
    if day != d-1:
        matrix = transform(matrix,n,k)
        laneCost = lc(matrix,n,k)

if( grasshopper > rabbit ):
    print ("1 %d" %(grasshopper) )
else:
    print ("0 %d" %(grasshopper) )