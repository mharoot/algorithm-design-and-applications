<div class="show-content user_content clearfix enhanced">
    <h1 class="page-title">Fast Sorting and Selection</h1>
    <h2>Selection</h2>
    <h3>What?</h3>
    <pre>
        There are a number of applications in which we are interested in identifying a single
        element in terms of its rank relative to an ordering of the entire set. Examples
        include identifying the minimum and maximum elements, but we may also be interested
        in, say, identifying the median element, that is, the element such that half
        of the other elements are smaller and the remaining half are larger. In general,
        queries that ask for an element with a given rank are called order statistics.
        In this section, we discuss the general order-statistic problem of selecting the
        kth smallest element from an unsorted collection of n comparable elements. This
        is known as the selection problem. Of course, we can solve this problem by sorting
        the collection and then indexing into the sorted sequence at rank index k−1. Using
        the best comparison-based sorting algorithms, this approach would take O(n log n)
        time. Thus, a natural question to ask is whether we can achieve an O(n) running
        time for all values of k, including the interesting case of finding the median, where
        k = n/2.
    </pre>
</div>
