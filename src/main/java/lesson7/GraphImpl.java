package lesson7;

import java.util.*;

public class GraphImpl implements Graph {
    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    ArrayList<String> minPuth = new ArrayList<>();
    int minWeight = -1;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }


    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight;
        return false;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != 0) {
                    sb.append(" -").append(adjMatrix[i][j]).append("-> ").append(vertexList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public void dfs(String startLabel, String targetLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(targetLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }
        if (endIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + targetLabel);
        }
        Vertex targetVertex = vertexList.get(endIndex);
        Stack<Vertex> stack = new Stack<>();
        resetVertexVisited();
        Vertex vertex = vertexList.get(startIndex);
        ArrayList<String> curPuth = new ArrayList<>();
        curPuth.add(startLabel);
        int curMinWeight = 0;

        stack.add(vertex);
        while (!stack.isEmpty()) {
            Vertex prev = stack.peek();
            vertex = getNearUnvisitedVertex(prev);
            if (vertex != null) {
                if (prev.getLabel().equals(startLabel)) {
                    if (curMinWeight < minWeight || (minWeight == -1 && curMinWeight != 0)) {
                        updateMin(curMinWeight, curPuth);
                        curMinWeight = 0;
                        targetVertex.setVisited(false);
                        curPuth = new ArrayList<>();
                        curPuth.add(startLabel);
                    }
                }
                curMinWeight = curMinWeight + visitVertex(stack, prev, vertex);
            } else {
                Vertex v = stack.pop();
                if (v.getLabel().equals(startLabel))
                    break;
                curPuth.add(1, v.getLabel());
            }
        }
        if (curMinWeight < minWeight || (minWeight == -1 && curMinWeight != 0)) {
            updateMin(curMinWeight, curPuth);
        }
        System.out.println("Кратчайший путь: " + minWeight + " " + minPuth);
    }

    private void updateMin(int curMinWeight, ArrayList<String> curPuth) {
        minPuth.clear();
        minPuth.addAll(curPuth);
        minWeight = curMinWeight;
        System.out.println("Путь:" + minWeight + " " + minPuth);
    }

    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] != 0 && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private int visitVertex(Stack<Vertex> stack, Vertex prevVertex, Vertex vertex) {
        int ind1 = indexOf(prevVertex.getLabel());
        int ind2 = indexOf(vertex.getLabel());
        int weight = adjMatrix[ind1][ind2];
        stack.add(vertex);
        vertex.setVisited(true);
        return weight;
    }

    private void resetVertexVisited() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }
}
