package BucketSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        double[] arr = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};

        // Вызываем метод сортировки корзинами (Bucket Sort)
        bucketSort(arr);

        // Вывод отсортированного массива
        for (double num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bucketSort(double[] arr) {
        int n = arr.length;

        if (n <= 1) {
            return; // Массив уже отсортирован или пуст
        }

        // Создаем массив корзин (бакетов)
        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Распределяем элементы по корзинам
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // Сортируем каждую корзину
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Собираем отсортированные элементы обратно в исходный массив
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (double num : buckets[i]) {
                arr[index] = num;
                index++;
            }
        }
    }
}

