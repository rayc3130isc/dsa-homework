package HW2_ArrayLists_Generics.class_sketchpad;

public class lambda_iterators {
    public static void main(String [] args) {
        Greeting g = () -> System.out.println("Hello!");
        g.sayHello();
    }
    public interface Greeting {
        void sayHello();
    }
}
