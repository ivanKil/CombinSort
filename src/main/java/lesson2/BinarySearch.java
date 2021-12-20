package lesson2;


public class BinarySearch {
    public static int searchSkippedNum(Integer[] arr) {
        if (arr.length == 0 || arr[0] != 1) {
            System.out.println("Найденное число: 1");
            return 1;
        }
        if (arr[arr.length - 1] == arr.length) {
            System.out.println("В массиве нет пропущенного числа");
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        int base;
        int i = 0;

        while (end >= start) {
            i++;
            base = (start + end) / 2;

            if (arr[base + 1] - arr[base] == 2) {
                System.out.println("Найденное число: " + (arr[base] + 1) + ", кол-во итераций: " + i);
                return base;
            } else if (arr[base] > base + 1) {
                end = base - 1;
            } else {
                start = base + 1;
            }
        }

        System.out.println("Число не найдено, кол-во итераций: " + i);
        return -1;
    }
}
