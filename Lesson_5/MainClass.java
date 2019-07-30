/**
 * Домашняя работа к уроку 5 "Java 2"
 *
 * @author Андрей Семенюк
 * @version 30.07.2019
 */

/*
1. Необходимо написать два метода, которые делают следующее:

    1) Создают одномерный длинный массив, например:

        static final int size = 10000000;
        static final int h = size / 2;
        float[] arr = new float[size];

    2) Заполняют этот массив единицами;
    3) Засекают время выполнения: long a = System.currentTimeMillis();
    4) Проходят по всему массиву и для каждой ячейки считают новое значение по формуле:
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    5) Проверяется время окончания метода System.currentTimeMillis();
    6) В консоль выводится время работы: System.out.println(System.currentTimeMillis() - a);

        Отличие первого метода от второго:
        Первый просто бежит по массиву и вычисляет значения.
        Второй разбивает массив на два массива, в двух потоках высчитывает новые значения и потом склеивает эти массивы обратно в один.

    Пример деления одного массива на два:

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

    Пример обратной склейки:

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

    Примечание:
        System.arraycopy() – копирует данные из одного массива в другой:
        System.arraycopy(массив-источник, откуда начинаем брать данные из массива-источника, массив-назначение, откуда начинаем записывать данные в массив-назначение, сколько ячеек копируем)
        По замерам времени:
        Для первого метода надо считать время только на цикл расчета:

        for (int i = 0; i < size; i++) {
        arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

    Для второго метода замеряете время разбивки массива на 2, просчета каждого из двух массивов и склейки.
* */

public class MainClass {

    private static final int SIZE = 10000000;
    private static final int H_SIZE = SIZE / 2;

    public static void main(String[] s) {
        MainClass rune = new MainClass();
        rune.oneRunThread();
        rune.twoRunThread();
    }

    public float[] reader(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        return arr;
    }

    public void oneRunThread () {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        reader(arr);
        System.out.println("Первый метод завершился: " + (System.currentTimeMillis() - a));
    }

    public void twoRunThread() {

        float[] arr = new float[SIZE];
        float[] arr1 = new float[H_SIZE];
        float[] arr2 = new float[H_SIZE];
        for (int i = 0; i < arr.length; i++) arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, H_SIZE);
        System.arraycopy(arr, H_SIZE, arr2, 0, H_SIZE);

        new Thread() {
            public void run() {
                float[] a1 = reader(arr1);
                System.arraycopy(a1, 0, arr1, 0, a1.length);
            }
        }.start();

        new Thread() {
            public void run() {
                float[] a2 = reader(arr2);
                System.arraycopy(a2, 0, arr2, 0, a2.length);
            }
        }.start();

        System.arraycopy(arr1, 0, arr, 0, H_SIZE);
        System.arraycopy(arr2, 0, arr, H_SIZE, H_SIZE);
        System.out.println("Второй метод завершился: " + (System.currentTimeMillis() - a));
    }
}

