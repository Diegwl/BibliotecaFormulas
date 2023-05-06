public enum Constantes {
    C(300000000.0), K1(273.0),K2(9000000000.0), R(0.082);

    final double constants;
    //Constructor to initialize the instance variable
    Constantes(double constants) {
        this.constants = constants;
    }
    public static void getConstant(int model){
        Constantes[] constantes = Constantes.values();
        System.out.println("Price of: "+constantes[model]+" is "+constantes[model].constants);
    }
}
