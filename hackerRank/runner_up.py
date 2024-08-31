if __name__ == '__main__':
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort(reverse=True)    
    maximo = arr[0]
    runner_up = max([x for x in arr if x != maximo])
    print(runner_up)
