# Check for match of first string in second string
first_string, second_string = input().split(' ')
first_string = { x:0 for x in first_string }
ans = 0

first_string_list = list(first_string)

for i in second_string:

	if i in first_string_list:
		first_string_list.remove(i)

	if len(first_string_list) == 0:
		ans = 1
		break

print(ans)
