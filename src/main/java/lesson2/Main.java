package lesson2;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 10000;

        Notebook[] arr = Notebook.getArray(SIZE);
        //System.out.println(Arrays.toString(arr));
        //SpeedTest.startTime();
        //CombSort.sort(arr);
        BinarySearch.searchSkippedNum(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16});
        //BinarySearch.search(new Integer[]{1, 2, 3, 5});
        //BinarySearch.search(new Integer[]{});
        //SpeedTest.endTime();
        //System.out.println(Arrays.toString(arr));
    }
}
