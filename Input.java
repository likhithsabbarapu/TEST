import javax.xml.crypto.Data;
import java.util.Scanner;

public class Input {

    public void main(String[] args) {
    Data();
    }
    public void Data(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = myObj.nextLine();
        String comment=myObj.nextLine();
        System.out.println("Username is: " + userName);
        System.out.println(comment);

    }
}
