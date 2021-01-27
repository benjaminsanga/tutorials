try:
	fileHandle = open('demofile.txt', 'r')
except FileNotFoundError as e:
	print("check name of file")
else:
	# print(fileHandle.read(5))
	# print(fileHandle.readline())
	for eachLine in fileHandle:
		print(eachLine)
finally:
	fileHandle.close()
