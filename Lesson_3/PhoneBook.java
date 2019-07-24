import java.util.HashMap;

public class PhoneBook {
    HashMap<String, Person> phoneBook = new HashMap<>();

    void add (String name, String number, String email){
        if (phoneBook.get(name) == null){
            Person pr = new Person(number, email);
            phoneBook.put(name, pr);
        }else {
            phoneBook.get(name).addAll(number, email);
        }
    }

    void addNumToBook (String name, String number) {
        if (phoneBook.get(name) == null){
            Person pr = new Person(number, null);
            phoneBook.put(name, pr);
        }else {
            phoneBook.get(name).addNumber(number);
        }
    }

    void addMailToBook (String name, String mail) {
        if (phoneBook.get(name) == null){
            Person pr = new Person(null, mail);
            phoneBook.put(name, pr);
        }else {
            phoneBook.get(name).addMail(mail);
        }
    }

    void printNumber (String name) {
        System.out.println(phoneBook.get(name).phoneNumber);
    }
    void printMail (String name) {
        System.out.println(phoneBook.get(name).email);
    }
}