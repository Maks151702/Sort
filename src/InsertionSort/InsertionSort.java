package InsertionSort;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        // Вызываем метод сортировки вставками
        insertionSort(arr);

        // Вывод отсортированного массива
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Перемещаем элементы массива, которые больше key, на одну позицию вперед
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Вставляем key в правильную позицию
            arr[j + 1] = key;
        }
    }
}

