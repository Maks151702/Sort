package CombSort;

public class CombSort {

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 56, 3, -44, 23, -6};

        combSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;


        while (gap > 1 || swapped) {
            gap = getNextGap(gap); // Вычисляем интервал для текущей итерации
            swapped = false; // Сбрасываем флаг обмена

            // Проходим по массиву с интервалом
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Если текущий элемент больше элемента через интервал,
                    // производим обмен элементов
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true; // Устанавливаем флаг обмена в true
                }
            }
        }
    }

    // Метод для вычисления следующего интервала сортировки
    private static int getNextGap(int gap) {
        // Уменьшаем интервал на фактор, обычно 1.3
        gap = (gap * 10) / 13;
        if (gap < 1) {
            return 1; // Если интервал стал менее 1, возвращаем 1
        }
        return gap;
    }
}
