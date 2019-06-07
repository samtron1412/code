import requests

# def is_prime(number):
#   factors = [candidate_factor for candidate_factor in range(1, number+1) if number % candidate_factor == 0]
#   return len(factors) == 2

# count = 1500
# i = 0
# number = 1
# primes = []

# while i<count:
# 	if is_prime(number):
# 		primes[len(primes):] = [number]
# 		i += 1
# 	number += 1

# We could use is_prime function and loop to write a file store list of prime numbers
# fw = open('prime_list.txt', 'w')
# for item in primes:
# 	print>>fw, item

# fr = open('prime_list.txt', 'r')
with open('prime_list.txt', 'r') as fr:
    primes = [int(line.rstrip('\n')) for line in fr]

#generates a list of numbers.
# primes = [number for number in range(2, 10000) if is_prime(number)]

r = requests.get('http://hack.bckdr.in/2013-MISC-75/misc75.php')
start = r.text.find('First ')+6
end = r.text.find(' prime', start)

print int(r.text[start:end])

prime_total = sum(primes[:int(r.text[start:end])])
print prime_total

payload = {'answer': str(prime_total)}
cookies = dict(PHPSESSID=r.cookies['PHPSESSID'])
submit = requests.post('http://hack.bckdr.in/2013-MISC-75/misc75.php', data=payload, cookies=cookies)
print submit.text


