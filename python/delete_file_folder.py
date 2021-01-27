import os
import time
import shutil

if os.path.exists("filename.txt"):
	os.remove("filename.txt")
else:
	print("the file does not exist")

os.mkdir("myfolder")
fileHandle = open("myfolder/filename.txt", "a")
#wait for 5 seconds
time.sleep(2)
# os.rmdir("myfolder")

# delete the non empty folder myfolder
shutil.rmtree('myfolder')
