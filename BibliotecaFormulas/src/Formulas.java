public class Formulas extends Matematica implements Constante{
    public Formulas() {}
    public double velocidadeDaLuz;
    @Override
    public double getConstant() {
        Constantes[] constantes = Constantes.values();
        for (int i = 0; i < constantes.length; i++) {
            if (i == 0) {
                velocidadeDaLuz = constantes[0].constants;
            }
        }
        return 0;
    }
    @Override
    public double pot(double n1, double n2) {
        double pot = n1;
        for (int i = 1; i <= n2; i++) {
            pot = pot*n1;
        };
        return pot;
    }
    public double Energia(double massa){
        // E = m*c²
        return pot(velocidadeDaLuz, 2) * massa;
    }
}
