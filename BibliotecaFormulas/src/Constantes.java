public enum Constantes {
    C(300000000);

    private int con;
    Constantes(int con){
        this.con = con;
    }
    public getCon(String valor){
        Constantes con[] = Constantes.values();
        return con[valor];
    }
}
