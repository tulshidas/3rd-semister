CC=gcc
STRIP=/usr/bin/strip
CFLAGS=-Wall
LDFLAGS=

all: testPHex5

testPHex5.o: testPHex5.c PrintHex.h
	   $(CC) -c $(CFLAGS) testPHex5.c

PrintHex.o: PrintHex.c PrintHex.h
	   $(CC) -c $(CFLAGS) PrintHex.c

testPHex5: testPHex5.o PrintHex.o
	$(CC) -o testPHex5 testPHex5.o PrintHex.o $(LDFLAGS)
	$(STRIP) testPHex5

.PHONY: clean

clean:
	rm -rf testPHex5 testPHex5.o PrintHex.o

