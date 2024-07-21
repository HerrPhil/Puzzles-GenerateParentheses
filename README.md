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

## Leetcode Solution Tip

We can use an open bracket if number of open brackets is less than N.

We can use a closed bracket if number of closed brackets is less than number of open brackets.

The base case (stop condition) number of open brackets == number of closed brackets == N.
