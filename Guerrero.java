/**
 * Guerrero: ataca con su espada (fuerza) y se defiende con su armadura,
 * que reduce el daño recibido en 3 puntos fijos.
 */
public class Guerrero extends Criatura {

    private String arma; // arma del guerrero

    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    /** El guerrero ataca con su arma: fuerza (+ bono del arma equipada si tiene). */
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() + getBonoArma(); // el arma extra suma su bono
        // Si equipó un arma nueva la usa; si no, usa su arma por defecto
        String armaUsada = tieneArma() ? getArmaEquipada().getNombre() : arma;
        System.out.println(getNombre() + " golpea con su " + armaUsada + " con daño " + daño);
        objetivo.defender(daño);
    }

    /** La armadura reduce 3 puntos de daño; siempre recibe al menos 1. */
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño - 3);
        System.out.println("   " + getNombre() + " bloquea con su armadura y recibe "
                + dañoReal + " de daño");
        recibirDaño(dañoReal);
    }
}
