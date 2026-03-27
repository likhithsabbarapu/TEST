import java.util.Scanner;
public class PrintName {
    String fname="Likhith";
    String lname="Sabbarapu";
    int age=27;
    void Print(){}


        private String name; // private = restricted access

        // Getter
        public String getName() {
            return name;
        }

        // Setter
        public void setName(String name) {
            this.name = name;
        }


    public static void main(String[] args) {
        PrintName test = new PrintName();
        System.out.println("Name :"+test.fname+" "+test.lname+"\nAge :"+test.age);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        test.setName(sc.next());
        System.out.println("Entered input is "+test.getName());

    }
}

