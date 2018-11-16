## GreaterThan

main:

la	$a0, dialog_1		## load the address of dialog_1 label to $a0
li	$v0, 4				## ask the system to print dialog_1 string in console	
syscall



li	$v0, 5				## take first number from user
syscall

move	$t1, $v0 		##move the first number to $t1 register


la	$a0, dialog_2		## load the address of dialog_2 label
li	$v0, 4				## ask the system to print dialog_2 string in console	
syscall


li	$v0, 5				## take the second number
syscall

move $t2, $v0			## move the second number to $t2


bgt		$t1, $t2, bigger	## find out if $t1 > $t2
move	$t0, $t2			## if $t1 < $t2, then move the value of $t2 into $t0
b		else				

bigger:		
move $t0, $t1				#if $t1 > $t2, then move the value of $t1 into $t0

else:

la	$a0, print				## assign $a0 a string "labeled" print
li	$v0, 4					## ask system to print the message in the console
syscall

move	$a0, $t0			## now move the value of $to to $a0
li	$v0, 1					## ask the system to print the value of $a0
syscall


li $v0, 10					## assign value 10 to $v0, ask system to exit 
syscall



.data
dialog_1:		.asciiz		"Enter a number:\t"
dialog_2:		.asciiz		"Enter another number:\t" 
print:			.asciiz		"The Larger number is :\t"