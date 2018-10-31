/*
* https://leetcode.com/problems/evaluate-division/description/
*
* This is a medium level coding example for Google
* */

import java.util.*;


public class Google_Evaluate_Division {

    private static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, List<Double>> weights = new HashMap<>();

        double[] results = new double[queries.length];

        for (int i = 0; i < equations.length; i++) {
            if (!neighbors.containsKey(equations[i][0])) {
                //if key not in the neighbors map, then initialize new array lists for both neighbors and weights
                neighbors.put(equations[i][0], new ArrayList<String>());
                weights.put(equations[i][0], new ArrayList<Double>());
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String[][] equations = { {"a", "b"} , {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = { {"a", "c"} , {"b", "a"}, {"a", "e"},{"a", "a"},{"x", "x"} };

        double[] result = calcEquation(equations, values, queries);

        System.out.println(result.toString());
    }
}
