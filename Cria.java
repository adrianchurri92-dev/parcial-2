/**
 * Clase abstracta que representa a cualquier criatura del juego.
 * Define los atributos comunes y los métodos que cada subclase
 * debe implementar a su manera (polimorfismo).
 */
public abstract class Criatura {

    // Atributos comunes a todas las criaturas
    private String nombre;
    private int salud;
    private int fuerza;
    private Arma armaEquipada; // arma opcional (null si no tiene)

    /**
     * Constructor de la criatura.
     * @param nombre nombre de la criatura
     * @param salud  puntos de vida iniciales
     * @param fuerza fuerza base usada para calcular el daño
     */
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    /** Ataca a otra criatura. Cada subclase define su forma de atacar. */
    public abstract void atacar(Criatura objetivo);

    /**
     * Se defiende de un ataque. Cada subclase define cómo reduce el daño.
     * @param daño daño recibido (equivale a la fuerza del atacante)
     */
    public abstract void defender(int daño);

    /** Indica si la criatura sigue viva (salud > 0). */
    public boolean estaViva() {
        return salud > 0;
    }

    /**
     * Resta salud a la criatura sin dejar que baje de 0.
     * Es protected para que solo las subclases lo usen al defenderse.
     */
    protected void recibirDaño(int daño) {
        salud = Math.max(0, salud - daño);
    }


    /**
     * Equipa un arma a la criatura (cualquier tipo de criatura puede usarla).
     * Si ya tenía una, la reemplaza.
     */
    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
        System.out.println(nombre + " equipa " + arma.getNombre()
                + " (+" + arma.getBonoDaño() + " de daño)");
    }

    /** Indica si la criatura tiene un arma equipada. */
    public boolean tieneArma() {
        return armaEquipada != null;
    }

    /** Devuelve el arma equipada (o null si no tiene). */
    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    /** Daño extra aportado por el arma equipada (0 si no tiene). */
    protected int getBonoArma() {
        return tieneArma() ? armaEquipada.getBonoDaño() : 0;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }
}
