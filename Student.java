public class Student {
    private String name;
    private int age;

    // Setter method
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    // Getter method
    public int getAge() {
        return age;
    }

    // Setter method
    public void setName(String name) {
        this.name = name;
    }

    // Getter method
    public String getName() {
        return name;
    }
}



