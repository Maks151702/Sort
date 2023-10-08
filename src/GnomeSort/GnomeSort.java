package GnomeSort;

public class GnomeSort {

    public static void main(String[] args) {
        int[] arr = {34, 2, 10, -9, 19, 42, -5};

        gnomeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void gnomeSort(int[] arr) {
        int n = arr.length;
        int index = 0;

        while (index < n) {
            if (index == 0) {
                index++; // Если текущий индекс - 0, увеличиваем его на 1
            }
            if (arr[index] >= arr[index - 1]) {
                index++; // Если текущий элемент больше или равен предыдущему, двигаемся вперед
            } else {
                // Если текущий элемент меньше предыдущего, меняем их местами
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--; // Двигаемся назад после обмена
            }
        }
    }
}
