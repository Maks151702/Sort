package MergeSort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        mergeSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // массив уже отсортирован или пуст
        }

        int n = arr.length;
        int[] temp = new int[n];
        mergeSort(arr, temp, 0, n - 1);
    }

    // Рекурсивный метод сортировки слиянием
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Рекурсивно сортируем левую и правую половины
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);

            // Объединяем две отсортированные половины
            merge(arr, temp, left, mid, right);
        }
    }

    // Метод для слияния двух отсортированных половин в одну отсортированную
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Копируем элементы во временный массив
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Индекс для левой половины подмассива
        int j = mid + 1; // Индекс для правой половины подмассива
        int k = left; // Индекс для объединенного подмассива

        // Слияние двух половин в один отсортированный массив
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Копирование оставшихся элементов из левой половины (если есть)
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
