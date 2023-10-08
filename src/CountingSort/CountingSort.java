package CountingSort;

public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        countingSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Если массив уже отсортирован или пуст, выходим из метода
        }

        // Находим минимальное и максимальное значения в массиве
        int min = arr[0];
        int max = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num; // Находим минимум
            }
            if (num > max) {
                max = num; // Находим максимум
            }
        }

        // Создаем массив для подсчета частоты встречаемости элементов
        int[] countArray = new int[max - min + 1];

        // Заполняем countArray частотой встречаемости каждого элемента
        for (int num : arr) {
            countArray[num - min]++; // Увеличиваем счетчик для текущего элемента
        }

        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                arr[index] = i + min; // Восстанавливаем элементы из countArray
                index++;
                countArray[i]--;
            }
        }
    }
}
