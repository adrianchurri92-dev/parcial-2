public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

   
    public abstract void atacar(Criatura objetivo);

    
    public abstract void defender(int dano);

    
    public boolean estaViva() {
        return salud > 0;
    }

    
    protected void recibirDano(int dano) {
        salud = Math.max(0, salud - dano);
    }

    public String getNombre() { return nombre; }
    public int getSalud()     { return salud; }
    public int getFuerza()    { return fuerza; }

    @Override
    public String toString() {
        return nombre + " [salud=" + salud + ", fuerza=" + fuerza + "]";
    }
}