<?php
$lower = strtolower($argv[1]);
$upper = strtoupper($argv[1]);
$output = "";
if (ctype_upper($argv[1][0])) {
	for ($i = 0; $i < strlen($argv[1]); $i++) {
		if (ctype_upper($argv[1][$i])) {
			$output = $output . $upper[i];
		} else {
			$output = $output . $lower[i];
		}
	}
}

for($i=0;$i<strlen($argv[1]);$i++){if($i%2==0){echo strtoupper($argv[0][$i]);}else{echo strtolower($argv[0][$i]);}}

<? $a=$argv[1];$i=0;while($a[$i]!=''){($i%2)? : $o.=ucfirst($a[$i]);$i++;}

<? $a=$argv[1];$i=0;while($a[$i]!=''){echo $a[$i];$i++;}

<?php $i=0;foreach($argv[1] as $a){echo $a;}

