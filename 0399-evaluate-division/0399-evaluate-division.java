class Solution {
    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Map<String, Double>> map = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {
            String varA = equations.get(i).get(0);
            String varB = equations.get(i).get(1);
            double quotient = values[i];

            map.putIfAbsent(varA, new HashMap<>());
            map.putIfAbsent(varB, new HashMap<>());

            map.get(varA).put(varB, quotient);
            map.get(varB).put(varA, 1.0 / quotient);
        }

        double[] result = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {
            String queryA = queries.get(i).get(0);
            String queryB = queries.get(i).get(1);

            result[i] = compute(
                queryA,
                queryB,
                map,
                new HashSet<>(),
                1.0
            );
        }

        return result;
    }

    private double compute(
            String queryA,
            String queryB,
            Map<String, Map<String, Double>> map,
            Set<String> seen,
            double prodSoFar) {

        // Variable doesn't exist
        if (!map.containsKey(queryA)) {
            return -1.0;
        }

        // Found destination
        if (queryA.equals(queryB)) {
            return prodSoFar;
        }

        seen.add(queryA);

        for (Map.Entry<String, Double> entry : map.get(queryA).entrySet()) {
            String next = entry.getKey();
            double weight = entry.getValue();

            if (seen.contains(next)) {
                continue;
            }

            double result = compute(
                next,
                queryB,
                map,
                seen,
                prodSoFar * weight
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }
}