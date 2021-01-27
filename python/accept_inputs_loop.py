import re
name = input("Enter your name: ")
while True:  
  if re.findall("[0-9]", name):
  	print("inproper name input")
  	name = input("Enter your name: ")
  	continue

  age = input("Enter your age: ")
  try:
    int(age)
  except ValueError:
    print("inproper age input")
    continue
  else:
  	break
  
print("welcome, {}. {} is golden".format(name, age))
