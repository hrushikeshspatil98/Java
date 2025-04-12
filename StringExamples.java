package strings;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class StringExamples {
	
	static int resLen;
	static int resStart;
	
	public static void main(String[] args) {
		
		String str = "hrushikesh";
		System.out.println("Input String is: "+str.toLowerCase());
		System.out.println("*****************************");
		
		//Q. How to reverse a given String?
		reverseString(str);
		System.out.println("*****************************");
		
		//Q. How to find the maximum occurring character in a given String?
		HashMap<Character, Integer> map = new HashMap<>();
		char maxOccChar = 0;
		int maxCount= 0;
		for(int i=0; i<str.length(); i++)
		{
			if(map.keySet().contains(str.charAt(i)))
			{
				for(Map.Entry<Character, Integer> entry: map.entrySet())
				{
					if(entry.getKey().equals(str.charAt(i)))
						map.put(entry.getKey(), entry.getValue()+1);
					
					if(maxCount < entry.getValue())
					{
						maxCount = entry.getValue();
						maxOccChar = entry.getKey();
					}
				}
			}
			else
			{
				map.put(str.toLowerCase().charAt(i), 1);
			}
				
		}
		
		System.out.println("Maximum occurring character is: "+maxOccChar+" & count is: "+maxCount);
		System.out.println("*****************************");
		
		//Q. How to print the duplicate characters from the given String?
		//Q. How to remove all duplicates from a given string? 
		System.out.println("Duplicate Chars in String are: ");
		HashSet<Character> set = new HashSet<>();
		
		String opStr = "";
		for(int i=0; i<str.length(); i++)
		{
			if(!opStr.contains(""+str.toLowerCase().charAt(i)))
			{
				opStr += str.toLowerCase().charAt(i);
			}
			else
			{
				set.add(str.toLowerCase().charAt(i));
			}
		}
		
		System.out.println(set.toString());
		System.out.println("String without duplicate chars is: "+opStr);
		System.out.println("*****************************");
		
		//Q. How to remove characters from the first String which are present in the second String? 
		String inp1 = "welcome", inp2= "ce", remStr="";
		for(int i=0; i<inp1.length(); i++)
		{
			if(!inp2.contains(inp1.charAt(i)+""))
				remStr += inp1.charAt(i);
		}
		System.out.println("After removing characters from first string 'welcome' which are present in second 'ce', string is : \n"+remStr);
		System.out.println("*****************************");
		
		//Q. How to find the first non-repeating character in a given String?
		System.out.println("First non repeating char in string "+str+ " is: ");
		for(int i=0; i<str.length(); i++)
		{
			if(!str.substring(i+1, str.length()).contains(str.charAt(i)+""))
			{
				System.out.println(str.charAt(i));
				break;
			}
		}
		System.out.println("*****************************");
		
		//Q. How to reverse the words in a given String sentence?
		//Q. How do you count the number of words in String?
		System.out.println("Reverse words in string. Sample String 'Old Is Gold' ");
		String sent = "Old Is Gold", revSent="";
		String arr[] = sent.split(" ");
		for(String s: arr)
		{
			revSent = s + " " + revSent;
		}
		System.out.println("count the number of words in String: "+arr.length);
		System.out.println("Reverse str is: "+revSent);
		System.out.println("*****************************");
		
		//Q. How do you remove a given character from String?
		System.out.println("Remove a given character from String "+str+": & char is s");
		int i= str.indexOf('s');
		String remChar = str.substring(0, i);
		
		while(i<str.length())
		{
			if(! ( str.charAt(i) == 's') )
			{
				remChar += str.charAt(i);
			}
			i++;
		}
		
		System.out.println("After removing char string is: "+remChar);
		System.out.println("*****************************");
		
		//Q. How do you convert String to an integer?
		String numStr = "+123";
		System.out.println(numStr+ " <->" + Integer.parseInt(numStr)); //for signed integer
		numStr = "1234";
		System.out.println(numStr+ " <->" + Integer.parseUnsignedInt(numStr));	//for unsigned integer
		System.out.println("*****************************");
		
		//Q. How to check if two given String is the anagram of each other
		String s1 = "ABCD", s2 = "BACD";
		//way 1 - O(n logn)
		System.out.println("Is Anagram? : "+ isTwoStringsAnagram(s1.toCharArray(),s2.toCharArray()));
		//way 2 - O(n)
		if(s1.length() == s2.length())
		{
			boolean flag = true;
			for(int j=0; j< s2.length(); j++)
			{
				if(!s2.contains(s1.charAt(j)+"") || !s1.contains(s2.charAt(j)+""))
				{
					flag = false;
					break;
				}
					
			}
			
			if(flag == true)
				System.out.println(s1+ " & "+s2+ " are an anagram");
			else
				System.out.println(s1+ " & "+s2+ " are not an anagram");
		}
		else
		{
			System.out.println(s1+ " & "+s2+ " are not an anagram");
		}
		System.out.println("*****************************");
		
		//permutations of string
		String input = "geek";
		List<String> uniqueLst = new ArrayList<String>();
		permutations("", input, uniqueLst);
		System.out.println("Distinct permutations are : ");
		uniqueLst.stream().forEach(s -> System.out.println(s));
		System.out.println("*****************************");
		
		//Q. How do you check if a given string contains valid parentheses?
		//Stack<Character> parStack = new Stack<>();
		Deque<Character> parStack = new ArrayDeque<Character>(); //more faster than stack
		String parStr = "()[]{}{";
		
		boolean flag = true;
		char c = 0;
		for(int k=0; k<parStr.length(); k++)
		{
			if(parStr.charAt(k) == '(' || parStr.charAt(k) == '{' || parStr.charAt(k) == '[')
				parStack.push(parStr.charAt(k));
			else
			{
					if(!parStack.isEmpty()) {
						c = parStack.pop();
						if(!(c == '(' && parStr.charAt(k) == ')' || c == '{' && parStr.charAt(k) == '}' || c == '[' && parStr.charAt(k) == ']'))
						{
							flag = false;
							break;
						}
					}
					else
					{
						flag = false;
						break;
					}
			}
		}
		
		if(flag == true && parStack.isEmpty())
			System.out.println("string contains valid parentheses");
		else
			System.out.println("string does not contains valid parentheses");
		
		
		//Q. Find all substrings of string
		String subStr = "abc";
		findAllSubStrings(subStr);
		System.out.println("*****************************");
		
		//Q. How to find the smallest substring in a given string containing all characters of another string?
		String other = "tist";
		subStr = "this is a test string";
		findMinSubString(subStr,other);
		System.out.println("*****************************");
		
		//Q. How do you convert a Roman numeral String to Integer in Java?
		String roman = "MMMDCCXXIV";
		romanToInt(roman);
		System.out.println("*****************************");
		
		//Q. How do you convert Integer to Roman numeral String in Java?
		int value = 3999;  //max roman value we can write is 3999, remaining we need to multiple by 1000 and more
		intToRoman(value);
		System.out.println("*****************************");
		
		//Q. How do you find the longest palindromic substring of a given substring
		System.out.println("longest palindromic substring: "+ longestPalindromeString("forjavajavafor"));
		System.out.println("*****************************");
		
		
		//Q. How to check if two strings are rotations of each other? 
		flag = stringRotations("XYZ", "YZX");
		if(flag == true)
			System.out.println("Two Strings are rotations to each other");
		else
			System.out.println("Two Strings are not rotations to each other");
		System.out.println("*****************************");
	}

	private static String longestPalindromeString(String str) {
		
		if(str.isEmpty() || str.length() < 2)
			return "";
		
		for(int i=0; i< str.length() -1; i++)
		{
			expandRange(str, i , i);
			expandRange(str, i , i+1);
		}
		
		return str.substring(resStart, resStart+resLen);
		
	}
	
	private static void expandRange(String str, int start, int end) {
		
		while(start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end))
		{
			start--;
			end++;
		}
		
		if(resLen < end - start - 1)
		{
			resStart = start + 1;
			resLen = end - start - 1;
		}
	}

	private static boolean stringRotations(String str1, String str2) {
		
		if(str1.concat(str1).indexOf(str2) > -1)
			return true;
		return false;
	}

	private static void intToRoman(int value) {
		
		String[] units = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String[] hundreds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String[] thousands = {"","M","MM","MMM"};		
		
		String romanStr = "";
		romanStr = thousands[value / 1000] + hundreds[(value % 1000)/100] + tens[(value % 100)/10] + units[value % 10];
		System.out.println(value + " <--> " + romanStr);
	}

	private static void findMinSubString(String first, String second) {
		
		if(first.isEmpty() || second.length() > first.length())
		{	System.out.println(""); return; }
			
		HashMap<Character, Integer> map1 = new HashMap<>();
		int count = 0, start = 0, minLen = Integer.MAX_VALUE, minLeft = 0;
		
		for(char c : second.toCharArray())
		{
			map1.put(c, map1.getOrDefault(c, 0)+1);
		}
		
		for(int i=0 ; i < first.length(); i++)
		{
			if(map1.containsKey(first.charAt(i)))
			{
				map1.put(first.charAt(i), map1.get(first.charAt(i))-1);
				if(map1.get(first.charAt(i)) >= 0)
					count++;
			}
			
			while(count == second.length())
			{
				if(minLen > i-start+1)
				{
					minLen = i - start + 1;
					minLeft = start;
				}
				
				if(map1.containsKey(first.charAt(start)))
				{
					map1.put(first.charAt(start), map1.get(first.charAt(start))+1);
					if(map1.get(first.charAt(start)) > 0)
						count--;
				}
				start++;
			}
			
		}
		
		System.out.println("Min Sub String is: "+first.substring(minLeft, minLeft+minLen));
		System.out.println("*****************************");
		
	}

	private static boolean isTwoStringsAnagram(char[] charArray, char[] charArray2) {
		
		if(charArray.length != charArray2.length)
			return false;
		else
		{
			Arrays.sort(charArray);
			Arrays.sort(charArray2);
			
			for(int i=0; i<charArray.length; i++)
			{
				if(charArray[i] != charArray2[i])
					return false;
			}
			return true;
		}
		
	}

	private static void findAllSubStrings(String subStr) {
		
		for(int i=0; i< subStr.length(); i++)
		{
			String str = "";
			for(int j=i; j< subStr.length(); j++)
			{
				str += subStr.charAt(j);
				System.out.println(str);
				//if(subStr.charAt(i))
			}
		}
	}

	private static void permutations(String perm, String input, List<String> uniqueLst) {
//		if(input.isEmpty())  //block for non distinct permutations
//			System.out.println(perm + input);
		if(input.isEmpty())	//block for distinct permutations
			{
				if(!uniqueLst.contains(perm+input))
					uniqueLst.add(perm + input);
			}
		else
		{
			for(int i=0; i<input.length();i++) {
			permutations(perm + input.charAt(i), input.substring(0, i)+input.substring(i+1, input.length()),uniqueLst);
			}
		}
		
	}

	private static void reverseString(String str) {
		String revStr = "";
		
		for(int i=0; i<str.length(); i++)
		{
			revStr = str.charAt(i) + revStr;
		}
		System.out.println("Reverse String is: "+revStr);
		
		if(str.equals(revStr))
			System.out.println("String is palindrome");
		else
			System.out.println("String is not palindrome");
		
//		Another method to perform reverse string : Inbuilt method present in StringBuilder or StringBuffer
//		StringBuffer s = new StringBuffer();
//		StringBuilder s= new StringBuilder();
//		s.append(str);
//		System.out.println(s.reverse());
		
	}
	
	private static void romanToInt(String roman) {
		final Map<Character, Integer> map2 = new HashMap<Character, Integer>(){
			{
				put('I', 1);
				put('V', 5);
				put('X', 10);
				put('L', 50);
				put('C', 100);
				put('D', 500);
				put('M', 1000);
			}
		};
		
		int num = 0;
		for(int d=0; d< roman.length(); d++)
		{
			if(d != roman.length()-1 && map2.get(roman.charAt(d)) < map2.get(roman.charAt(d+1)))
			{
				num += map2.get(roman.charAt(d+1)) - map2.get(roman.charAt(d));
				d++;
			
			}
			else
				num += map2.get(roman.charAt(d));
			
		}
		
		System.out.println(roman + " <--> "+ num);
	}

}


