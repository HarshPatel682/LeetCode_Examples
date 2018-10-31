/*
* https://leetcode.com/problems/evaluate-division/description/
*
* This is a medium level coding example for Google
* */

import java.util.*;


public class Google_Evaluate_Division {

    private static Map<String, List<String>> neighbors = new HashMap<>();
    private static Map<String, List<Double>> weights = new HashMap<>();

    private static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        double[] results = new double[queries.length];

        for (int i = 0; i < equations.length; i++) {
            if (!neighbors.containsKey(equations[i][0])) {
                //if key not in the neighbors map, then initialize new array lists for both neighbors and weights
                neighbors.put(equations[i][0], new ArrayList<String>());
                weights.put(equations[i][0], new ArrayList<Double>());
            }

            if (!neighbors.containsKey(equations[i][1])) {
                //if key not in the neighbors map, then initialize new array lists for both neighbors and weights
                neighbors.put(equations[i][1], new ArrayList<String>());
                weights.put(equations[i][1], new ArrayList<Double>());
            }
            
            //adding neighbors and weights for both sides
            neighbors.get(equations[i][0]).add(equations[i][1]);
            weights.get(equations[i][0]).add(values[i]);

            neighbors.get(equations[i][1]).add(equations[i][0]);
            weights.get(equations[i][1]).add(1.0/ values[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            results[i] = dfs(queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
        }

        return results;
    }

    private static double dfs(String start, String end, Set<String> visited_nodes, double value) {
        //going to be recursive, so here are break cases
        if (visited_nodes.contains(start) || !neighbors.containsKey(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return value;
        }

        visited_nodes.add(start);
        for (int i = 0; i < neighbors.get(start).size(); i++) {
            double result = dfs(neighbors.get(start).get(i), end, visited_nodes, value * weights.get(start).get(i));
            if (result != -1.0) {
                return result;
            }
        }
        visited_nodes.remove(start);
        return -1.0;
    }

    public static void main(String[] args) {
        String[][] equations = { {"a", "b"} , {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] queries = { {"a", "c"} , {"b", "a"}, {"a", "e"},{"a", "a"},{"x", "x"} };

        double[] result = calcEquation(equations, values, queries);

        System.out.println(Arrays.toString(result));
    }
}
