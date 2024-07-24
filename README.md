# Puzzles-GenerateParentheses

Write a function to generate all combinations of well-formed parentheses.

## Lesson Task Description

This a classic Intel coding interview question.

We are given an integer N.

The expectation is that there will be N pairs of round parentheses.

Our function must generate all combinations of well-formed parentheses.

The algorithm to use is recursive backtracking.

The solution starts empty.

From the "" solution, now an open bracket can be used; open brackets == 0, closed brackets == 0.

From the "" solution, now a closed bracket cannot be used; open brackets < closed brackets not allowed.

From the "(" solution, now an open brackt can be used; open brackets == 1, closed brackets == 0.

From the "((" solution, now a closed bracket can be used; open brackets == 2, closed brackets == 0.

From the "(()" solution, now a closed bracket can be used; open brackets == 2, closed brackets == 1.

From the "(())" solution, now store answer; open brackets == 2, closed brackets == 2.

Pop recursion to "(()".

Pop recursion to "((".

Pop recursion to "(".

From the "(" solution, now a closed bracket can be used; open brackets == 1, closed brackets == 0.

From the "()" solution, now an open bracket can be used; open brackets == 1, closed brackets == 1.

From the "()" solution, now a closed bracket cannot be used; open brackets < closed brackets not allowed.

From the "()(" solution, now an open bracket cannot be used; open brackets == N.

From the "()(" solution, now a closed bracket can be used; open brackets == 2, closed brackets == 1.

From the "()()" solution, now store answer; open brackets == 2, closed brackets == 2.

Pop recursion to "()(".

Pop recursion to "()".

Pop recursion to "(".

Pop recursion to "".

Stop.

### Leetcode Solution Tip

We can use an open bracket if number of open brackets is less than N.

We can use a closed bracket if number of closed brackets is less than number of open brackets.

The base case (stop condition) number of open brackets == number of closed brackets == N.

## Interviewing.io

### Recursive Backtracking Solution

This one counts down from N.

It tracks how many forward parentheses are needed, and how many backward parenthese are needed.

See this [article](https://interviewing.io/questions/generate-parentheses).

### Dynamic Programming Solution

Turns out, with some mental gymnastics, that dynamic programming technique can be used as well.

In general, solutions dp(1), dp(2), ..., dp(x - 1) are used to generate dp(x).

In detail, the solution I read in the Interviewing.io article is anything but easy to follow.
Dynamic programming and the generation of parentheses combinations.

I will try to distill down the algorithm the author invented.

Dynamic programming is a tool that will improve the time complexity of a solution.

However, spotting the dynamic programming pattern in a problem,
and implementinging code can be tricky.

Key to note, dynamic programming needs to solve sub-problems to solve the main problem.

The goal is to track sub-problems results in a list of list of string.

Expect the nth element of this list to contain the result.

For any given ith element, add parentheses around all previous solutions,
and append the previous solution.

The stop condition is when the nth case is complete.

The identity case when dp(0), then there are zero pairs of parentheses.

solution = [[""]]

When dp(1) is solved, then the algorithm adds parentheses to all sub-solutions of dp(0)
and appends the solution of dp(0).

solution = [[""], [("")""]]

When dp(2) is solved, then the algorithm adds parentheses to all sub-solutions of dp(0) and dp(1).

solution = [[""], [("")""], [("")(), (())""]]

When dp(3) is solved, then the algorithm adds parentheses to all sub-solutions of dp(0), dp(1), and dp(2).

solution = [""], [("")""], [("")(), (())""], [("")("")(), ("")(())"", (("")"")("")"", (("")())"", ((())"")""]]

The pairing of sub-problem solutions is done by picking entries from opposite ends of the dp list.

When dp(0), then no choice.

When dp(1), then pick index 0.

When dp(2), then pick (0, 1) and (1, 0).

when dp(3), then pick (0, 2) twice, (1, 1), and (2, 0) twice.

and so on.

The important loop conditions are:
* the outer loop is all values from 1 to n; 0 is the empty base case.
* the first inner loop is all the sub-problem values from 0 to n-1.
* the second inner loop is all the strings found in the list of strings at jth position of the dp list.
* the third inner loop is all the strings found in the list of strings at the i - j - 1 position of the dp list.

The value j and i - j - 1 are approaching each other.
As j increments, then i - j - 1 decrements.
