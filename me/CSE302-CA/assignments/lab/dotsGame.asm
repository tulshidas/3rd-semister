.text
main:
# print welcome Message
	li $v0,4    
	la $a0, welcomeMessage   
	syscall

   ## jal printBoard
  # print "Enter two number to initialize the random function
	li $v0,4
	la $a0, randomInitializerMassage
	syscall
# print "Enter number 1:"
	li $v0,4
	la $a0, randomNumber1InputMessage
	syscall
#take the number from keyboard
	li $v0,5
	syscall
	
#  store the value of $v0 to m_w
	la $t0, m_w
	sw  $v0, ($t0)
	
#  print "Enter number 2:"
     li $v0,4
	la $a0, randomNumber2InputMessage
	syscall
# take integer from keyboard

	li $v0, 5
	syscall
# store the value to m_z
     sw $v0, m_z
     
##     jal get_random
     
     li $a0, 1
     li $a1, 2
     li $a2, 5
     li $a3, 4
 #   jal isValid
     
   jal printBoard
	
    
     
## jal play

 ##   lw $t0, myScore
##    lw $t1, yourScore
   
##    bgt $t0, $t1, YouWin
 # print "\nYou win!!\n\n"
## YouWin: 
## 	li $v0,4
## 	la $a0, winMessage1
## 	syscall
## 	j exit
 # print "\nI win!!\n\n"
##Iwin:  
##   li $v0,4
## 	la $a0, winMessage2
## 	syscall
exit:
	
	li $v0, 10
	syscall
	


printBoard:
	la $t0, board
	
	li $v0,11
    	li $s0,0
     
     loop1: li $s1,0
     	loop2: 
     	    lb $a0, ($t0)
     	    syscall
        	    addi $t0,$t0,1
     	    addi  $s1, $s1, 1
	         blt $s1, 10,loop2
     addi $s0, $s0, 1
     blt $s0, 5, loop1
    	
	jr $ra

get_random:
# m_z = 36969 * (m_z & 65535) + (m_z >> 16)
	
	lw $t0,  m_z
	li $t1, 65535
	
	and $t2, $t0, $t1 
	
	li $t1, 36969
	mulu $t2, $t2, $t1
	
	srl $t1, $t0, 16
	
	addu $t2, $t2, $t1
	abs $t2, $t2
	sw $t2, m_z


# m_w = 18000 * (m_w & 65535) + (m_w >> 16);

	lw $t0,  m_w
	li $t1, 65535
	
	and $t2, $t0, $t1 
	
	li $t1, 18000
	mulu $t2, $t2, $t1
	
	srl $t1, $t0, 16
	addu $t2, $t2, $t1
	abs $t2, $t2
	sw $t2, m_w

#	return (m_z << 16) + m_w; /* 32-bit result */

	lw $t0, m_z
	lw $t1, m_w
	sll $t0, $t0 ,16
	addu $t0, $t0, $t1
	
	move $v0, $t0
	
	jr $ra
	
	
isValid:
# int row1 ==$a0 ,int column1=$a1,int row2==$a2 ,int column2 == $a3
	
#     if(row1<1 || row1>4) return 0;

	blt $a0 , 1, L1
	bgt $a0, 4, L1
	j L2
	
L1:  li $v0,0
	jr $ra

#    if(column1<1 || column1>4) return 0;
L2:  blt $a1, 1 ,L3
	bgt $a1, 4 ,L3	
 	j L4
 	
L3:  li $v0,0
	jr $ra

#    if(row2<1 || row2>4) return 0;
L4:  blt $a2, 1 ,L5
	bgt $a2, 4 ,L5	
 	j L6

L5:  li $v0,0
	jr $ra

#     if(column2<1 || column2>4) return 0;
L6:	blt $a3, 1 ,L7
	bgt $a3, 4 ,L7	
 	j L8

L7:  li $v0,0
	jr $ra

L8:  li $v0,1
	jr $ra

.data
m_w:   .space 4           #int m_w
m_z:   .space 4           #int m_z   
myScore:   .word  0       #int myScore=0
yourScore:  .word  0      #int yourScore=0

# "a . . . .\n"
# 'b',' ','.',' ','.',' ','.',' ','.','\n'
# 'c',' ','.',' ','.',' ','.',' ','.','\n'
# 'd',' ','.',' ','.',' ','.',' ','.','\n'
board:  .byte   ' ',' ','1',' ','2',' ','3',' ','4','\n','a',' ','.',' ','.',' ','.',' ','.','\n','b',' ','.',' ','.',' ','.',' ','.','\n','c',' ','.',' ','.',' ','.',' ','.','\n','d',' ','.',' ','.',' ','.',' ','.','\n'


welcomeMessage:  .asciiz  "Welcome to Dots and Boxes!\nVersion 1.0\nImplemented by: \n1.Uddip Acharjee\n2.Obaidur Rahman\n3.Hasnuzzaman Hasan\n4.Tulshi Chandra Das\n\n"
randomInitializerMassage:	.asciiz   "\nEnter two positive numbers to initialize the random number generator.\n"
randomNumber1InputMessage:	 .asciiz  "Number 1: "
randomNumber2InputMessage:    .asciiz   "Number 2: "

winMessage1:  .asciiz  "\nYou win!!\n\n"
winMessage2:  .asciiz  "\nI win!!\n\n"
newLine:   .asciiz  "\n"
