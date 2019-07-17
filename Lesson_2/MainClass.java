/**
 * Домашняя работа к уроку 2 "Java 2"
 *
 * @author Андрей Семенюк
 * @version 17.07.2019
 */


/* 1. Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0"; (другими словами матрица 4x4)
*     1 3 1 2
*     2 3 2 2
*     5 6 7 1
*     3 3 1 0
*
*  2. Написать метод, на вход которого подаётся такая строка, метод должен преобразовать строку в двумерный массив типа String[][];
*
*  a. Преобразовать все элементы массива в числа типа int, просуммировать, поделить полученную сумму на 2, и вернуть результат;
*
*  b. Ваши методы должны бросить исключения с собственными названиями в случаях:
*     Если размер матрицы, полученной из строки, не равен 4x4;
*     Если в одной из ячеек полученной матрицы не число; (например символ или слово)
*
*  c. В методе main необходимо вызвать полученный метод, обработать возможные исключения и вывести результат расчета.
* */
public class MainClass {


    public static void main(String[] args) {

        System.out.print("Enter string to parse: ");

        do {
            Matrix.inputString = Matrix.readString();
        } while (Matrix.inputString.length() == 0);

        try {
            Matrix.inputLineToArray();
            Matrix.arrayStringToInt();
            Matrix.arraySumm();
            System.out.println("Result: " + Matrix.arrayDivideSumm());
        } catch (MatrixException4x4 | MatrixExceptionStringOrInt e) {
            System.out.println("MatrixException: " + e.getMessage());
        }

    }

}