import java.util.*;


public class Matching_Braces {
    static String[] braces(String[] values) {

        String[] results = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            results[i] = isBalanced(values[i]);
        }
        return results;
    }

    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            if (i == 0 && (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']')) {
                return "NO";
            }

            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return "NO";
                }

                char testing = stack.pop();
                if (testing == '{') {
                    if (s.charAt(i) != '}' ) {
                        return "NO";
                    }
                }
                if (testing == '(') {
                    if (s.charAt(i) != ')' ) {
                        return "NO";
                    }
                }
                if (testing == '[') {
                    if (s.charAt(i) != ']' ) {
                        return "NO";
                    }
                }
            }
        }

        if (stack.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        String[] given = {"{[()]}", "{[(])}", "{{[[(())]]}}"};
        String[] result = braces(given);
        System.out.println(Arrays.toString(result));
    }
}
