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

    <p>1. <strong>Divide:</strong> If S has zero or one element, return S immediately; it is already sorted. Otherwise (S has at leasttwo elements), put the elements of S into two sequences, S1 and S2, each containing about half of the elements of S; that is, S1 contains the first ( n/2 cieling ) elements of S, and S2 contains the remaining ( n/2 floor ) elements.</p>

    <p>2. <strong>Recur:</strong> Recursively sort the sequences S1 and S2.</p>

    <p>3. <strong>Conquer:</strong> Put back the elements into S by merging the sorted sequences S1 and S2 into a sorted sequence.</p>
    </div>
</div>
