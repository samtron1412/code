#!/usr/bin/perl

print@ARGV[0]=~s/([a-z])([^a-z]*)([a-z])/uc($1).$2.lc$3/egri

# print@ARGV[0]=~s/([a-z][^a-z]*)([a-z]?)/\u$1\l$2/egri
# print@ARGV[0]=~s/(\w\W*)(\w?)/\u($1).lc$2/erg
# print join'',(@ARGV[0]=~/./g)=~s/(.)(.)/uc($1).$2/egr
# $s=@ARGV[0];print $s=~s/(.)(.)/$1.uc$2/egr;
# print@ARGV[0]=~s/(.)[^A-z]*(.)/uc$1.$2.$3/egr
# say map {/\P{Cased}/ ? $_ : $c++%2 ? lc : uc}
# perl -e "print map{$c++%2?chr$_^' ':chr$_}unpack'C*',$ARGV[0]" "like this"
# print@ARGV[0]=~s/(\w)(\w)/\L$1\U$2/g
# say@ARGV[0]=~s/(.)/($x++%2==0)?"\U$1":"\L$1"/eg
# print@ARGV[0]=~s/([a-z])([^a-z]*)([a-z])/uc($1).$2.lc$3/egri
