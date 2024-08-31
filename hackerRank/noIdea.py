if __name__ == '__main__':
    d = list(map(int, input().split()))
    n = d.pop(0)
    m = d.pop(0)
    elements = list(map(int, input().split()))
    aSet = set(map(int, input().split()))
    bSet = set(map(int, input().split()))
    ans = 0
    for x in elements:
        if(x in aSet):
            ans += 1
        elif(x in bSet):
            ans -= 1
    print(ans)      
    