package RadixSort;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        radixSort(arr);

        // Вывод отсортированного массива
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Массив уже отсортирован или пуст
        }

        // Находим максимальное значение в массиве, чтобы определить количество разрядов
        int max = Arrays.stream(arr).max().getAsInt();

        // Выполняем сортировку для каждого разряда, начиная с самого младшего
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Для хранения частоты каждой цифры от 0 до 9

        // Инициализируем массив count
        Arrays.fill(count, 0);

        // Заполняем count счетчиками для каждой цифры
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Обновляем count, чтобы каждый элемент содержал сумму предыдущих счетчиков
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Строим выходной массив (отсортированный)
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Копируем отсортированный массив в исходный массив
        System.arraycopy(output, 0, arr, 0, n);
    }
}
