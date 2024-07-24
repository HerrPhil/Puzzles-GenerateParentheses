import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

/**
 * I added several log messages.
 * I am a visual learner, and need to see all the state values to know
 * where I am in the dynamic programming sub-problems.
 */
public class GenerateParenthesesDynamicProgramming {

    public static void main(String [] args) {
        System.out.printf("Hello Generate Parentheses Dynamic Programming Solution #1%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java GenerateParenthesesDynamicProgramming <N>%n");
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

        GenerateParenthesesDynamicProgramming generateParentheses = new GenerateParenthesesDynamicProgramming(input);

        List<String> result = generateParentheses.solution();

        System.out.printf("the parentheses pair combinations are%n");
        for (String combination : result) {
            System.out.printf("Combination: %s%n", combination);
        }

    }

    private int n;

    public GenerateParenthesesDynamicProgramming(String input) {
        this.n = Integer.valueOf(input);
    }

    public List<String> solution() {

        System.out.printf("%nsolution call%n");

        List<List<String>> dp = new ArrayList<>();
        System.out.printf("declared the dynamic programming list of list of strings%n");

        // initialize empty list of strings for every parentheses pair combination
        for (int i = 0; i <= this.n; i++) {
            dp.add(new ArrayList<>());
        }
        System.out.printf("initialized %d empty list of strings for every parentheses pair combination%n", this.n);

        // Set the solution for n = 0; no parentheses pair combinations
        dp.get(0).add("");
        System.out.printf("set the solution for n = 0; it is no pairs of parentheses (empty string)%n");

        System.out.printf("start iterating on current problem at 1; 0 was set above%n");

        // For every sub-problem, starting at 1, to solve for the nth problem
        for (int i = 1; i <= this.n; i++) {

            System.out.printf("%nfor current dp level i = %d%n", i);

            System.out.printf("start iterating on previous sub-problems at 0%n");

            // for every sub-problem before the ith problem
            for (int j = 0; j < i; j++) {

                System.out.printf("%nfor previous dp sub-problem j = %d%n", j);

                // declare a list of strings of parentheses pairs to be added to dp
                List<String> toBeAdded = new ArrayList<>();
                System.out.printf("declared new to-be-added list of strings of parentheses pair combinations%n");

                System.out.printf("for every parentheses pair combination of the list of strings at dp position j = %d%n", j);

                // for every string of parentheses pair combination in the list of strings at jth position of dp
                for (String x : dp.get(j)) {

                    System.out.printf("%nthis x string of parentheses pair combinations, <<%s>>, will be wrapped by parentheses%n", x);

                    System.out.printf("for every parentheses pair combination of the list of strings at dp position i - j - 1 = %d%n", i - j - 1);

                    // for every string of parentheses pair combination in the list of strings at the i - j - 1 position of dp
                    for (String y : dp.get(i - j - 1)) {

                        System.out.printf("%nthis y string of parentheses pair combination, <<%s>>, will be appended to the wrapped value%n", y);

                        toBeAdded.add("(" + x + ")" + y);

                    }

                }

                // for this jth position of dp,
                // store the to-be-added string of parentheses pair combinations at the ith position of dp
                dp.get(i).addAll(toBeAdded);
                System.out.printf("added all string parentheses pair combinations of to-be-added list to the dp list of index %d%n", i);

                System.out.printf("increment j and test condition j < i%n");

            }

            System.out.printf("increment i and test condition i <= n%n");

        }

        return dp.get(n);
    }

}
