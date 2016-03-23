# LeetCode
Java implementation for LeetCode problems

#### 1.	Two Sum		(Easy)
Question:
>Given an array of integers, return indices of the two numbers such that they add up to a specific target.

>You may assume that each input would have exactly one solution.
 
Solution
> 1. Use HashMap to check if target-sum[i] exists in map.  **O(n)**

#### 2.	Add Two Numbers	 (Medium) 
Question:
> You are given two linked lists representing two non-negative numbers. 
> The digits are stored in reverse order and each of their nodes contain a single digit. 
> Add the two numbers and return it as a linked list.
  


Solution
> 1. Go through two lists and carry on digits if sum is larger than 10. At last add one more node if carry-on digit is not 0. 

#### 3.	Longest Substring Without Repeating Characters		(Medium)
Question:
> Given a string, find the length of the longest substring without repeating characters. 
> For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
> For "bbbbb" the longest substring is "b", with the length of 1.

Solution:
> 1. Sliding window. Move end index if no repeating characters, or move start to find next one.

#### 4.	Median of Two Sorted Arrays		(Hard)
Question:
> There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. 
> The overall run time complexity should be O(log (m+n)).

Solution:
> 1. Quick find kth element in two sorted array. Use one element to partition the numbers, and if count of smaller(x) are more than k,
>    continue to find kth in left; otherwise find (k-x) in right.  **O(m+n)**

#### 5.	Longest Palindromic Substring		(Medium)
Question:
> Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
> and there exists one unique longest palindromic substring

Solution:
> 1. Use DP to record if substring (i,j) is palindrome **O(n^2)**
> 2. Manacher algorithm: Use # to separate every characters, and find the max length for one position as below. [Reference:](http://www.felix021.com/blog/read.php?2040) **O(n)**
     p[i] = min(p[j], max - i),  j is mirror index of i for center id,  max is the farthest position from id.

#### 6.	ZigZag Conversion		(Easy)
Question:
>The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
> P   A   H   N
> A P L S I I G
> Y   I   R
> And then read line by line: "PAHNAPLSIIGYIR"
> Write the code that will take a string and make this conversion given a number of rows:
> string convert(string text, int nRows);
> convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

Solution:
> 1. Use List<List<String>> to record each line, and append characters into line according to its position. **O(n)**
> 2. Generate line by line directly by calculating the character position for (row, col):
     if col%2==0, pos = pos + 2*row; 
     otherwise pos = pos + 2*(nRows - row - 1)

#### 7.	Reverse Integer		(Easy)
Question:
> Reverse digits of an integer

Solution:
> Starts from right-side digits one by one. Be careful of negative numbers and integer overflow.

#### 8.	String to Integer (atoi)		(Easy)
Question:
> Implement atoi to convert a string to an integer. 
>  Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
> Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
  
Solution:
> Be careful of Integer overflow.

#### 9.	Palindrome Number		(Easy)
Question:
> Determine whether an integer is a palindrome. Do this without extra space.

Solution:
> Fetch left and right digit to compare. Be careful of negative number.

#### 10.	Regular Expression Matching		(Hard)
Question:
> Implement regular expression matching with support for '.' and '*'.
> '.' Matches any single character.
> '*' Matches zero or more of the preceding element.

Solution:
> Use DP to check if (i,j) matches.  O(m*n)
>                  | true               if i == 0, j == 0
>                  | false              else if j == 0
>       f(i, j) =  | p[j-1].isStar && f[i][j-1]      else if i == 0
>       i = 0 .. m | (isEqual(s[i-1], p[j-1]) && (f[i-1][j-1]) || (p[j-1].isStar && f[i-1][j])) || (p[j-1].isStar && f[i][j-1]))
>       j = 0 .. n |                    else

#### 11.	Container With Most Water		(Medium)
Question:
> Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
> Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Solution:
> Sliding window. Move left or right if it's smaller and calculate new size = (right-left) * min(h[left], h[right]).  **O(n)**

#### 12.	Integer to Roman		(Medium)
Question:
> Given an integer, convert it to a roman numeral.

Solution:
> Generate roman character one by one.

#### 13.	Roman to Integer		(Easy)
Question:
> Given a roman numeral, convert it to an integer

Solution:
> Convert from roman character to integer. If next character's value is less than current value, it need to use both of them (such as IV)

#### 14.	Longest Common Prefix		(Easy)
Question:
> Write a function to find the longest common prefix string amongst an array of strings.

Solution:
> Use a index to check if all strings have same character at this index (or exceeding length)

#### 15.	3Sum		(Medium)
Question:
> Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
> Note:
>  Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
>  The solution set must not contain duplicate triplets.

Solution:
> 1. Sort the array, and for any nums[i], find the combination of two sum (nums[j] + nums[k] = -nums[i]). Use set to avoid duplicated two sum combination. **O(n^2)**
  2. Or do not need to sort array. For two sum, use HashMap to record if (target-nums[j]) already exists.  **O(n^2)**   

#### 16.	3Sum Closest		(Medium)
Question:
> Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution

Solution:
> 1. Sort the array first. For any nums[i], reduce it to twoSumCloset(t-nums[i]). 
     twoSumCloset can be found out by sliding window moving left and right. **O(n^2)**   

#### 17.	Letter Combinations of a Phone Number		(Medium)
Question:
> Given a digit string, return all possible letter combinations that the number could represent.
> A mapping of digit to letters (just like on the telephone buttons) is given below.
  
Solution:
> Backtrack.  **O(3^n), n is number length**

#### 18.	4Sum		(Medium)
Question:
> Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
>  Note:
>  Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
>  The solution set must not contain duplicate quadruplets.

Solution:
> For any nums[i] and nums[j], reduce to twoSum. Be carefule of the duplicated elements. **O(n^3)**

#### 19.	Remove Nth Node From End of List		(Easy)
Question:
> Given a linked list, remove the nth node from the end of list and return its head

Solution:
> 1. Use two pointer with n distance. When second pointer reaches the end, the first pointer is the node to delete.
> 2. Or get the length of list (m), and starts from begin again with (m-n) length. **O(n)**

#### 20.	Valid Parentheses		(Easy)
Question:
> Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
> The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
  
Solution:
> Use queue to save the left parentheses and remove them if right parentheses matches. **O(n)**

#### 21.	Merge Two Sorted Lists		(Easy)
Question:
> Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Solution:
> Similar with merge sort. **O(m+n)**

#### 22.	Generate Parentheses		(Medium)
Question:
> Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Solution:
> Iterate all combinations for 0<=i<n-1 (i is the total parentheses inside left (), while right is n-i-1). **O(2^n)**

#### 23.	Merge k Sorted Lists		(Hard)
Question:
> Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity

Solution:
> 1. Use PriorityQueue to get smallest value within k lists. When removing the smallest value, and next value from that list. **O(n*logk)**

#### 24.	Swap Nodes in Pairs		(Medium)
Question:
>Given a linked list, swap every two adjacent nodes and return its head.
>For example,
>Given 1->2->3->4, you should return the list as 2->1->4->3.
>Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

Solution:
> Modify links.

#### 25.	Reverse Nodes in k-Group		(Hard)
Question:
> Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
> If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
> You may not alter the values in the nodes, only nodes itself may be changed.
> Only constant memory is allowed.
 
Solution:
> Divide and conquer. 

#### 26.	Remove Duplicates from Sorted Array		(Easy)
Question:
> Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
> Do not allocate extra space for another array, you must do this in place with constant memory.

Solution:
> Use index to save last position

#### 27.	Remove Element		(Easy)
Question:
> Given an array and a value, remove all instances of that value in place and return the new length

Solution:
> Use index to save last position.

#### 28.	Implement strStr()		(Easy)
Question:
> Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Solution:
> 1. Brute force to find matched substring. **O(m*n)**
> 2. KMP to search matched substring.  **O(m+n)**

#### 29.	Divide Two Integers		(Medium)
Question:
> Divide two integers without using multiplication, division and mod operator.
> If it is overflow, return MAX_INT.

Solution:
> Double divisor everytime. **O(logn)**

#### 30.	Substring with Concatenation of All Words		(Hard)
Question:
> You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
>  
>  For example, given:
>  s: "barfoothefoobarman"
>  words: ["foo", "bar"]
>  
>  You should return the indices: [0,9].
>  (order does not matter). 

Solution:
> 1. For position i, check if all substring with length k are in the map, and contains all strings.  **O(n*m), n is string length, m is size of array**
> 2. For position from (0..k-1), moving end if we can add current string; or move start if no more string can be added.  **O(n)** 

#### 31.	Next Permutation		(Medium)
Question:
> Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
> If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
> The replacement must be in-place, do not allocate extra memory.
 
Solution:
> Starting from right, find the first position that nums[i]<nums[i+1], then search from right again to find first position that nums[j]>nums[i]. 
> At last swap nums[i] and nums[j] and sort nums(i+1, n-1).  **O(n)** 

#### 32.	Longest Valid Parentheses		(Hard)
Question:
> Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
> For "(()", the longest valid parentheses substring is "()", which has length = 2.
> Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

Solution:
> 1. Brute force to count number of left parentheses starting from every position. **O(n^2)**
> 2. Merge valid parentheses and find longest valid one.  **O(n)**

#### 33.	Search in Rotated Sorted Array		(Hard)
Question:
> Suppose a sorted array is rotated at some pivot unknown to you beforehand.
> (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
> You are given a target value to search. If found in the array return its index, otherwise return -1.
> You may assume no duplicate exists in the array.

Solution:
> Similar with binary search:  **O(logn)**
>   1. When t<a[m], search left if t>=a[start] or a[start]>a[m]; othersie search right;
>   2. When t>a[m], search right if t<=a[end] or a[m]>a[end]; otherwise search left;

#### 34.	Search for a Range		(Medium)
Question:
> Given a sorted array of integers, find the starting and ending position of a given target value.
> Your algorithm's runtime complexity must be in the order of O(log n).
> If the target is not found in the array, return [-1, -1].

Solution:
> Binary search for target and find left and right position  **O(logn)**

#### 35.	Search Insert Position		(Medium)
Question:
> Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
> You may assume no duplicates in the array

Solution:
> Find first larger element with binary search  **O(logn)**

#### 36.	Valid Sudoku		(Easy)
Question:
> Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
> The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Solution:
> Check for every row, col and blocks if any duplicated numbers.

#### 37.	Sudoku Solver		(Hard)
Question:
> Write a program to solve a Sudoku puzzle by filling the empty cells.
> Empty cells are indicated by the character '.'.
> You may assume that there will be only one unique solution.

Solution:
> Backtrack to fill possible numbers and validate if it's ok in row, col and block.

#### 38..	Count and Say		(Easy)
Question:
> The count-and-say sequence is the sequence of integers beginning as follows:
>  1, 11, 21, 1211, 111221, ...

Solution:
> Generate numbers one by one.

#### 39..	Combination Sum		(Medium)
Question:
> Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
> The same repeated number may be chosen from C unlimited number of times.
> Note:
> All numbers (including target) will be positive integers.
> Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
> The solution set must not contain duplicate combinations.

Solution:
> Backtrack

#### 40..	Combination Sum II		(Medium)
Question:
> Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
> Each number in C may only be used once in the combination.
> Note:
>  All numbers (including target) will be positive integers.
>  Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
>  The solution set must not contain duplicate combinations.

Solution:
> 1. Count duplicated numbers in C, and sort the unique numbers in C and backtrack to seletec one by one if count > 0.
> 2. Sort C, and skip duplicated numbers in backtrack.

#### 41..	First Missing Positive		(Hard)
Question:
> Given an unsorted integer array, find the first missing positive integer.
> For example,
> Given [1,2,0] return 3,
> and [3,4,-1,1] return 2.
> 
> Your algorithm should run in O(n) time and uses constant space.

Solution:
> Update numbers to N if <=0. Then for each position i, update nums[a[i]-1] to negative if a[i]<=N.  **O(n)**

#### 42..	Trapping Rain Water		(Hard)
Question:
> Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.     
> 
> For example, 
> Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

Solution:
> Use DP to find largest number on the left and right for position i, and add that trapped water by max(0, a[i]-min(left,right)). **O(n)**

#### 43..	Multiply Strings		(Medium)
Question:
> Given two numbers represented as strings, return multiplication of the numbers as a string.
> Note: The numbers can be arbitrarily large and are non-negative.
  
Solution:
> Multiple string with digit one by one and add them up. Be careful to trim left zeros or append zero if it's empty.

#### 44..	Wildcard Matching		(Hard)
Question:
> Implement wildcard pattern matching with support for '?' and '*'.
>  '?' Matches any single character.
>  '*' Matches any sequence of characters (including the empty sequence). 
>  The matching should cover the entire input string (not partial).

Solution:
> dp(i,j) = | dp(i-1,j-1) if s[i]==p[j] or p[j]= .
>           | dp(i-1, j) || dp(i, j-1) if p[j] = *
> **O(m*n)**

#### 45..	Jump Game II		(Hard)
Question:
> Given an array of non-negative integers, you are initially positioned at the first index of the array.
> 
> Each element in the array represents your maximum jump length at that position.
> 
> Your goal is to reach the last index in the minimum number of jumps.
> 
> For example:
> Given array A = [2,3,1,1,4]
> 
> The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Solution:
> Starting from position i, record the max distance that can jump; then loop through (i+1, max) to update max again. 

#### 46..	Permutations		(Medium)
Question:
> Given a collection of distinct numbers, return all possible permutations.

Solution:
> Backtrack. **O(n!)**

#### 47..	Permutations II		(Medium)
Question:
> Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Solution:
> Count duplicated elements, and backtrack.  **O(n!)**

#### 48..	Rotate Image		(Medium)
Question:
> You are given an n x n 2D matrix representing an image.
> Rotate the image by 90 degrees (clockwise).
> Follow up:
> Could you do this in-place?
 
Solution:
> Rotate one element in place from top -> right -> bottom -> left

#### 49..	Group Anagrams		(Medium)
Question:
> Given an array of strings, group anagrams together.
> Note:
> For the return value, each inner list's elements must follow the lexicographic order.
> All inputs will be in lower-case.
  
Solution:
> Sort arrays first, and group strings by their sorted characters (using map) **O(nlogn + n*m*logm), n is string numbers, m is average length of all strings**

#### 50..	Pow(x, n)		(Medium)
Question:
> Implement pow(x, n).

Solution:
> Double count every time until count is larger than n. **O(logn)**
> Be careful of negative n and integer overflow.

#### 51..	N-Queens		(Hard)
Question:
> The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other
> Given an integer n, return all distinct solutions to the n-queens puzzle.
> Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Solution:
> Backtrack to try possible positions to put Queen for every row that no conflict in same column and cross-line. **O(n!)**

#### 52..	N-Queens II		(Hard)
Question:
> Follow up for N-Queens problem.
> Now, instead outputting board configurations, return the total number of distinct solutions.

Solution:
> Similar.

#### 53..	Maximum Subarray		(Medium)
Question:
> Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
> For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
> the contiguous subarray [4,−1,2,1] has the largest sum = 6.
  
Solution:
> dp[i] = max(nums[i], dp[i-1] + nums[i])  **O(n)**

#### 54..	Spiral Matrix		(Medium)
Question:
>

Solution:
>

#### 55..	Jump Game		(Medium)
Question:
>

Solution:
>

#### 56..	Merge Intervals		(Hard)
Question:
>

Solution:
>

#### 57..	Insert Interval		(Hard)
Question:
>

Solution:
>

#### 58..	Length of Last Word		(Easy)
Question:
>

Solution:
>

#### 59..	Spiral Matrix II		(Medium)
Question:
>

Solution:
>

#### 60..	Permutation Sequence		(Medium)
Question:
>

Solution:
>

#### 61..	Rotate List		(Medium)
Question:
>

Solution:
>

#### 62..	Unique Paths		(Medium)
Question:
>

Solution:
>

#### 63..	Unique Paths II		(Medium)
Question:
>

Solution:
>

#### 64..	Minimum Path Sum		(Medium)
Question:
>

Solution:
>

#### 65..	Valid Number		(Hard)
Question:
>

Solution:
>

#### 66..	Plus One		(Easy)
Question:
>

Solution:
>

#### 67..	Add Binary		(Easy)
Question:
>

Solution:
>

#### 68..	Text Justification		(Hard)
Question:
>

Solution:
>

#### 69..	Sqrt(x)		(Medium)
Question:
>

Solution:
>

#### 70..	Climbing Stairs		(Easy)
Question:
>

Solution:
>

#### 71..	Simplify Path		(Medium)
Question:
>

Solution:
>

#### 72..	Edit Distance		(Hard)
Question:
>

Solution:
>

#### 73..	Set Matrix Zeroes		(Medium)
Question:
>

Solution:
>

#### 74..	Search a 2D Matrix		(Medium)
Question:
>

Solution:
>

#### 75..	Sort Colors		(Medium)
Question:
>

Solution:
>

#### 76..	Minimum Window Substring		(Hard)
Question:
>

Solution:
>

#### 77..	Combinations		(Medium)
Question:
>

Solution:
>

#### 78..	Subsets		(Medium)
Question:
>

Solution:
>

#### 79..	Word Search		(Medium)
Question:
>

Solution:
>

#### 80..	Remove Duplicates from Sorted Array II		(Medium)
Question:
>

Solution:
>

#### 81..	Search in Rotated Sorted Array II		(Medium)
Question:
>

Solution:
>

#### 82..	Remove Duplicates from Sorted List II		(Medium)
Question:
>

Solution:
>

#### 83..	Remove Duplicates from Sorted List		(Easy)
Question:
>

Solution:
>

#### 84..	Largest Rectangle in Histogram		(Hard)
Question:
>

Solution:
>

#### 85..	Maximal Rectangle		(Hard)
Question:
>

Solution:
>

#### 86..	Partition List		(Medium)
Question:
>

Solution:
>

#### 87..	Scramble String		(Hard)
Question:
>

Solution:
>

#### 88..	Merge Sorted Array		(Easy)
Question:
>

Solution:
>

#### 89..	Gray Code		(Medium)
Question:
>

Solution:
>

#### 90..	Subsets II		(Medium)
Question:
>

Solution:
>

#### 91..	Decode Ways		(Medium)
Question:
>

Solution:
>

#### 92..	Reverse Linked List II		(Medium)
Question:
>

Solution:
>

#### 93..	Restore IP Addresses		(Medium)
Question:
>

Solution:
>

#### 94..	Binary Tree Inorder Traversal		(Medium)
Question:
>

Solution:
>

#### 95..	Unique Binary Search Trees II		(Medium)
Question:
>

Solution:
>

#### 96..	Unique Binary Search Trees		(Medium)
Question:
>

Solution:
>

#### 97..	Interleaving String		(Hard)
Question:
>

Solution:
>

#### 98..	Validate Binary Search Tree		(Medium)
Question:
>

Solution:
>

#### 99..	Recover Binary Search Tree		(Hard)
Question:
>

Solution:
>

#### 100.	Same Tree		(Easy)
Question:
>

Solution:
>

#### 101.	Symmetric Tree		(Easy)
Question:
>

Solution:
>

#### 102.	Binary Tree Level Order Traversal		(Easy)
Question:
>

Solution:
>

#### 103.	Binary Tree Zigzag Level Order Traversal		(Medium)
Question:
>

Solution:
>

#### 104.	Maximum Depth of Binary Tree		(Easy)
Question:
>

Solution:
>

#### 105.	Construct Binary Tree from Preorder and Inorder Traversal		(Medium)
Question:
>

Solution:
>

#### 106.	Construct Binary Tree from Inorder and Postorder Traversal		(Medium)
Question:
>

Solution:
>

#### 107.	Binary Tree Level Order Traversal II		(Easy)
Question:
>

Solution:
>

#### 108.	Convert Sorted Array to Binary Search Tree		(Medium)
Question:
>

Solution:
>

#### 109.	Convert Sorted List to Binary Search Tree		(Medium)
Question:
>

Solution:
>

#### 110.	Balanced Binary Tree		(Easy)
Question:
>

Solution:
>

#### 111.	Minimum Depth of Binary Tree		(Easy)
Question:
>

Solution:
>

#### 112.	Path Sum		(Easy)
Question:
>

Solution:
>

#### 113.	Path Sum II		(Medium)
Question:
>

Solution:
>

#### 114.	Flatten Binary Tree to Linked List		(Medium)
Question:
>

Solution:
>

#### 115.	Distinct Subsequences		(Hard)
Question:
>

Solution:
>

#### 116.	Populating Next Right Pointers in Each Node		(Medium)
Question:
>

Solution:
>

#### 117.	Populating Next Right Pointers in Each Node II		(Hard)
Question:
>

Solution:
>

#### 118.	Pascal's Triangle		(Easy)
Question:
>

Solution:
>

#### 119.	Pascal's Triangle II		(Easy)
Question:
>

Solution:
>

#### 120.	Triangle		(Medium)
Question:
>

Solution:
>

#### 121.	Best Time to Buy and Sell Stock		(Medium)
Question:
>

Solution:
>

#### 122.	Best Time to Buy and Sell Stock II		(Medium)
Question:
>

Solution:
>

#### 123.	Best Time to Buy and Sell Stock III		(Hard)
Question:
>

Solution:
>

#### 124.	Binary Tree Maximum Path Sum		(Hard)
Question:
>

Solution:
>

#### 125.	Valid Palindrome		(Easy)
Question:
>

Solution:
>

#### 126.	Word Ladder II		(Hard)
Question:
>

Solution:
>

#### 127.	Word Ladder		(Medium)
Question:
>

Solution:
>

#### 128.	Longest Consecutive Sequence		(Hard)
Question:
>

Solution:
>

#### 129.	Sum Root to Leaf Numbers		(Medium)
Question:
>

Solution:
>

#### 130.	Surrounded Regions		(Medium)
Question:
>

Solution:
>

#### 131.	Palindrome Partitioning		(Medium)
Question:
>

Solution:
>

#### 132.	Palindrome Partitioning II		(Hard)
Question:
>

Solution:
>

#### 133.	Clone Graph		(Medium)
Question:
>

Solution:
>

#### 134.	Gas Station		(Medium)
Question:
> There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
>  You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
>  Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 
Solution:
> 1. For every station, check if the remaining gas is always >=0.   **O(n^2)**
> 2. Calculate remains[i] based on remains[i], and reset starting pos if found remains[i-1] is negative.  **O(n)** 
>    It can use 2*n array to simply logic. 
>       remains[i], pos = | remains[i-1] + gas[i] - cost[i], pos   if remains[i-1]>=0
>                         | gas[i] - cost[i], i 

#### 135.	Candy		(Hard)
Question:
>

Solution:
>

#### 136.	Single Number		(Medium)
Question:
>

Solution:
>

#### 137.	Single Number II		(Medium)
Question:
>

Solution:
>

#### 138.	Copy List with Random Pointer		(Hard)
Question:
>

Solution:
>

#### 139.	Word Break		(Medium)
Question:
>

Solution:
>

#### 140.	Word Break II		(Hard)
Question:
>

Solution:
>

#### 141.	Linked List Cycle		(Medium)
Question:
>

Solution:
>

#### 142.	Linked List Cycle II		(Medium)
Question:
>

Solution:
>

#### 143.	Reorder List		(Medium)
Question:
>

Solution:
>

#### 144.	Binary Tree Preorder Traversal		(Medium)
Question:
>

Solution:
>

#### 145.	Binary Tree Postorder Traversal		(Hard)
Question:
>

Solution:
>

#### 146.	LRU Cache		(Hard)
Question:
>

Solution:
>

#### 147.	Insertion Sort List		(Medium)
Question:
>

Solution:
>

#### 148.	Sort List		(Medium)
Question:
>

Solution:
>

#### 149.	Max Points on a Line		(Hard)
Question:
>

Solution:
>

#### 150.	Evaluate Reverse Polish Notation		(Medium)
Question:
>

Solution:
>

#### 151.	Reverse Words in a String		(Medium)
Question:
>

Solution:
>

#### 152.	Maximum Product Subarray		(Medium)
Question:
> Find the contiguous subarray within an array (containing at least one number) which has the largest product.
> For example, given the array [2,3,-2,4],
> the contiguous subarray [2,3] has the largest product = 6.
  
Solution:
> DP way. max[i] is the max product ending at i; min[i] is the min product ending at i.    **O(n)**
>  If nums[i]>=0:  max[i] = max(nums[i], nums[i]*max[i-1]), min[i] = min(nums[i], nums[i]*min[i-1])
>  Else: max[i] = max(nums[i], nums[i]*min[i-1]), min[i] = min(nums[i], nums[i]*max[i-1])

#### 153.	Find Minimum in Rotated Sorted Array		(Medium)
Question:
>

Solution:
>

#### 154.	Find Minimum in Rotated Sorted Array II		(Hard)
Question:
>

Solution:
>

#### 155.	Min Stack		(Easy)
Question:
>

Solution:
>

#### 156.	Binary Tree Upside Down 		(Medium)
Question:
>

Solution:
>

#### 157.	Read N Characters Given Read4 		(Easy)
Question:
>

Solution:
>

#### 158.	Read N Characters Given Read4 II - Call multiple times 		(Hard)
Question:
>

Solution:
>

#### 159.	Longest Substring with At Most Two Distinct Characters 		(Hard)
Question:
>

Solution:
>

#### 160.	Intersection of Two Linked Lists		(Easy)
Question:
>

Solution:
>

#### 161.	One Edit Distance 		(Medium)
Question:
>

Solution:
>

#### 162.	Find Peak Element		(Medium)
Question:
>

Solution:
>

#### 163.	Missing Ranges 		(Medium)
Question:
>

Solution:
>

#### 164.	Maximum Gap		(Hard)
Question:
>

Solution:
>

#### 165.	Compare Version Numbers		(Easy)
Question:
>

Solution:
>

#### 166.	Fraction to Recurring Decimal		(Medium)
Question:
>

Solution:
>

#### 167.	Two Sum II - Input array is sorted 		(Medium)
Question:
>

Solution:
>

#### 168.	Excel Sheet Column Title		(Easy)
Question:
>

Solution:
>

#### 169.	Majority Element		(Easy)
Question:
>

Solution:
>

#### 170.	Two Sum III - Data structure design 		(Easy)
Question:
>

Solution:
>

#### 171.	Excel Sheet Column Number		(Easy)
Question:
>

Solution:
>

#### 172.	Factorial Trailing Zeroes		(Easy)
Question:
>

Solution:
>

#### 173.	Binary Search Tree Iterator		(Medium)
Question:
>

Solution:
>

#### 174.	Dungeon Game		(Hard)
Question:
>

Solution:
>

#### 179.	Largest Number		(Medium)
Question:
>

Solution:
>

#### 186.	Reverse Words in a String II 		(Medium)
Question:
>

Solution:
>

#### 187.	Repeated DNA Sequences		(Medium)
Question:
>

Solution:
>

#### 188.	Best Time to Buy and Sell Stock IV		(Hard)
Question:
>

Solution:
>

#### 189.	Rotate Array		(Easy)
Question:
>

Solution:
>

#### 190.	Reverse Bits		(Easy)
Question:
>

Solution:
>

#### 191.	Number of 1 Bits		(Easy)
Question:
>

Solution:
>

#### 198.	House Robber		(Easy)
Question:
>

Solution:
>

#### 199.	Binary Tree Right Side View		(Medium)
Question:
>

Solution:
>

#### 200.	Number of Islands		(Medium)
Question:
>

Solution:
>

#### 201.	Bitwise AND of Numbers Range		(Medium)
Question:
>

Solution:
>

#### 202.	Happy Number		(Easy)
Question:
>

Solution:
>

#### 203.	Remove Linked List Elements		(Easy)
Question:
>

Solution:
>

#### 204.	Count Primes		(Easy)
Question:
>

Solution:
>

#### 205.	Isomorphic Strings		(Easy)
Question:
>

Solution:
>

#### 206.	Reverse Linked List		(Easy)
Question:
>

Solution:
>

#### 207.	Course Schedule		(Medium)
Question:
>

Solution:
>

#### 208.	Implement Trie (Prefix Tree)		(Medium)
Question:
>

Solution:
>

#### 209.	Minimum Size Subarray Sum		(Medium)
Question:
>

Solution:
>

#### 210.	Course Schedule II		(Medium)
Question:
>

Solution:
>

#### 211.	Add and Search Word - Data structure design		(Medium)
Question:
>

Solution:
>

#### 212.	Word Search II		(Hard)
Question:
>

Solution:
>

#### 213.	House Robber II		(Medium)
Question:
>

Solution:
>

#### 214.	Shortest Palindrome		(Hard)
Question:
>

Solution:
>

#### 215.	Kth Largest Element in an Array		(Medium)
Question:
>

Solution:
>

#### 216.	Combination Sum III		(Medium)
Question:
>

Solution:
>

#### 217.	Contains Duplicate		(Easy)
Question:
>

Solution:
>

#### 218.	The Skyline Problem		(Hard)
Question:
>

Solution:
>

#### 219.	Contains Duplicate II		(Easy)
Question:
>

Solution:
>

#### 220.	Contains Duplicate III		(Medium)
Question:
>

Solution:
>

#### 221.	Maximal Square		(Medium)
Question:
>

Solution:
>

#### 222.	Count Complete Tree Nodes		(Medium)
Question:
>

Solution:
>

#### 223.	Rectangle Area		(Easy)
Question:
>

Solution:
>

#### 224.	Basic Calculator		(Medium)
Question:
>

Solution:
>

#### 225.	Implement Stack using Queues		(Easy)
Question:
>

Solution:
>

#### 226.	Invert Binary Tree		(Easy)
Question:
>

Solution:
>

#### 227.	Basic Calculator II		(Medium)
Question:
>

Solution:
>

#### 228.	Summary Ranges		(Easy)
Question:
>

Solution:
>

#### 229.	Majority Element II		(Medium)
Question:
>

Solution:
>

#### 230.	Kth Smallest Element in a BST		(Medium)
Question:
>

Solution:
>

#### 231.	Power of Two		(Easy)
Question:
>

Solution:
>

#### 232.	Implement Queue using Stacks		(Easy)
Question:
>

Solution:
>

#### 233.	Number of Digit One		(Hard)
Question:
>

Solution:
>

#### 234.	Palindrome Linked List		(Easy)
Question:
>

Solution:
>

#### 235.	Lowest Common Ancestor of a Binary Search Tree		(Easy)
Question:
>

Solution:
>

#### 236.	Lowest Common Ancestor of a Binary Tree		(Medium)
Question:
>

Solution:
>

#### 237.	Delete Node in a Linked List		(Easy)
Question:
>

Solution:
>

#### 238.	Product of Array Except Self		(Medium)
Question:
>

Solution:
>

#### 239.	Sliding Window Maximum		(Hard)
Question:
>

Solution:
>

#### 240.	Search a 2D Matrix II		(Medium)
Question:
>

Solution:
>

#### 241.	Different Ways to Add Parentheses		(Medium)
Question:
>

Solution:
>

#### 242.	Valid Anagram		(Easy)
Question:
>

Solution:
>

#### 243.	Shortest Word Distance 		(Easy)
Question:
>

Solution:
>

#### 244.	Shortest Word Distance II 		(Medium)
Question:
>

Solution:
>

#### 245.	Shortest Word Distance III 		(Medium)
Question:
>

Solution:
>

#### 246.	Strobogrammatic Number 		(Easy)
Question:
>

Solution:
>

#### 247.	Strobogrammatic Number II 		(Medium)
Question:
>

Solution:
>

#### 248.	Strobogrammatic Number III 		(Hard)
Question:
>

Solution:
>

#### 249.	Group Shifted Strings 		(Easy)
Question:
>

Solution:
>

#### 250.	Count Univalue Subtrees 		(Medium)
Question:
>

Solution:
>

#### 251.	Flatten 2D Vector 		(Medium)
Question:
>

Solution:
>

#### 252.	Meeting Rooms 		(Easy)
Question:
>

Solution:
>

#### 253.	Meeting Rooms II 		(Medium)
Question:
>

Solution:
>

#### 254.	Factor Combinations 		(Medium)
Question:
>

Solution:
>

#### 255.	Verify Preorder Sequence in Binary Search Tree 		(Medium)
Question:
>

Solution:
>

#### 256.	Paint House 		(Medium)
Question:
>

Solution:
>

#### 257.	Binary Tree Paths		(Easy)
Question:
>

Solution:
>

#### 258.	Add Digits		(Easy)
Question:
>

Solution:
>

#### 259.	3Sum Smaller 		(Medium)
Question:
>

Solution:
>

#### 260.	Single Number III		(Medium)
Question:
>

Solution:
>

#### 261.	Graph Valid Tree 		(Medium)
Question:
>

Solution:
>

#### 263.	Ugly Number		(Easy)
Question:
>

Solution:
>

#### 264.	Ugly Number II		(Medium)
Question:
>

Solution:
>

#### 265.	Paint House II 		(Hard)
Question:
>

Solution:
>

#### 266.	Palindrome Permutation 		(Easy)
Question:
>

Solution:
>

#### 267.	Palindrome Permutation II 		(Medium)
Question:
>

Solution:
>

#### 268.	Missing Number		(Medium)
Question:
>

Solution:
>

#### 269.	Alien Dictionary 		(Hard)
Question:
>

Solution:
>

#### 270.	Closest Binary Search Tree Value 		(Easy)
Question:
>

Solution:
>

#### 271.	Encode and Decode Strings 		(Medium)
Question:
>

Solution:
>

#### 272.	Closest Binary Search Tree Value II 		(Hard)
Question:
>

Solution:
>

#### 273.	Integer to English Words		(Hard)
Question:
>

Solution:
>

#### 274.	H-Index		(Medium)
Question:
>

Solution:
>

#### 275.	H-Index II		(Medium)
Question:
>

Solution:
>

#### 276.	Paint Fence 		(Easy)
Question:
>

Solution:
>

#### 277.	Find the Celebrity 		(Medium)
Question:
>

Solution:
>

#### 278.	First Bad Version		(Easy)
Question:
>

Solution:
>

#### 279.	Perfect Squares		(Medium)
Question:
>

Solution:
>

#### 280.	Wiggle Sort 		(Medium)
Question:
>

Solution:
>

#### 281.	Zigzag Iterator 		(Medium)
Question:
>

Solution:
>

#### 282.	Expression Add Operators		(Hard)
Question:
>

Solution:
>

#### 283.	Move Zeroes		(Easy)
Question:
>

Solution:
>

#### 284.	Peeking Iterator		(Medium)
Question:
>

Solution:
>

#### 285.	Inorder Successor in BST 		(Medium)
Question:
>

Solution:
>

#### 286.	Walls and Gates 		(Medium)
Question:
>

Solution:
>

#### 287.	Find the Duplicate Number		(Hard)
Question:
>

Solution:
>

#### 288.	Unique Word Abbreviation 		(Easy)
Question:
>

Solution:
>

#### 289.	Game of Life		(Medium)
Question:
>

Solution:
>

#### 290.	Word Pattern		(Easy)
Question:
>

Solution:
>

#### 291.	Word Pattern II 		(Hard)
Question:
>

Solution:
>

#### 292.	Nim Game		(Easy)
Question:
>

Solution:
>

#### 293.	Flip Game 		(Easy)
Question:
>

Solution:
>

#### 294.	Flip Game II 		(Medium)
Question:
>

Solution:
>

#### 295.	Find Median from Data Stream		(Hard)
Question:
>

Solution:
>

#### 296.	Best Meeting Point 		(Hard)
Question:
>

Solution:
>

#### 297.	Serialize and Deserialize Binary Tree		(Hard)
Question:
>

Solution:
>

#### 298.	Binary Tree Longest Consecutive Sequence 		(Medium)
Question:
>

Solution:
>

#### 299.	Bulls and Cows		(Easy)
Question:
>

Solution:
>

#### 300.	Longest Increasing Subsequence		(Medium)
Question:
>

Solution:
>

#### 301.	Remove Invalid Parentheses		(Hard)
Question:
>

Solution:
>

#### 302.	Smallest Rectangle Enclosing Black Pixels 		(Hard)
Question:
>

Solution:
>

#### 303.	Range Sum Query - Immutable		(Easy)
Question:
> Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Solution:
> Cache sum[i], and calculate rangeSum(i,j) = sum(j)-sum(i). Init Time: O(n), Query Time: O(1)

#### 304.	Range Sum Query 2D - Immutable		(Medium)
Question:
> Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Solution:
> 1. Cache sum[col] for every row; and go through (row1, row2) to get total sums in the rectangle. Init Time: O(m*n), Query Time: O(nRows)
> 2. Cache sum of rectangle (0,0) to (i,j). And calculate rectangle (x1,y1) to (x2,y2) = cache(x2,y2)-cache(x2,y1)-cache(x1,y2)+cache(x1,y1). Init Time: O(m*n), Query Time: O(1)

#### 305.	Number of Islands II 		(Hard)
Question:
>

Solution:
>

#### 306.	Additive Number		(Medium)
Question:
>

Solution:
>

#### 307.	Range Sum Query - Mutable		(Medium)
Question:
> Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
> The update(i, val) function modifies nums by updating the element at index i to val.

Solution:
> 1. Cache sum(i) but need to update all cached sum after updating one element.  Update Time: O(n),  Query Time: O(1)
> 2. Use Segment Tree to save range sum (i, j).  Update Time: O(logn),  Query Time: O(logn)
> 3. Use Binary Index Tree t osave range sum [Reference](https://www.hrwhisper.me/binary-indexed-tree-fenwick-tree/).  Update Time: O(logn),  Query Time: O(logn)

#### 308.	Range Sum Query 2D - Mutable 		(Hard)
Question:
> Given a mutable 2D matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
> Node:
> The matrix is only modifiable by the update function.
> You may assume the number of calls to update and sumRegion function is distributed evenly.

Solution:
> 1. Cache Sum[col] for every row, but modify needs to update all cached sum after position. Init Time: O(m*n), Query Time: O(row), Update Time: O(n) 
> 2. Use Segment Tree to cache for every row. Init Time: O(m*n*logn), Query Time: O(row*logn), Update Time: O(logn)

#### 309.	Best Time to Buy and Sell Stock with Cooldown		(Medium)
Question:
>

Solution:
>

#### 310.	Minimum Height Trees		(Medium)
Question:
>

Solution:
>

#### 311.	Sparse Matrix Multiplication 		(Medium)
Question:
>

Solution:
>

#### 312.	Burst Balloons		(Hard)
Question:
>

Solution:
>

#### 313.	Super Ugly Number		(Medium)
Question:
>

Solution:
>

#### 314.	Binary Tree Vertical Order Traversal 		(Medium)
Question:
>

Solution:
>

#### 315.	Count of Smaller Numbers After Self		(Hard)
Question:
>

Solution:
>

#### 316.	Remove Duplicate Letters		(Medium)
Question:
>

Solution:
>

#### 317.	Shortest Distance from All Buildings 		(Hard)
Question:
>

Solution:
>

#### 318.	Maximum Product of Word Lengths		(Medium)
Question:
>

Solution:
>

#### 319.	Bulb Switcher		(Medium)
Question:
>

Solution:
>

#### 320.	Generalized Abbreviation 		(Medium)
Question:
>

Solution:
>

#### 321.	Create Maximum Number		(Hard)
Question:
>

Solution:
>

#### 322.	Coin Change		(Medium)
Question:
>

Solution:
>

#### 323.	Number of Connected Components in an Undirected Graph 		(Medium)
Question:
>

Solution:
>

#### 324.	Wiggle Sort II		(Medium)
Question:
>

Solution:
>

#### 325.	Maximum Size Subarray Sum Equals k 		(Easy)
Question:
>

Solution:
>

#### 326.	Power of Three		(Easy)
Question:
>

Solution:
>

#### 327.	Count of Range Sum		(Hard)
Question:
>

Solution:
>

#### 328.	Odd Even Linked List		(Easy)
Question:
>

Solution:
>

#### 329.	Longest Increasing Path in a Matrix		(Hard)
Question:
>

Solution:
>

#### 330.	Patching Array		(Medium)
Question:
>

Solution:
>

#### 331.	Verify Preorder Serialization of a Binary Tree		(Medium)
Question:
>

Solution:
>

#### 332.	Reconstruct Itinerary		(Medium)
Question:
>

Solution:
>

#### 333.	Largest BST Subtree 		(Medium)
Question:
>

Solution:
>

#### 334.	Increasing Triplet Subsequence		(Medium)
Question:
>

Solution:
>

#### 335.	Self Crossing		(Medium)
Question:
>

Solution:
>

#### 336.	Palindrome Pairs		(Hard)
Question:
>

Solution:
>

#### 337.	House Robber III		(Medium)
Question:
>

Solution:
>

#### 338.	Counting Bits		(Medium)
