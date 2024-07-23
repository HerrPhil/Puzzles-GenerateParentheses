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
public class GenerateParenthesesInterviewingIo {

    public static void main(String [] args) {
        System.out.printf("Hello Generate Parentheses Interviewing.io Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java GenerateParenthesesInterviewingIo <N>%n");
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

        GenerateParenthesesInterviewingIo generateParentheses = new GenerateParenthesesInterviewingIo(input);

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

    public GenerateParenthesesInterviewingIo(String input) {
        this.n = Integer.valueOf(input);
        answer = new ArrayList<>();
        this.solution = new char [ 2 * this.n];
        this.solutionIndex = 0;
    }

    public List<String> solution() {
                
        System.out.printf("%nsolution call%n");

        backtrack(this.n, this.n);

        return answer;
    }

    private void backtrack(int openParenthesesNeeded, int closeParenthesesNeeded) {

        System.out.printf("%n%nbacktrack call%n");
        System.out.printf("solution index %d (indicates recursion depth)%n", solutionIndex);
        System.out.printf("solution = %s, open parentheses needed = %d, close parentheses needed = %d%n", Arrays.toString(solution), openParenthesesNeeded, closeParenthesesNeeded);

        System.out.printf("check whether open parentheses needed is equal to 0 and close parentheses needed is equal to 0%n");
        if (openParenthesesNeeded == 0 && closeParenthesesNeeded == 0) {
            System.out.printf("Open parentheses needed is equal to 0 and close parentheses needed is equal to 0, add solution to answer%n");
            answer.add(Arrays.toString(solution));
        } else {
            System.out.printf("Not the case that open parentheses needed is equal to 0 and close parentheses needed is equal to 0%n");
            System.out.printf("Continue to next processing rule%n");
        }


        System.out.printf("check whether open parentheses needed %d is greater than 0%n", openParenthesesNeeded);
        if (openParenthesesNeeded > 0) {
            System.out.printf("the open parentheses needed %d is greater than 0%n", openParenthesesNeeded);
            
            solution[solutionIndex] = '(';
            System.out.printf("added '(' to the solution%n");

            solutionIndex++;
            System.out.printf("incremented the solution index%n");

            System.out.printf("recursively call backtrack()%n");

            backtrack(openParenthesesNeeded - 1, closeParenthesesNeeded);

            System.out.printf("%nreturned from recursive call to backtrack()%n");
            System.out.printf("    where open parentheses needed %d is greater than 0%n", openParenthesesNeeded);

        } else {

            System.out.printf("open parentheses needed %d is not greater than 0%n", openParenthesesNeeded);
            System.out.printf("Continue to next processing rule%n");

        }

        System.out.printf("check whether close parentheses needed %d is greater than 0 and open parentheses needed %d is less than close parentheses needed %d%n", closeParenthesesNeeded, openParenthesesNeeded, closeParenthesesNeeded);
        if (closeParenthesesNeeded > 0 && openParenthesesNeeded < closeParenthesesNeeded) {
            System.out.printf("the close parentheses needed %d is greater than 0 and open parentheses needed %d is less than close parentheses needed %d%n", closeParenthesesNeeded, openParenthesesNeeded, closeParenthesesNeeded);

            solution[solutionIndex] = ')';
            System.out.printf("added ')' to the solution%n");

            solutionIndex++;
            System.out.printf("incremented the solution index%n");

            System.out.printf("recursively call backtrack()%n");

            backtrack(openParenthesesNeeded, closeParenthesesNeeded - 1);

            System.out.printf("%nreturned from recursive call to backtrack()%n");
            System.out.printf("    where the close parentheses needed %d is greater than 0 and open parentheses needed %d is less than close parentheses needed %d%n", closeParenthesesNeeded, openParenthesesNeeded, closeParenthesesNeeded);

        } else {

            System.out.printf("not the case that close parentheses needed %d is greater than 0 and open parentheses needed %d is less than close parentheses needed %d%n", closeParenthesesNeeded, openParenthesesNeeded, closeParenthesesNeeded);

        }

        System.out.printf("check whether solution index %d is greater than 0%n", solutionIndex);
        if (solutionIndex > 0) {

            System.out.printf("the solution index %d is greater than 0%n", solutionIndex);

            solutionIndex--;
            System.out.printf("solution index rolled back to %d%n", solutionIndex);

            solution[solutionIndex] = '\u0000'; // nothing
            System.out.printf("solution rolled back to %s%n", Arrays.toString(solution));

        }

        System.out.printf("%nbacktrack complete%n");
        System.out.printf("    where solution = %s, open parentheses needed = %d, close parentheses needed = %d%n", Arrays.toString(solution), openParenthesesNeeded, closeParenthesesNeeded);

    }

}
