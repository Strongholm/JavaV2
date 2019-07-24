import java.util.ArrayList;

public class Person {

    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> phoneNumber = new ArrayList<>();
    private String Number;
    private String eMail;


    Person (String number, String mail){
        if (number != null)phoneNumber.add(number);
        if (mail != null)email.add(mail);
    }

    Person addNumber (String number) {
        this.phoneNumber.add(number);
        return this;
    }

    Person addMail (String mail){
        this.email.add(mail);
        return this;
    }

    void addAll (String number, String mail) {
        this.phoneNumber.add(number);
        this.email.add(mail);
    }
}
