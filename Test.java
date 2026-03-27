class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
}

class Test {
    static void change(Person p) {
        p.name = "Bob";
    }

    public static void main(String[] args) {
        Person p = new Person("Alice");
        change(p);
        System.out.println(p.name);
    }
}
