class Edge {

    double weight;
    String nodeName;

    public Edge(double weight, String nodeName) {
        this.weight = weight;
        this.nodeName = nodeName;
    }

    public double getWeight() {
        return weight;
    }

    public String getNode() {
        return nodeName;
    }

}


class Solution {
    
    private HashMap<String, List<Edge>> graph = new HashMap<>();
    
    private void formGraph(List<List<String>> equations, double[] values) {
        int index = 0;
        Iterator<List<String>> eq = equations.iterator();
        while (eq.hasNext()) {
            List<String> equation = eq.next();
            String node1 = equation.get(0), node2 = equation.get(1);
            Edge to = new Edge(values[index], node2);
            Edge from = new Edge(1.0/values[index], node1);
            graph.putIfAbsent(node1, new LinkedList<Edge>());
            graph.compute(node1, (key, val) -> (val.add(to)) ? val : val);
            graph.putIfAbsent(node2, new LinkedList<Edge>());
            graph.compute(node2, (key, val) -> (val.add(from)) ? val : val);
            index++;
        }
    }

    public double relationOfNodes(String node1, String node2, HashMap<String, Boolean> visited) {
        List<Edge> edges = graph.get(node1);
        visited.put(node1, true);
        if (edges==null) return -1;
        if (node1.equals(node2)) return 1;
        Iterator<Edge> it = edges.iterator();
        while (it.hasNext()) {
            Edge edge = it.next();
            double weight = edge.getWeight();
            String newNode = edge.getNode();
            if (newNode.equals(node2)) {
                return weight;
            }
            if (!visited.getOrDefault(newNode, false)) {
                weight*=relationOfNodes(newNode, node2, visited);
                if (weight >= 0) return weight;
            }
        }
        return -1;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] queryResults = new double[queries.size()];
        Iterator<List<String>> qu = queries.iterator();
        formGraph(equations, values);
        int queryIndex = 0;
        while (qu.hasNext()) {
            List<String> query = qu.next();
            HashMap<String, Boolean> visited = new HashMap<>();
            boolean hasRoute = false;
            queryResults[queryIndex] = relationOfNodes(query.get(0), query.get(1), visited);
            queryIndex++;
        }
        return queryResults;
    }
}