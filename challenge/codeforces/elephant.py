#!/usr/bin/python

import sys

def elephant(argv):
	print 'Number of arguments:',len(argv), 'arguments.'
	print 'Argument List:', str(argv)

def main(argv):
	elephant(argv)

if __name__ == '__main__':
	main(sys.arg[1:])
