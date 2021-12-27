package lesson6;

import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static int TREE_COUNT = 20;

    public static void main(String[] args) {
        int unbalancedTrees = 0;
        for (int i = 0; i < TREE_COUNT; i++) {
            Tree<Integer> tree = new TreeImpl<>();
            while (tree.add(ThreadLocalRandom.current().nextInt(-25, 26))) {
            }
            tree.display();
            if (!tree.isBalanced()) {
                unbalancedTrees++;
                System.out.println("Несбалансировано\n");
            } else {
                System.out.println("Сбалансировано\n");
            }
        }
        System.out.println("Несбалансированных: " + (100.0 / TREE_COUNT * unbalancedTrees + "%"));
    }
}
