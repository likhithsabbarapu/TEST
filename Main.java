//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    Input inp= new Input();
    inp.Data();

    System.out.println("Hello and welcome!");
    PlaceHolder ph =new PlaceHolder();
    ph.array();
    HashMap1 hm =new HashMap1();
    hm.Map();
    ReadTest rd= new ReadTest();
    rd.fullThrottle();
        Persons myObj = new Persons();
        myObj.setName("John"); // Set the value of the name variable to "John"
        System.out.println(myObj.getName());
        BankAccount ba = new BankAccount();
        ba.deposit(5000);

        System.out.println(ba.getBalance());

        Student s = new Student();

        s.setName("Alex");
        s.setAge(15);

        System.out.println(s.getName());
        System.out.println(s.getAge());


}
}
