public class Main {
    public static void main(String[] args) {
        Formulas form = new Formulas();
        double massa = 0.000000000003;
        double energia = form.Energia(massa);
        System.out.println(energia);
    }
}