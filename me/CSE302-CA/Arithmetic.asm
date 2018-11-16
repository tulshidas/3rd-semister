## arithmetic.asm

main:

la	$a0, dialog_1		## load the address of dialog_1 label to $a0
li	$v0, 4				## ask the system to print dialog_1 string in console
syscall

li	$v0, 5				## ask system to take first number from user
syscall
move	$t1, $v0		## move value of $v0 to $t1



la	$a0, dialog_2		## load the address of dialog_2 label to $a0
li	$v0, 4				## ask the system to print dialog_2 string in console
syscall

li	$v0, 5				## ask system to take another number from user
syscall
move	$t2, $v0		## move value of $v0 to $t2





##addition starts

add		$t0, $t1, $t2		##add $t1 & $t2 and store value in $t0
la		$a0, Summation	## load the address of Summation label to $a0	
li		$v0, 4			## ask the system to print Summation string in console
syscall


move 	$a0, $t0		##move value of $a0 to $t0
li		$v0, 1 			## ask the system to print the value of $a0
syscall




##subtraction starts

sub		$t0, $t1, $t2		##subtract $t2 from $t1 and store value in $t0

la		$a0, Subtrac		## load the address of Subtrac label to $a0
li		$v0, 4				## ask the system to print Subtrac string in console
syscall

move	$a0, $t0			##move value of $a0 to $t0
li		$v0, 1				## ask the system to print the value of $a0
syscall




##Multiplication starts

mul		$t0, $t1, $t2		##multiply $t1 with $t2 and store value in $t0

la		$a0, Multiplication	## load the address of Subtrac label to $a0
li		$v0, 4				## ask system to print Multiplication string in console
syscall

move	$a0, $t0			##move value of $a0 to $t0
li		$v0, 1				## ask the system to print the value of $a0
syscall


##Division starts

div		$t0, $t1, $t2		##Divide $t1 by $t2 and store value in $t0

la		$a0, Division		## load the address of Division label to $a0
li		$v0, 4				## ask system to print Division string in console
syscall

move	$a0, $t0			##move value of $a0 to $t0
li		$v0, 1				## ask the system to print the value of $a0
syscall



li		$v0, 10				## assign value 10 to $v0, ask system to exit
syscall



.data

dialog_1:		.asciiz		"Please Enter the first Number : \t"
dialog_2:		.asciiz		"Please Enter the second Number: \t"
Summation:		.asciiz		"\nAddition (Number1 + Number2) = "
Subtrac:		.asciiz		"\nSubtraction (Number1 - Number2) = "
Multiplication:	.asciiz		"\nMultiplication (Number1 X Number2) = "
Division:		.asciiz		"\nDivision (Number1 / Number2) = "