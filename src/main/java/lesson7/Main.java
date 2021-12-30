package lesson7;

public class Main {
    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph() {

        Graph graph = new GraphImpl(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орёл");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 60);
        graph.addEdge("Москва", "Рязань", 8);
        graph.addEdge("Москва", "Калуга", 5);
        graph.addEdge("Тула", "Липецк", 3);
        graph.addEdge("Рязань", "Тамбов", 10);
        graph.addEdge("Калуга", "Орёл", 1);
        graph.addEdge("Липецк", "Воронеж", 7);
        graph.addEdge("Тамбов", "Саратов", 31);
        graph.addEdge("Орёл", "Курск", 16);
        graph.addEdge("Саратов", "Воронеж", 1);
        graph.addEdge("Курск", "Воронеж", 4);

        System.out.println("Size of graph is " + graph.getSize());
        System.out.println();
        graph.dfs("Москва", "Воронеж");
    }
}
