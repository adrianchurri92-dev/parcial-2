public class Main {

    // Polimorfismo: el metodo recibe cualquier tipo de Criatura
    public static Criatura batalla(Criatura a, Criatura b) {
        System.out.println("\n=== BATALLA: " + a.getNombre() + " vs " + b.getNombre() + " ===");
        int turno = 1;

        while (a.estaViva() && b.estaViva()) {
            System.out.println("\n-- Turno " + turno++ + " --");
            a.atacar(b);
            if (b.estaViva()) {
                b.atacar(a);
            }
        }

        Criatura ganadora = a.estaViva() ? a : b;
        Criatura perdedora = a.estaViva() ? b : a;
        System.out.println("\n" + perdedora.getNombre() + " ha caido. Gana " + ganadora.getNombre()
                + " con " + ganadora.getSalud() + " de salud!");
        return ganadora;
    }

    public static void main(String[] args) {
        Criatura dragon = new Dragon("Smaug", 120, 18);
        Criatura elfo   = new Elfo("Legolas", 100, 15);
        Criatura orco   = new Orco("Grishnakh", 110, 16);

        System.out.println("Participantes:");
        System.out.println(" - " + dragon);
        System.out.println(" - " + elfo);
        System.out.println(" - " + orco);

        Criatura finalista = batalla(dragon, elfo);
        Criatura campeon   = batalla(finalista, orco);

        System.out.println("\n*** CAMPEON: " + campeon.getNombre() + " ***");
    }
}