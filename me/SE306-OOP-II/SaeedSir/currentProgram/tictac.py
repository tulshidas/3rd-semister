arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]


def printFunction():
    # type: () -> object
    # type: () -> object
    for j in range(0, 9, 1):

        if arr[j] == 'x':
            print 'x',
        elif arr[j] == 'y':
            print 'y',
        else:
            print arr[j],
        if j == 2 or j == 5 or j == 8:
            print '\n'


printFunction()


def checkState():
    if arr[2] == arr[0] == arr[1]:
        return True
    elif arr[0] == arr[3] == arr[6]:
        return True
    elif arr[2] == arr[5] == arr[8]:
        return True
    elif arr[6] == arr[7] == arr[8]:
        return True
    elif arr[0] == arr[4] == arr[8]:
        return True
    elif arr[2] == arr[4] == arr[6]:
        return True
    else:
        return False


player = 1
for i in range(0, 9):
    print "player", player, ":"
    print "Enter position:",
    pos = input()

    while pos > 9 or pos < 1:
        print "illigal inpput"
        print "Enter position with a number between 1 and 9 ",
        pos = input()
    if player == 1:
        arr[pos - 1] = 'x'
    else:
        arr[pos - 1] = 'y'
    printFunction()
    if checkState():
        print "player :", player, "win"
        break

    if player == 1:
        player += 1
    else:
        player -= 1

print "Game over"



