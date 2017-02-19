<div class="show-content user_content clearfix enhanced">
    <h1 class="page-title">Fast Sorting and Selection Chapter 9</h1>

<!-- chapter 9.2.0 -->
    <h2>Selection Chapter 9.2.0</h2>
    <h3>What?</h3>
    <pre>There are a number of applications in which we are interested in identifying a single element in terms of its rank relative to an ordering of the entire set.</pre>
    Examples include indentifying the:
    <ul>
        <li>minimum and maximum elements</li>
        <li><strong>median</strong> element, that is, the element such that half
        of the other elements are smaller and the remaining half are larger.
        </li>
    </ul>
    <pre><h4>The Selection Problem</h4><br>Terms to know:<br><strong>Order Statistics: </strong>queries that ask for an element with a given rank.</pre>
    The general order-statistic problem of selecting the kth smallest element from an unsorted collection of n comparable elements.
    <pre><h4>Why?</h4></pre>
    We want to know whether we can achieve an O(n) running time for all values of k, including the interesting case of finding the median, where k = n/2.
    <h3>Selection Solution in O(n) time for any value of k</h3>
    <pre><strong>Prune-and-Search:</strong><br>In applying this technique, we solve a given problem that is defined on a collection of n objects by pruning away a fraction of the n objects and recursively solving the smaller problem. When we have finally reduced the problem to one defined on a constant-sized collection of objects, then we solve the problem using some brute-force method. Returning back from all the recursive calls completes the construction.
    </pre>

<!-- chapter 9.2.1 -->
    <h2>9.2.1 Randomized Quick-Select</h2>
    <h3>What?</h3>
    <ul>
        <li>Uses the <strong>Prune-and-Search</strong> technique</li>
        <li>Finds the kth smallest element in an unordered sequence of n elements on which a total order relation is defined</li>
        <li>Runs in O(n) <strong>expected</strong> time</li>
        <li>Runs in O(n²) in the <strong>worst case</strong> time</li>
    </ul>
<pre>Algoirthm RandomizedQuickSelect(S, k)
<strong><em>Input:</em></strong> Sequence S of n comparable elements, and an integer k ∈ [1, n] 
<strong><em>Output:</em></strong> The kth smallest element of S

<strong>if</strong> n = 1 <strong>then</strong> 
<strong>    return</strong> the (first) element of S 

pick a random element x of S remove all the elements from S and put them into three sequences:
◙ L, storing the elements in S less than x 
◙ E, storing the elements in S equal to x 
◙ G, storing the elements in S greater than x 

<strong>if</strong> k ≤ |L| <strong>then</strong> 
&nbsp;   RandomizedQuickSelect(L, k) 
<strong>else if</strong> k ≤ |L| + |E| <strong>then
&nbsp;   </strong><strong>return</strong> x // each element in E is equal to x
<strong>else</strong> 
    RandomizedQuickSelect(G, k - |L| - |E|)

Example 1: Given set S = {4, 10, 8, 9, 7, 10, 11, 3, 6} and n = 9; find median k = n / 2 "ceiling" 

Lets trace whats going on using the Algoirthm above:

k = 5th smallest element

RandomizedQuickSelect(S, 5)
n != 1 continue...
pick a random element x of S; x = 7 (note: unrelated to k)
L = {4, 3, 6} &amp; |L| = 3
E = {7} &amp; |E| = 1
G = {10, 8, 9, 10, 11} &amp; |G| = 5
our k = 5, k is not less than or equal to 3
k is not less than or equal to 3 + 1
k is greater than 3 + 1 At this point L and E are <strong>pruned</strong> or "not dealing with"
RandomizedQuickSelect(G, k - |L| - |E|)
RandomizedQuickSelect(G, 5 - 3 - 1)
RandomizedQuickSelect(G, 1)
n != 1 continue...
pick a random element x of S = {10, 8, 9, 10, 11}; x = 8 (note: unrelated to k we could have picked 11 we still get 8 as the 5th smallest element..)
L = {} &amp; |L| = 0
E = {8} &amp; |E| = 1
G = {10, 9, 10, 11} &amp; |G| = 4
our k = 1, k is not less than or equal to 0
k is less than or equal to 0 + 1
return 8</pre>

</div>
