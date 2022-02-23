import java.util.HashMap;
import java.util.Map;
import java.lang.StringBuilder;

import java.io.*;

public class Solution {
    public static String solution(String s) {
    	// Bit string based on ints using big endian
    	// a = 1 = 100_000
    	// space = 0 = 000_000
    	// i = 10 = 010_100
    	// This is the source I used for my key: https://images.fineartamerica.com/images/artworkimages/mediumlarge/2/1-braille-alphabet-zapista-zapista.jpgp
    	// This probably would have helped more though: https://www.colorado.edu/project/bbb/sites/default/files/styles/medium/public/collection-image/braille_alphabet.png?itok=XlR0JRnf
    	Map<Character,Integer> key = new HashMap<Character,Integer>();

    	/*  __  __
    	    |1 8 |
    	    |2 16|
    	    |4 32|
    	    --  --
    	*/
    	Integer[] braille_list = {  1, 3, 9,25,17,11,27,19,10,26,
                	                5, 7,13,29,21,15,31,23,14,30,
                	               37,39,58,45,61,53, 8, 4, 0,48,
                	               38,22,47, 2,36,50,32,60, 6,18,
                	               52,48,54,12,44,22,18,20,40,60,
                	               26, 1, 3, 9,25,17,11,27,19,10    };
      int index = 0;
      for(int i = 'a'; i <= 'z'; i++){
          char c = (char)i;
          index = i - 'a';
          key.put(c, braille_list[index]);
      }
      // decimal = ~
      // capital = =
      // letter = $
      index++;
    	key.put('`', braille_list[index++]);
    	key.put('\'', braille_list[index++]);
    	key.put(' ', braille_list[index++]);
    	key.put('$', braille_list[index++]);
    	key.put('?', braille_list[index++]);
    	key.put('!', braille_list[index++]);
    	key.put('&', braille_list[index++]);
    	key.put(',', braille_list[index++]);
    	key.put('_', braille_list[index++]);
    	key.put('.', braille_list[index++]);
    	key.put('=', braille_list[index++]);
    	key.put('#', braille_list[index++]);
    	key.put(';', braille_list[index++]);
    	key.put(':', braille_list[index++]);
    	key.put('"', braille_list[index++]);
    	key.put('"', braille_list[index++]);
    	key.put('(', braille_list[index]);
    	key.put(')', braille_list[index++]);
    	key.put('/', braille_list[index++]);
    	key.put('@', braille_list[index++]);
    	key.put('+', braille_list[index++]);
    	key.put('-', braille_list[index++]);
    	key.put('*', braille_list[index++]);
    	key.put('~', braille_list[index++]);
    	key.put('#', braille_list[index++]);
    	key.put('0', braille_list[index++]);
    	key.put('1', braille_list[index++]);
    	key.put('2', braille_list[index++]);
    	key.put('3', braille_list[index++]);
    	key.put('4', braille_list[index++]);
    	key.put('5', braille_list[index++]);
    	key.put('6', braille_list[index++]);
    	key.put('7', braille_list[index++]);
    	key.put('8', braille_list[index++]);
    	key.put('9', braille_list[index++]);


    	String translated_s = "";

    	// For the length of s we need to convert the each character to a char and get its value
    	// Get char at i then convert number in key to binary string
    	for(int i = 0; i<s.length(); i++) {
    	    Character c = s.charAt(i);
          System.out.println("Char is: " + c);
          System.out.println("Val is: " + key.get(c));
          if (Character.isUpperCase(c)) {
            StringBuilder cap_str = new StringBuilder(Integer.toBinaryString(key.get('=') |  64 ));
            cap_str = cap_str.reverse();
      	    translated_s = translated_s.concat(cap_str.substring(0, 6));

            c = Character.toLowerCase(c);
          }
          System.out.println("Bit str is: " + Integer.toBinaryString(key.get(c)));
          System.out.println("2^6 str is: " + Integer.toBinaryString(64));
    	    StringBuilder t_str = new StringBuilder(Integer.toBinaryString(key.get(c) |  64 ));
          t_str = t_str.reverse();
    	    translated_s = translated_s.concat(t_str.substring(0, 6));
    	}

    	return translated_s;
    }
    public static void main(String[] args){
      System.out.println("doing stuff");
      System.out.println(Solution.solution(args[0]));
    }
}
