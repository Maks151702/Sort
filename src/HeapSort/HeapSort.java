package HeapSort;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        heapSort(arr);

        // Вывод отсортированного массива
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Строим max-кучу (пирамиду)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлекаем элементы из кучи по одному и помещаем их в конец массива
        for (int i = n - 1; i >= 0; i--) {
            // Помещаем текущий корень кучи (максимальный элемент) в конец массива
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем heapify для уменьшенной кучи
            heapify(arr, i, 0);
        }
    }

    // Метод для преобразования поддерева с корнем root в max-кучу
    private static void heapify(int[] arr, int n, int root) {
        int largest = root;
        int leftChild = 2 * root + 1;
        int rightChild = 2 * root + 2;

        // Если левый дочерний элемент больше корня
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // Если правый  больше корня
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // Если наибольший элемент не корень
        if (largest != root) {
            int swap = arr[root];
            arr[root] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно применяем heapify к поддереву
            heapify(arr, n, largest);
        }
    }
}
