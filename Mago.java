/** */
 * //Mago: ataca con hechizos (fuerza) y se defiende con un escudo mágico
 * //que absorbe el 10% del daño recibido.
 ///
public class Mago extends Criatura {

    private String hechizos; // hechizo que utiliza el mago

    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    /** El mago ataca con un hechizo: fuerza (+ bono del arma si tiene). */
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() + getBonoArma(); // el arma suma su bono
        String conArma = tieneArma() ? " potenciado por " + getArmaEquipada().getNombre() : "";
        System.out.println(getNombre() + " lanza el hechizo " + hechizos + conArma
                + " con daño " + daño);
        objetivo.defender(daño);
    }

    /** El escudo mágico absorbe el 10% del daño; siempre recibe al menos 1. */
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño - (daño * 10 / 100));
        System.out.println("   " + getNombre() + " invoca un escudo mágico y recibe "
                + dañoReal + " de daño");
        recibirDaño(dañoReal);
    }
}
