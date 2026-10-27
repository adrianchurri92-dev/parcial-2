
public class Dragon extends Criatura {

    private String escamas; 

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() * 2 + getBonoArma(); 
        String conArma = tieneArma() ? " usando " + getArmaEquipada().getNombre() : "";
        System.out.println(getNombre() + " lanza un ataque de fuego y garra" + conArma
                + " con daño " + daño);
        objetivo.defender(daño);
    }

    
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(1, daño - (daño * 20 / 100));
        System.out.println("   " + getNombre() + " se protege con sus escamas de " + escamas
                + " y recibe " + dañoReal + " de daño");
        recibirDaño(dañoReal);
    }
}
