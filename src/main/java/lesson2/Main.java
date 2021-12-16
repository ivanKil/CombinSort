package lesson2;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10000;

        Notebook[] arr = Notebook.getArray(SIZE);
        //System.out.println(Arrays.toString(arr));
        SpeedTest.startTime();
        CombSort.sort(arr);
        SpeedTest.endTime();
        //System.out.println(Arrays.toString(arr));
    }
}
