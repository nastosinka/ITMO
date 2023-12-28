<?
$site_title = "PHP exercise";
?>
<!DOCTYPE html>
<html>
<head>
	<meta content="text/html", charset="utf-8">
	<title><? print $site_title; ?></title>
</head>
<body>
	<p>Happy New Year tasks! Let's do the last lab of this semester:</p>
<?php

echo "1. Assigning values to variables: <br>";
$a = 10;
$b = 20;
echo "The first value a: $a.<br>";
echo "The second value b: $b.<br><br>";

echo "2. Let c be (a + b), then print c: <br>";
$c = $a + $b;
echo "The variable c is $c. <br><br>";

echo "3. Let c increase three times: <br>";
$c *= 3;
echo "The variable c is $c now. <br><br>";

echo "4. Let c decrease for (b - a) times: <br>";
$c /= $b - $a;
echo "Now the variable c is $c. <br><br>";

echo "5. Let's create new variables p and b: <br>";
$p = "Programm";
$b = "is working";
echo "\"$p\" and \"$b\" <br>";

echo "6. And now let's add them: <br>";
$result = $p . ' ' . $b;
echo "We'll get smth like \"$result\". <br><br>";

echo "7. Now we will add the word \"nice\" to our string:<br>";
$result .= " nice";
echo "$result <br><br>";

echo "8. And now we will do another things. Let q be 5 and w be 7. We will wright the script which changes the q and w values without creating new variables: <br>";
$q = 5;
$w = 7;
$q += $w;
$w = $q - $w;
$q = $q - $w;
echo "The result is $q and $w. <br><br>";

echo "9. Now we will wright a cycle which will print all numbers from 23 to 78: <br>";
$beg = 23;
while ($beg <= 78) {
	echo "$beg ";
	$beg++;
}
echo "<br><br>"; 

echo "10. Let's print an unnumbered list of ten items!";
for ($i = 1; $i <= 10; $i++) {
	echo "<li> item $i</li>";
}
echo "</ul><br>";

echo "11. Let's make an array of 100 random numbers and then print it using \"while\" construction and with \"foreach\":<br>";
$array = array();
for ($i = 0; $i <= 100; $i++) {
	$array[] = rand(1, 100);
}
echo "Printing with \"while\": <br>";
$i = 0;
while ($i < count($array)) {
    echo "$array[$i] ";
    $i++;
}
echo "<br>";
echo "Printing with foreach: <br>";
foreach ($array as $value) {
	echo "$value ";
}
echo "<br><br>";

echo "12. Next we will print the \"week-advent\": <br>";
$dayOfWeek = date('N');
switch ($dayOfWeek) {
	case 1:
		$message = "Today is a Monday";
		break;
	case 2:
		$message = "Today is a Tuesday";
		break;
	case 3:
		$message = "Today is a Wednesday";
		break;
	case 4:
		$message = "Today is a Thursday";
		break;
	case 5:
		$message = "Today is a Friday";
		break;
	case 6:
		$message = "Today is a Saturday";
		break;
	case 7:
		$message = "Today is a Sunday";
		break;
	default:
		$message = "Unregistred name of the day of the week";
}
echo "$message. <br><br>";

echo "13. And we will finish this task creating function realised on PHP:<br>";
function getPlus10($number) {
	$number += 10;
	return "$number.";
}
$result1 = "Let's test the function with the number 5: getPlus10(5) =  ";
$result2 = getPlus10(5); 
echo $result1 . $result2;

?>
</body>
</html>