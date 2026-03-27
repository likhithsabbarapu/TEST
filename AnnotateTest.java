class AnnotateTest {
    void Test(){
        System.out.println("AnnotateTest");

    }

}
class Annotate1 extends AnnotateTest{
    @Override
    public void Test(){
        System.out.println("Annotate1");


    }



}
class Execute{
    @Deprecated
    static void Test1(){
        System.out.println("This will show an error");
    }
    public static void main(String[] args) {
        Annotate1 t =  new Annotate1()  ;
        t.Test();
       Test1();
    }
}