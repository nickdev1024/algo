01 Selection Sort
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two sub arrays in a given array.

02 Bubble Sort
Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.

03 Insertion Sort
Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands. The array is virtually split into a sorted and an unsorted part. Values from the unsorted part are picked and placed at the correct position in the sorted part.

04 Binary Search
Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
A simple approach is to do linear search.The time complexity of above algorithm is O(n). Another approach to perform the same task is using Binary Search.

Binary Search: Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.

05 Closest greater or same value on left side for every element in array
Given an array of integers, find the closest (not considering distance, but value) greater or same value on left of every element. If an element has no greater or same value on the left side, print -1.

06 Closest less or equal value on right side for every element in array

07 Find a local minima in an array
Given an array arr[0 .. n-1] of distinct integers, the task is to find a local minima in it. We say that an element arr[x] is a local minimum if it is less than or equal to both its neighbors.

For corner elements, we need to consider only one neighbor for comparison.
There can be more than one local minima in an array, we need to find any one of them.

08 Find the Number Occurring Odd Number of Times
Given an array of positive integers. All numbers occur even number of times except one number which occurs odd number of times. Find the number in O(n) time & constant space.

09 Position of rightmost set bit
Write a one line function to return position of first 1 from right to left, in binary representation of an Integer.

10 Find the two numbers with odd occurrences in an unsorted array
Given an unsorted array that contains even number of occurrences for all numbers except two numbers. Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.

11 First element occurring k times in an array
Given an array of n integers. The task is to find the first element that occurs k number of times. If no element occurs k times the print -1. The distribution of integer elements could be in any range.

12 Reverse a linked list

13 Reverse a Doubly Linked List

14 Delete a node in a Linked List

15 Delete a node in a Doubly Linked List

16 Stack using Doubly Linked List && Queue using Doubly Linked List

17 Stack using array && Queue using array

18 Use array to implement fix-sized stack and queue

19 Design a stack that supports getMin() in O(1) time and O(1) extra space
Question: Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.

20 Implement Stack using Queues

21 Implement Queue using Stacks

22 Recursive Programs to find Minimum and Maximum elements of array
Given an array of integers arr, the task is to find the minimum and maximum element of that array using recursion.

23 Merge Sort
Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves. The merge() function is used for merging two halves. The merge(arr, l, m, r) is a key process that assumes that arr[l..m] and arr[m+1..r] are sorted and merges the two sorted sub-arrays into one. See the following C implementation for details.

24 Count smaller elements on right side or left side
Write a function to count number of smaller elements on right of each element in an array. Given an unsorted array arr[] of distinct integers, construct another array countSmaller[] such that countSmaller[i] contains count of smaller elements on right side of each element arr[i] in array.

25 Count pairs in array such that left element is greater than right

26 Given an array of integers, for any number, find out the total number on its right side when (number > 2 * right-element), calculate total for all numbers.

27 count of range sum question

28 Quick Sort version 1.0 2.0 3.0
Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. There are many different versions of quickSort that pick pivot in different ways.

Always pick first element as pivot.
Always pick last element as pivot (implemented below)
Pick a random element as pivot.
Pick median as pivot.
The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements (greater than x) after x. All this should be done in linear time.

28 Quick Sort un-recursive

29 Heap structure - heap sort: generic type

30 Sort a nearly sorted (or K sorted) array
Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

31 In a given 2-D array, find all the lines with intersection

32 Trie tree - Trie | (Insert and Search, Delete and Starts with) : https://www.geeksforgeeks.org/trie-insert-and-search/

33 Bucket Sort
Bucket sort is mainly useful when input is uniformly distributed over a range. For example, consider the following problem.
Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed across the range. How do we sort the numbers efficiently?
A simple way is to apply a comparison based sorting algorithm. The lower bound for Comparison based sorting algorithm (Merge Sort, Heap Sort, Quick-Sort .. etc) is Ω(n Log n), i.e., they cannot do better than n * Log n.
Can we sort the array in linear time? Counting sort can not be applied here as we use keys as index in counting sort. Here keys are floating point numbers.
The idea is to use bucket sort. Following is bucket algorithm.

bucketSort(arr[], n)
1) Create n empty buckets (Or lists).
2) Do following for every array element arr[i].
.......a) Insert arr[i] into bucket[n*array[i]]
3) Sort individual buckets using insertion sort.
4) Concatenate all sorted buckets.

Count Sort and Radix Sort

34 Linked List interview questions
fast and slow pointers, return left mid | mid | mid right node. is linked list palindrome, partition linked list into less, equal and greater area remain linked. Special linked list with rand pointer.

35 Linked List tough questions
return the 1st intersected node of 2 linked list, multiple scenarios need to be considered.

36 Binary Tree
Pre-order, Mid-order, Post-order use recursion. Nearest ancestor node, Intersection Union.

37 Un-recursive traverse binary tree in pre-order, mid-order and post-order.

38 Traverse binary tree using breadth first search. binary tree question really hard

39

40









