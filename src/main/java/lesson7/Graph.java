package lesson7;

public interface Graph {

    void addVertex(String label);

    boolean addEdge(String startLabel, String secondLabel, int weight);

    int getSize();

    void display();

    /**
     * англ. Depth-first search, DFS
     */
    void dfs(String startLabel, String targetLabel);
}
