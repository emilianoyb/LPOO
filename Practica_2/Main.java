public class Main {

    public static void main(String[] args) {

        System.out.println("=== Clínica Veterinaria ===\n");

        Perro perro = new Perro("Bruno", 5, 10.5, "Labrador", true);
        Gato gato = new Gato("Cleo", 2, 4.3, "Blanco", true);
        Canario canario = new Canario("Pico", 1, 0.3, "Verde", true);

        System.out.println("-- Perro --");
        System.out.println(perro);
        perro.comer();
        perro.ladrar();
        perro.buscarPelota();

        System.out.println("\n-- Gato --");
        System.out.println(gato);
        gato.dormir();
        gato.maullar();
        gato.ronronear();

        System.out.println("\n-- Canario --");
        System.out.println(canario);
        canario.comer();
        canario.cantar();
        canario.volar();
    }
}
