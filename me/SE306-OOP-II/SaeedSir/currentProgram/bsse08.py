class BSSE08error(RuntimeError):
    def __init__(self, arg):
        self.args = arg




from ooc_class import Car

car1 = Car('Toyota')
car1.printAll() 


'''
def numberCheck(num1, num2):
    numInt1 = int(num1)
    numInt2 = int(num2)
    
    if numInt1 == numInt2:
        print 'Similar'
    else:
        print 'Different'

    return
    
numberCheck(raw_input(), "IIt")
'''    


'''
def writeInFile():
    try:
        fileToWrite = open("test.txt","w")
        fileToWrite.write("BSSE08 IIT")
        
    except IOError:
        print "File IO Error"
        
    else:
        print "file write successfully"
        fileToWrite.close()

writeInFile()
'''

'''
name = raw_input()
age = int(raw_input())


print "MY name is ",name, " IIT"
'''

'''
class Student(Account):
    age = 20
    
    def __init__(self, name, age):
        self.name = name 
        self.age = age
    
    def printInfo(self):
        print self.name 
        print self.age

s1 = Student('Tahil', 19)
s1.printInfo() 
'''


'''
def oddNumber(num):
    for i in range(1,num,2):
       print i
    
    return
    
oddNumber(50)

number = 1

for i in range(0,100,1):
       
    if i == 5:
        print i 
        break
    
print 'Thank you'    
    
while number < 10:
    print number * number
    number += 1

print 'Thank you'
'''


'''
name = ["Tahil", 123, 123.5, "IIT"]

teacher = {'IIT': 'Prof Sakib', 'Math':'Prof Amullya Chandra', 'INFS':1941}

print teacher['Math']


#print "Good Morning BSSE08"

batch = 19

if batch == 9:
    print "New Batch, Welcome"
    print "Orientation"
else:    
    if batch > 9:
        print "Not Enrolled"
    else:    
        print "Already enrolled"
print "IIT DU"
'''


