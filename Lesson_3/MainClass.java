/**
 * Домашняя работа к уроку 3 "Java 2"
 *
 * @author Андрей Семенюк
 * @version 24.07.2019
 */

/*

 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
  - Написать метод, который найдёт список слов, из которых состоит текст (дубликаты не считать);
  - Написать метод, который посчитает сколько раз встречается каждое слово;

 2. Написать простой класс PhoneBook:
  - В качестве ключа использовать фамилию
  - В каждой записи всего два поля: phone, e-mail
  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
  и отдельный метод для поиска e-mail по фамилии.

  Следует учесть, что под одной фамилией может быть несколько записей.
  Итого должно получиться 3 класса Main, PhoneBook, Person.

* */

import java.util.HashMap;
import java.util.HashSet;

public class MainClass {
    public static void main(String[] args) {

        String [] words = {
                "Ночь, улица, фонарь, аптека,"
                +"Бессмысленный и тусклый свет."
                +"Живи ещё хоть четверть века —"
                +"Всё будет так. Исхода нет."
                +"Умрёшь — начнёшь опять сначала"
                +"И повторится всё, как встарь:"
                +"Ночь, ледяная рябь канала,"
                +"Аптека, улица, фонарь."};
        HashSet<String> setWords = new HashSet<>();
        for (String hw: words)
            setWords.add(hw);
        System.out.println(setWords);

        HashMap<String, Integer> mapWords = new HashMap<>();
        for (String mw: words) {
            Integer in =  mapWords.put(mw, 1);
            if (in != null)
                mapWords.put(mw, ++in);
        }
        System.out.println(mapWords);

        PhoneBook myBook = new PhoneBook();
        myBook.add("Сидоров", "8-999-111-11", "Сидоров@mail.ru");
        myBook.add("Иванов", "8-999-222-22", "Иванов@mail.ru");
        myBook.add("Сидоров", "8-999-333-33", "Сидоров116@mail.ru");
        myBook.add("Петров", "8-999-444-44", "Петров116@mail.ru");
        myBook.add("Шмелев", "8-999-555-55", "Шмелев116@mail.ru");
        myBook.add("Водкин", "8-999-777-77", "Водкин116@mail.ru");
        myBook.printNumber("Иванов");
        myBook.printMail("Петров");


    }
}