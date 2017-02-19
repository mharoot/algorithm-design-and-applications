<div class="show-content user_content clearfix enhanced">
    <h1 class="page-title">Fast Sorting and Selection Chapter 9</h1>

<!-- chapter 9.2.0 -->
    <h2>Selection Chapter 9.2.0</h2>
    <h3>What?</h3>
    <pre>
        There are a number of applications in which we are interested in identifying a single
        element in terms of its rank relative to an ordering of the entire set.
    </pre>
    Examples include indentifying the:
    <ul>
        <li>minimum and maximum elements</li>
        <li><strong>median</strong> element, that is, the element such that half
        of the other elements are smaller and the remaining half are larger.
        </li>
    </ul>
    <pre>
        <h4>The Selection Problem</h4>
        Terms to know:
        <strong>Order Statistics: </strong>queries that ask for an element with a given rank.
    </pre>
    The general order-statistic problem of selecting the kth smallest element from an unsorted collection of n comparable elements.
    <pre>
        Why?
    </pre>
    We want to know whether we can achieve an O(n) running time for all values of k, including the interesting case of finding the median, where k = n/2.
    <h3>Selection Solution in O(n) time for any value of k</h3>
    <pre><strong>Prune-and-Search:</strong>
        In applying this technique, we solve a given problem that is defined on a
        collection of n objects by pruning away a fraction of the n objects and recursively
        solving the smaller problem. When we have finally reduced the problem to one
        defined on a constant-sized collection of objects, then we solve the problem using
        some brute-force method. Returning back from all the recursive calls completes
        the construction.
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
</div>
