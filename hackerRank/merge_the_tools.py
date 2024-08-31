def merge_the_tools(string, k):
    size = int(len(string)/k)  
    for i in range(0, size):
        print(create_u(string[i*k:(i+1)*k]))

def create_u(t):
    r = set()
    u = ""
    for c in t:
        if c not in r:
            r.add(c)
            u += c 
    return u
    
if __name__ == '__main__':
    string, k = input(), int(input())
    merge_the_tools(string, k)