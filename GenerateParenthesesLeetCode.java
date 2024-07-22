import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

/**
 * I added several log messages.
 * Recursion calls on the call stack and their state are hard to follow
 * by tracing the code alone.
 * I am a visual learner, and need to see all the state values to know
 * where I am in the recursion logic.
 */
public class GenerateParenthesesLeetCode {

    public static void main(String [] args) {
        System.out.printf("Hello Generate Parentheses LeetCode Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java GenerateParenthesesLeetCode <N>%n");
            return;
        }

        if (args == null || args.length == 0) { // check for args
            System.out.printf("The string of keypad digits is necessary  %n");
            return;
        }

        String input = args[0];
        boolean hasValidNumber = input.matches("^[\\d]+$");
        if (!hasValidNumber) {
            System.out.printf("Number must be 1 or more digits%n");
            return;
        }

        GenerateParenthesesLeetCode generateParentheses = new GenerateParenthesesLeetCode(input);

        List<String> result = generateParentheses.solution();

        System.out.printf("the pairs of parentheses combinations are%n");
        for (String combination : result) {
            System.out.printf("Combination: %s%n", combination);
        }

    }

    private int n;
    private List<String> answer;
    private char [] solution;
    private int solutionIndex;

    public GenerateParenthesesLeetCode(String input) {
        this.n = Integer.valueOf(input);
        answer = new ArrayList<>();
        this.solution = new char [ 2 * this.n];
        this.solutionIndex = 0;
    }

    public List<String> solution() {
                
        System.out.printf("%nsolution call%n");

        backtrack(0, 0);

        return answer;
    }

    private void backtrack(int openParentheses, int closeParentheses) {

        System.out.printf("%n%nbacktrack call%n");
        System.out.printf("solution index %d (indicates recursion depth)%n", solutionIndex);
        System.out.printf("solution = %s, open parentheses = %d, close parentheses = %d%n", Arrays.toString(solution), openParentheses, closeParentheses);

        System.out.printf("check whether solution index is equal to 2 * %d%n", this.n);
        if (solutionIndex == 2 * n) {
            System.out.printf("Solution index is 2 * %d, add solution to answer%n", this.n);
            answer.add(Arrays.toString(solution));
            System.out.printf("back track to recursive call%n");
            return;
        } else {
            System.out.printf("Solution index is not 2 * %d%n", this.n);
            System.out.printf("Continue to next processing rule%n");
        }


        System.out.printf("check whether open parentheses %d is less than N = %d%n", openParentheses, this.n);
        if (openParentheses < n) {
            System.out.printf("open parentheses %d is less than N = %d%n", openParentheses, this.n);
            
            solution[solutionIndex] = '(';
            System.out.printf("added '(' to the solution%n");

            solutionIndex++;
            System.out.printf("incremented the solution index%n");

            System.out.printf("recursively call backtrack()%n");

            backtrack(openParentheses + 1, closeParentheses);

            System.out.printf("%nreturned from recursive call to backtrack() when open < n where current state is%n");
            System.out.printf("open parentheses %d is less than N = %d%n", openParentheses, this.n);

            solutionIndex--;
            System.out.printf("solution index back-tracked to %d%n", solutionIndex);

            solution[solutionIndex] = '\u0000'; // nothing
            System.out.printf("solution back-tracked to %s%n", Arrays.toString(solution));

        } else {

            System.out.printf("open parentheses %d is not less than N = %d%n", openParentheses, this.n);
            System.out.printf("Continue to next processing rule%n");

        }

        System.out.printf("check whether open parentheses %d is greater than closeParentheses %d%n", openParentheses, closeParentheses);
        if (openParentheses > closeParentheses) {
            System.out.printf("open parentheses %d is greater than close parentheses %d%n", openParentheses, closeParentheses);

            solution[solutionIndex] = ')';
            System.out.printf("added ')' to the solution%n");

            solutionIndex++;
            System.out.printf("incremented the solution index%n");

            System.out.printf("recursively call backtrack()%n");

            backtrack(openParentheses, closeParentheses + 1);

            System.out.printf("%nreturned from recursive call to backtrack() when open > close where current state is%n");
            System.out.printf("open parentheses %d is greater than close parentheses %d%n", openParentheses, closeParentheses);

            solutionIndex--;
            System.out.printf("solution index rolled back to %d%n", solutionIndex);

            solution[solutionIndex] = '\u0000'; // nothing
            System.out.printf("solution rolled back to %s%n", Arrays.toString(solution));

        } else {

            System.out.printf("open parentheses %d is not greater than close parentheses %d%n", openParentheses, closeParentheses);

        }

        System.out.printf("%nbacktrack complete%n");
        System.out.printf("solution index %d (indicates recursion depth)%n", solutionIndex);
        System.out.printf("solution = %s, open parentheses = %d, close parentheses = %d%n", Arrays.toString(solution), openParentheses, closeParentheses);

    }

}
