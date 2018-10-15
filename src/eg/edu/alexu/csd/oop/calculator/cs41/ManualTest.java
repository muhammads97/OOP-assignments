package eg.edu.alexu.csd.oop.calculator.cs41;

public class ManualTest {

    public static void main(String[] args) {
        SalahCalculator sc = new SalahCalculator();
        sc.save();
        sc.input("-3--4");
        sc.input("-2--4");
        sc.input("-1--4");
        sc.input("-4--4");
        sc.input("-5--4");
        sc.save();
        sc.input("-4--6");
        sc.input("-5--7");
        sc.load();
        System.out.println(sc.current());
        System.out.println(sc.prev());
        System.out.println(sc.prev());
        System.out.println(sc.prev());
        System.out.println(sc.prev());
        System.out.println(sc.prev());
        System.out.println(sc.prev());
    }

}
