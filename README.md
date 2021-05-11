# DataStructures-and-Java

### 1. Insertion Sort:
    - The idea is to use the same logic as Sorting playing cards. 
    - Move an element as left as possible until, no other element is less than that element.  
    - The solution uses 2 loops, which increases the computation time. Insertion sort is an inplace algorithm, i.e Swapping occurs with no external memory usage.
  
### 2. Hashset:
    An Attempt at building a HashSet Data structure using arrays.

### 3. InvertTree:
    To Invert a Binary Tree using recursion.  
  
 ### 4. SearchBST:
    Search a Binary Tree for a node of a value and return the subtree of the node.

### 5. Trie:
    - Trie is a DataStructure used for word completion and pattern recognition. 
    - It is constructed using Arrays and References. Though the memory space utilized is huge[O(number of nodes x number of references)], it is compensated by the low Time complexity 
    - [Insert: O(length of longest word x number of words) Search: O(length of the word x number of words)].

### 6. Level Order BST:
    Level Order BST is Essentially a traversal method of bst that follows 
  
 ### 7. ZigZag BST:
    ZigZag BST is Essentially a traversal method of bst that follows
 
 ### 8. Rotate Image:
 
 ### 9. Build BST with inorder and postorder traversal:

### 10. Design of Browser History:

### 11. Regex Matching: Recursion

### 12. Tower Of Hanoi: 

### 13. Graph:
    Constructed a graph using adjacency list and traversed it using dfs. (TO DO: TRAVERSE IN BFS)
    
### 14. Min Stack:
    Built a minStack DataStructure that returns least value of the stack in minimum time (HOW? Using another stack that stores only the least values in it)
    
### 15. K Center Problem:
    - This is DP based approximation Problem wherein the output returned is not an optimum solution but is close to it. 
    - This is done to reduce computation time by settling to a good enough solution instead of the best

### 16. AutoComplete System:
    Based off trie DataStructure

### 17. Integer to English:
    - Push the number into a stack (Timecomplexity: O(n)). 
    - If batch is One, do not add the batchName at the end. 
    - If place is Ten convert n into a double digit number and find the corresponding String. 
    - If place is Ten and n is 1, pop the top and do n*=10+top and find the corresponding String. 
    - If place is Hundred find string corresponding to n and add place String next to it. 
    - Continue till stack is popped completely. (TimeComplexity: O(n)). Ergo Overall Timecomplexity is O(n)
    
### 18. NQueens
    Problem: Place n queens in a nxn board such that no 2 queens are attacking
    Backtracking solution: Add column to a column list. If it fits, go to the next row. Else remove the last added item from the list and check the validity of the next column. 
        If list size is n, then fill in corresponding queens ans spaces. Else, end the recursion

### 19. TotalQueens:
    Find all possibilities of NQueens.
    Backtracking solution: Same as NQueens, except, simply count all if row is n and col.size() is n, increment count

### 20. WildcardMatching DP
    TimeComplexity: O(sp)
    Algorithm: 
    - create a 2d array of size: p.length()+1 and s.length()+1. 
    - Fill cell of the first row and column to be true and the rest of the first row as false. 
    - As long as no character is '*', fill the first column as false as well. 
    - If character at p is '*', then, set the cell with the contents of the cell directly above it [i-1][0]
    - For every other cell
        -> if characters of p and s match, or if character of p is '?', then fill the cell with contents of the cell diagonally above it [i-1][j-1]
        -> if character of p is '*', then fill the contents of the cell with either the conents of the cell directly to the lft or directly above it. [i-1][j]||[i][j-1]
        -> else fill cell with false
        
### 21. BalancedSplitString
    Problem: Balanced strings are those that have an equal quantity of 'L' and 'R' characters.
             Given a balanced string s, split it in the maximum amount of balanced strings.
             Return the maximum amount of split balanced strings.
    TimeComplexity: O(n), where n =  string length

### 22. LexicographicalKthHappyString
    Problem: 
        - Happy Strings: Strings that contain only a|b|c and s[i]!=s[i+1], where i = 0 to s.length-1
        - Given a Stringlength n and an index k, find the kth happy string from a lexicographically arranged happy string list

### 23. MergeSort
    Algorithm: Splits the array into sub arrays and compares the elements if the subarray
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
