# Replace ? with possible integers
N = input()
count = 1

for index, item in enumerator(N):
	if item == '?' and index == 0:
		count *= 9
	elif item == '?' and index > 0:
		count *= 10

print(count)
