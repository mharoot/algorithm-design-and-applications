<div class="show-content user_content clearfix enhanced">
    <h1 class="page-title">Mergesort and Quicksort Chapter 8</h1>

<!-- chapter 8.1.0 -->
    <h2>Mergesort Chapter 8.1.0</h2>
    <h3>What?</h3>
    <pre>Mergesort is a divide and conquer algorithm</pre>

    <!-- chapter 8.1.1 -->
    <h2>Divide-and-Conquer Chapter 8.1.1</h2>
    <h3>What?</h3>
    <ol>
        <li>
        <p>Divide: If the input size is smaller than a certain threshold (say, 10 elements), solve the problem directly using a straightforward method and return the solution so obtained. Otherwise, divide the input data into two or more disjoint subsets.</p>
        </li>
        <li>
        <p>Recur: Recursively solve the subproblems associated with the subsets.</p>
        </li>
        <li>
        <p>Conquer: Take the solutions to the subproblems and “merge” them into a solution to the original problem.</p>
        </li>
    </ol>

    <div class="post-body">
    <p><strong>Let us consider the sorting problem to take a sequence, S, of objects as input, which could be represented with either a list or an array, and returns S in sorted order.&nbsp; For the problem of sorting a sequence S with n elements, the three divide-and-conquer steps are as follows:</strong></p>

    <p>1. <strong>Divide:</strong> If S has zero or one element, return S immediately; it is already sorted. Otherwise (S has at least two elements), put the elements of S into two sequences, S1 and S2, each containing about half of the elements of S; that is, S1 contains the first ( n/2 cieling ) elements of S, and S2 contains the remaining ( n/2 floor ) elements.</p>

    <p>2. <strong>Recur:</strong> Recursively sort the sequences S1 and S2.</p>

    <p>3. <strong>Conquer:</strong> Put back the elements into S by merging the sorted sequences S1 and S2 into a sorted sequence.</p>
    </div>

<div class="post-body">
	<h2>why mergesort is <strong>ϴ</strong>(n log n) ?</h2>

<pre><strong>Terms to Know:
Big-theta ϴ : </strong> merge sort worst case is both <code>O(n*log(n))</code> and <code>Omega(n*log(n))</code> - and thus is also <code>Ө(n*log(n)), </code>but it is also <code>O(n^2)</code>, since <code>n^2</code> is asymptotically "bigger" than it. However, it is <strong>not</strong> <code>Ө(n^2)</code>, Since the algorithm is not <code>Omega(n^2)</code>.
<strong>Big O:  </strong>is giving upper <a href="http://en.wikipedia.org/wiki/Asymptote">asymptotic bound
</a><strong>Big Omega Ω</strong><strong>:</strong> is giving a lower bound. Big Theta gives both.

<strong>In General:</strong>
Everything that is <code>Ө(f(n))</code> is also <code>O(f(n))</code>, but not the other way around. 
<code>T(n)</code> is said to be in <code>Ө(f(n))</code> if it is both in <code>O(f(n))</code> and in <code>Omega(f(n))</code>. 
In sets terminology, <strong><code>Ө(f(n))</code> is the <a href="http://en.wikipedia.org/wiki/Set_%28mathematics%29#Intersections">intersection</a> of <code>O(f(n))</code> and <code>Omega(f(n))</code></strong>
</pre>
</div>

<div class="post-body">
	<h2>Tracing Mergesort using a Binary Tree</h2>
<p>We can visualize an execution of the merge-sort algorithm using a binary tree T, called the merge-sort tree.</p>
<img src="https://github.com/mharoot/algorithm-design-and-applications/blob/master/week2/merge-sort-tree.JPG">
<p>This algorithm visualization in terms of the merge-sort tree helps us analyze the running
time of the merge-sort algorithm. In particular, since the size of the input sequence
roughly halves at each recursive call of merge-sort, the height of the merge-sort tree
is about log n (recall that the base of log is 2 if omitted).</p>
</div>

    <h2>Conquer</h2>
    <pre>The divide and recur steps of the merge-sort algorithm are simple; dividing a
sequence of size n involves separating it at the element with rank ( n/2 cieling), and the
recursive calls simply involve passing these smaller sequences as parameters. The
difficult step is the conquer step, which merges two sorted sequences into a single
sorted sequence.</pre>

<div class="post-body">
	<pre><strong>Algorithm merge</strong>(S1, S2, S):
<strong>Input:</strong> Two arrays, S1 and S2, of size n1 and n2, respectively, sorted in nondecreasing order, and an empty array, S, of size at least n1 + n2 
<strong>Output: </strong>S, containing the elements from S1 and S2 in sorted order 
i ← 1 
j ← 1 
<strong>while</strong> i ≤ n <strong>and </strong>j ≤ n <strong>do
&nbsp;   if</strong> S1[i] ≤ S2[j] <strong>then</strong> 
&nbsp;       S[i + j − 1] ← S1[i] i ← i + 1 
&nbsp;   <strong>else</strong> 
        S[i + j − 1] ← S2[j] j ← j + 1 
<strong>while </strong>i ≤ n <strong>do</strong> 
&nbsp;   S[i + j − 1] ← S1[i]
&nbsp;   i ← i + 1 
<strong>while</strong> j ≤ n <strong>do 
&nbsp;   </strong>S[i + j − 1] ← S2[j] 
&nbsp;   j ← j + 1

<strong>Merge Details: </strong>It merges two sorted arrays, S1 and S2, by iteratively removing a smallest element from one of these two and adding it to the end of an output array, S, until one of these two arrays is empty, at which point we copy the remainder of the other array to the output array
</pre>
</div>

</div>
