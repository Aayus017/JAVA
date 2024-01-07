public class TestOctagon {
    public static void main(String[] args) {
        Octagon oct1 = new Octagon(5.0);
        Octagon oct2 = (Octagon) oct1.clone();

        oct2.setSide(6.0);

        System.out.println("oct1: "+oct1);
        System.out.println("oct2: "+oct2);

        int comparison = oct1.compareTo(oct2);
        System.out.println("oct1.compareTo (oct2): " + comparison);
    }
}