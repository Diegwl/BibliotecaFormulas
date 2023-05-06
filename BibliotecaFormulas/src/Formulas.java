public class Formulas extends Matematica implements Constante{
    public Formulas() {}
    public double velocidadeDaLuz;
    public double celsiusParaKelvin;
    public double eletrostatica;
    public double gases;
    @Override
    public double getConstant() {
        Constantes[] constantes = Constantes.values();
        for (int i = 0; i < constantes.length; i++) {
            if (i == 0) {
                velocidadeDaLuz = constantes[0].constants;
            } else if (i == 1){
                celsiusParaKelvin = constantes[1].constants;
            } else if (i == 2) {
                eletrostatica = constantes[2].constants;
            } else if (i == 3) {
                gases = constantes[3].constants;
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
    @Override
    public double modulo(double n1){
    if (n1>0){
        return n1;
    } else if (n1<0) {
        return n1*(-1);
    } else {
        return 0;
    }
    }

    @Override
    public double raiz(double n1, double n2){
        double chute = n1;
        double erro = 1e-15; // Define a precisão da aproximação
        while (Math.abs(chute - n1/chute) > erro*chute) {
            chute = (n1/chute + chute) / n2;
        }
        return chute;
    }

    public double Energia(double massa){
        // E = m*c²
        getConstant();
        return pot(velocidadeDaLuz, 2) * massa;
    }

    public double Kelvin(double celsius){
        getConstant();
        return celsius+celsiusParaKelvin;
    }

    public double ForcaEletrica(double q1, double q2, double r){
        getConstant();
        return eletrostatica * ((modulo(q1)*modulo(q2))/pot(r, 2));
    }

    public double[] FuncaoSegundoGau(double a, double b, double c){
        double x1 = (-b+raiz((pot(b, 2)-4*a*c), 2)/2);
        double x2 = (-b-raiz((pot(b, 2)-4*a*c), 2)/2);
        return new double[]{x1, x2};
    }

    public double PressaoGases (double v, double n, double t){
        getConstant();
        return (n * gases * t) / v;
    }

    public double VolumeGases (double p, double n, double t){
        getConstant();
        return (n * gases * t) / p;
    }

    public double TemperaturaGases (double p, double v, double n){
        getConstant();
        return (p * v)/(n * gases);
    }
}
