def is_vowel(c):
    vowels = {'A', 'E', 'I', 'O', 'U'}
    return c in vowels

def get_all_substrings(string):
    substrings = []
    for i in range(1, len(string) + 1):
        substrings += make_substring_of_size(i, string)
    return substrings

def make_substring_of_size(i, s):
    sub = []
    for j in range(0, len(s) - i + 1):
        sub.append(s[j:j+i])
    return sub

def minion_game(string):
    kevin = 0
    stuart = 0
    substrings = get_all_substrings(string)
    for ss in substrings:
        if is_vowel(ss[0]):
            kevin += 1
        else:   
            stuart += 1

    if kevin > stuart:
        print("Kevin", kevin)
    elif stuart > kevin:
        print("Stuart", stuart)
    else:
        print("Draw")

if __name__ == '__main__':
    s = input()
    minion_game(s)