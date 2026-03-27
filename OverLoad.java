public class OverLoad {
    int modelYear;
    String modelName;

    public OverLoad(int year, String model) {
    modelYear = year;
    modelName=model;
    }



    public static void main(String[] args) {
        OverLoad test = new OverLoad(1979,"Ferrari");
        System.out.println(test.modelYear+" "+test.modelName);
    }
}
