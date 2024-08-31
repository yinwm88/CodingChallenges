
def jump_game(arr):
    goal = len(arr)-1
    for i in range(len(arr)-2,-1,-1):
        if arr[i] + i >= goal:
            goal = i
    return goal == 0

arr_zero = [2, 3, 1,1 ,4] # TRUE
arr_uno = [2, 0, 0] # TRUE
arr_dos = [3, 2, 1, 0, 4] #FALSE
arr_tres = [1, 1, 2, 5, 2, 1, 0, 0, 2, 1] # TRUE
arr_fail = [3,0, 8,2,0,0,1] # True

print(f"[2, 3, 1,1 ,4]:{jump_game(arr_zero)}")
print(f"[2, 0, 0]:{jump_game(arr_uno)}")
print(f"[3, 2, 1, 0, 4]:{jump_game(arr_dos)}")
print(f"[1, 1, 2, 5, 2, 1, 0, 0, 2, 1]:{jump_game(arr_tres)}")
print(f"[3,0, 8,2,0,0,1] :{jump_game(arr_fail)}")
