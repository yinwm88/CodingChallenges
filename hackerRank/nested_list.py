if __name__ == '__main__':
    arr = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        t = (score, name)
        arr.append(t)
        
    arr.sort()

    minimo = (arr.pop(0))[0] 
    second_lowest_grade = [x for x in arr if x[0] != minimo].pop(0)
    for  x in arr:
        if(x[0] == second_lowest_grade[0]):
            print(x[1])

        
        