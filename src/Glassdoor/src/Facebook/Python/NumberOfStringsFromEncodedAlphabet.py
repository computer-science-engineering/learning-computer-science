"""
 Given the alphabet encoded as numbers (e.g., a=1, b=2, ..., z=26),
 and a sequence of numbers (e.g., "23413259802"),
 how many strings can be generated.
"""
def find_strings(x):
    nums = []
    prev = ""
    total = 0
    for i in str(x):
        if int(i) != 0:
            total += 1
            nums.append(int(i))
        if prev:
            if int(prev + i) != int(i) and int(prev+i) < 27:
                total += 1
                nums.append(int(prev+i))
        prev = i
    return total, nums

def main():
    print(find_strings(23413259802))

if __name__ == '__main__':
    main()
