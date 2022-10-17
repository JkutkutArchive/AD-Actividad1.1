#!/bin/zsh

clear;
echo "Str: \"Hello World!\"  Len: 12B"
for i in $(ls *.dat); do
	echo "\n******* $i ********";
	
	hexdump -C $i;

	fsize=$(wc -c $i | awk '{print $1}')
	echo "\nSize: ${fsize}B\n"
done


echo "\n\nNotes:"

echo "\nstring_length_utf and strig_utf_ceros"
echo "  They define the length and store the info the same way as string_uft"
echo "  However, they print then the extra chars as a double byte character"
echo "    12B string + 2 initial bytes = 14B"
echo "    Defined legth is 16 -> 16 - 12 = 4 missing chars"
echo "    4 missing chars * 2 bytes/char = 8B"
echo "    TOTAL: 14B + 8B = 22B"

echo "\nstring_utf"
echo "  Defines first the length and then the input."
