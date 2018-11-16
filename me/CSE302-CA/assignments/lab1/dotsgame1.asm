.data
m_w:   .space 4           #int m_w
m_z:   .space 4           #int m_z   
myScore:   .word  0       #int myScore=0
yourScore:  .word  0      #int yourScore=0
board: .asciiz "  1 2 3 4\na . . . .\nb . . . .\nc . . . .\nd . . . .\n"
welcomeMessage:  .asciiz  "Welcome to Dots and Boxes!\nVersion 1.0\nImplemented by: \n1.Uddip Acharjee\n2.Obaidur Rahman\n3.Hasnuzzaman Hasan\n4.Tulshi Chandra Das\n\n"
randomInitializerMassage:	.asciiz   "\nEnter two positive numbers to initialize the random number generator.\n"
randomNumber1InputMessage:	 .asciiz  "Number 1: "
randomNumber2InputMessage:    .asciiz   "Number 2: "
winMessage1:  .asciiz  "\nYou win!!\n\n"
winMessage2:  .asciiz  "\nI win!!\n\n"
newLine:   .asciiz  "\n"
###

msg1: .asciiz "  Enter coordinate of the first dot: "
msg2: .asciiz "  Enter coordinate of the second dot: "
str: .space 4
row1: .space 4
column1: .space 4
row2: .space 4
column2: .space 4
msg3: .asciiz "Coordinates must be adjacent\n"
msg4: .asciiz "There is already a line there.\n"
space: .byte ' '
underscore: .byte '_'
line: .byte '|'
H: .byte 'H'
C: .byte 'C'

iteration: .word 1
randomValue: .word 1
prev: .word 0
isFirstMove: .word 1
player1: .asciiz "player 1:\n"
player2: .asciiz "player 2:\n"
p1: .asciiz "\nplayer 1 wins!!\n"
p2: .asciiz "\nplayer 2 wins!!\n"


.text
main:
# print welcome Message
	li $v0,4    
	la $a0, welcomeMessage   
	syscall

  jal printBoard
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
     

     
    
 #   jal isValid
     
 #  jal printBoard
	
    
     
 jal play

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

###

play:
		
	while:
	lw $t0,iteration
	bgt $t0,24,endWhile
	 
	li $t7,2
	div $t0,$t7
	mfhi $t7
	
	beqz $t7,turn
		li $v0,4
		la $a0,player1
		syscall
		j turn_over
	turn:
		li $v0,4
		la $a0,player2
		syscall
	turn_over:
	##  read the first dot
	li $v0,4
	la $a0,msg1
	syscall
	
	li $v0,8
	la $a0,str
	li $a1,4
	syscall
	
	#convert string to row1 and column1
	li $t0,0				
	lb $t0,str($t0)			
	addi $t0,$t0,-96		
	sw $t0,row1				
	
	li $t0,1
	lb $t0,str($t0)
	addi $t0,$t0,-48
	sw $t0,column1
	
	## read the second dot	
	li $v0,4
	la $a0,msg2
	syscall
	
	li $v0,8
	la $a0,str
	li $a1,4
	syscall
	
	#convert string to row2 and column2
	li $t0,0
	lb $t0,str($t0)
	addi $t0,$t0,-96
	sw $t0,row2
	
	li $t0,1
	lb $t0,str($t0)
	addi $t0,$t0,-48
	sw $t0,column2
	
	#####################
	
	lw $t0,row1
	lw $t1,row2
	lw $t2,column1
	lw $t3,column2
	
	bne $t0,$t1,else1
		
		addi $t4,$t3,1
		subi $t5,$t3,1
		
		beq $t2,$t4,col_adjacent
		bne $t2,$t5,else3
		col_adjacent:
			blt $t2,$t3,min
			move $t4,$t3
			j min_found
			min: move $t4,$t2		## ## ##   $t4 = min($t2,$t3)
			min_found:
			
			# if( board[row1][min*2+1]==' ')
			mul $t5,$t0,10			##  $t5 = row1*10    for getting the row number
			
			mul $t9,$t4,2			# $t9=min*2
			addi $t9,$t9,1			# $t9= min*2+1
			
			add $t6,$t5,$t9			#####  $t6= board(row1*10+(min*2+1))
			
			lb $t7,board($t6)		# $t7= board($t6)
			
			lb $t8,space
			bne $t7,$t8,else4		## if( $t7 !=$t8) go to else4
				
				lb $t8,underscore
				sb $t8,board($t6)
				
				##  if( row1!=4)
				beq $t0,4,check_upper_box
					addi $t5,$t0,1
					mul $t5,$t5,10		### $t5=row1+1
					
					mul $t9,$t4,2		# $t9=min*2
					add $t6,$t5,$t9     # address of  board[row+1][min*2]
					
					lb $t7,board($t6)
					lb $t8,line
					
					bne $t7,$t8,check_upper_box
					
					add $t9,$t9,1  		#$t9=min*2+1
					add $t6,$t5,$t9			# address of  board[row+1][min*2+1]
					
					lb $t7,board($t6)
					lb $t8,underscore
					
					bne $t7,$t8,check_upper_box
					
					add $t9,$t9,1
					add $t6,$t5,$t9			# address of  board[row+1][min*2+2]
					
					lb $t7,board($t6)
					lb $t8,line
					
					bne $t7,$t8,check_upper_box
						add $t9,$t9,-1
						add $t6,$t5,$t9			# address of  board[row+1][min*2+1]
						
						####  if(iteration%2==0)
						lw $t8,iteration
						li $t7,2
						div $t8,$t7
						mfhi $t8
						
						bnez $t8,fill_with_C1
							lb $t7,H
							sb $t7,board($t6)
							
							lw $t7,yourScore
							addi $t7,$t7,1
							sw $t7,yourScore
							
							j check_upper_box
						fill_with_C1:
							lb $t7,C
							sb $t7,board($t6)
							
							lw $t7,myScore
							addi $t7,$t7,1
							sw $t7,myScore
						
					
				check_upper_box:
				## if( row1 !=1)
				beq $t0,1,upper_box_checking_finished
					mul $t5,$t0,10
					mul $t9,$t4,2
					add $t6,$t5,$t9
					lb $t7,board($t6)
					lb $t8,line
					
					bne $t7,$t8,upper_box_checking_finished
					addi $t9,$t9,2	
					add $t6,$t5,$t9
					lb $t7,board($t6) 
					lb $t8,line
					
					bne $t7,$t8,upper_box_checking_finished
					addi $t5,$t0,-1
					mul $t5,$t5,10
					mul $t9,$t4,2
					addi $t9,$t9,1
					add $t6,$t5,$t9
					lb $t7,board($t6) 
					lb $t8,space
					
					beq $t7,$t8,upper_box_checking_finished
						mul $t5,$t0,10
						add $t6,$t5,$t9
						
						####  if(iteration%2==0)
						lw $t8,iteration
						li $t7,2
						div $t8,$t7
						mfhi $t8
						
						bnez $t8,fill_with_C2
							lb $t7,H
							sb $t7,board($t6)
							
							lw $t7,yourScore
							addi $t7,$t7,1
							sw $t7,yourScore
							
							j upper_box_checking_finished
						fill_with_C2:
							lb $t7,C
							sb $t7,board($t6)
							
							lw $t7,myScore
							addi $t7,$t7,1
							sw $t7,myScore
						
				upper_box_checking_finished:
				
				####  call  printBoard
				addi $sp,$sp,-4
				sw $ra,4($sp)
				
				jal printBoard
				
				lw $ra,4($sp)
				addi $sp,$sp,4
				
				#####   iteration++  
				lw $t0,iteration
				addi $t0,$t0,1
				sw $t0,iteration
				
				j next
			else4:
				li $v0,4
				la $a0,msg4
				syscall
				j next
		else3:
		li $v0,4
		la $a0,msg3
		syscall
		
		j next
	else1:
		bne $t2,$t3,coor_not_adjacent   ##  if(column1!=column2) goto coor_not_adjacent
		addi $t4,$t1,1
		addi $t5,$t1,-1
		beq $t0,$t4,row_equal
		bne $t0,$t5,coor_not_adjacent
		row_equal:
			bgt $t0,$t1,max
			move $t4,$t1
			j max_found
			max: move $t4,$t0             ###  $t4=max($t0,$t1)
			max_found:
			
			mul $t5,$t4,10      		###  $t5= max*10         
			mul $t9,$t2,2                #  $t9 =$t2*2
			
			add $t6,$t5,$t9             #### address in board element
			
			lb $t7,board($t6)
			lb $t8,line
			
			beq $t7,$t8,line_there
				sb $t8,board($t6)
				
				# if(column1!=4)
				beq $t2,4,check_left_box
					addi $t9,$t9,1
					add $t6,$t5,$t9
					lb $t7,board($t6)
					lb $t8,underscore
					
					bne $t7,$t8,check_left_box
					
					subi $t5,$t4,1
					mul $t5,$t5,10
					add $t6,$t5,$t9
					lb $t7,board($t6)
					lb $t8,space
					
					beq $t7,$t8,check_left_box 
					
					mul $t5,$t4,10
					addi $t9,$t9,1
					add $t6,$t5,$t9
					lb $t7,board($t6)
					lb $t8,line
					
					bne $t7,$t8,check_left_box
						addi $t9,$t9,-1
						add $t6,$t5,$t9
						
						####  if(iteration%2==0)
						lw $t8,iteration
						li $t7,2
						div $t8,$t7
						mfhi $t8
						
						bnez $t8,fill_with_C3
							lb $t7,H
							sb $t7,board($t6)
							
							lw $t7,yourScore
							addi $t7,$t7,1
							sw $t7,yourScore
							
							j check_left_box
						fill_with_C3:
							lb $t7,C
							sb $t7,board($t6)
							
							lw $t7,myScore
							addi $t7,$t7,1
							sw $t7,myScore
				
				check_left_box:
				# if(column1!=1)
				beq $t2,1,checking_left_box_finished
					mul $t5,$t4,10
					mul $t9,$t2,2
					addi $t9,$t9,-1
					add $t6,$t5,$t9
					lb $t7,board($t6)
					lb $t8,underscore
					
					bne $t7,$t8,checking_left_box_finished
					
					addi $t5,$t4,-1
					mul $t5,$t5,10
					add $t6,$t5,$t9
					lb $t7,board($t6)
					lb $t8,space
					
					beq $t7,$t8,checking_left_box_finished
					
					mul $t5,$t4,10
					addi $t9,$t9,-1
					add $t6,$t5,$t9
					lb $t7,board($t6)
					lb $t8,line
					
					bne $t7,$t8,checking_left_box_finished
						addi $t9,$t9,1
						add $t6,$t5,$t9
						
						####  if(iteration%2==0)
						lw $t8,iteration
						li $t7,2
						div $t8,$t7
						mfhi $t8
						
						bnez $t8,fill_with_C4
							lb $t7,H
							sb $t7,board($t6)
							
							lw $t7,yourScore
							addi $t7,$t7,1
							sw $t7,yourScore
							
							j checking_left_box_finished
						fill_with_C4:
							lb $t7,C
							sb $t7,board($t6)
							
							lw $t7,myScore
							addi $t7,$t7,1
							sw $t7,myScore
				    
				checking_left_box_finished:
				
				####  call  printBoard
				addi $sp,$sp,-4
				sw $ra,4($sp)
				
				jal printBoard
				
				lw $ra,4($sp)
				addi $sp,$sp,4
				
				
				#####   iteration++  
				lw $t0,iteration
				addi $t0,$t0,1
				sw $t0,iteration
				
				j next
			line_there:
				li $v0,4
				la $a0,msg4
				syscall
				j next
		coor_not_adjacent:
			li $v0,4
			la $a0,msg3
			syscall
	next:
	j while
	
	endWhile:
	jr $ra
	



