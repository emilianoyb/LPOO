public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG — Expansión: Nuevas Clases ===\n");

        // 1) Intentar crear un Personaje "genérico" no compila, porque Personaje
        // es una clase abstracta (tiene métodos abstractos sin implementación).
        // La siguiente línea, si se descomenta, produce el error de compilación:
        // "Personaje is abstract; cannot be instantiated"
        // Personaje generico = new Personaje("Desconocido", 1, 100);

        System.out.println("-- Error esperado (línea comentada) --");
        System.out.println("// new Personaje(...) → error: Personaje is abstract; cannot be instantiated\n");

        // 2) Un objeto de cada tipo
        Druida druida = new Druida("Nami", 7, 200, 180, 100, "Lobo Feroz");
        Nigromante nigromante = new Nigromante("Gadito", 6, 180, 150, 8, 5);
        Bardo bardo = new Bardo("Conter", 5, 150, 70, "Laúd Encantado", 8);

        // 3) Polimorfismo con un arreglo Personaje[]
        Personaje[] equipo = { druida, nigromante, bardo };

        System.out.println("-- Ataques y daño (polimorfismo) --");
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Daño: " + p.calcularDanio());
        }
        System.out.println();

        // 4) instanceof para identificar quién puede hacer qué
        System.out.println("-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje p : equipo) {
            if (p instanceof Hechicero h) {
                h.lanzarHechizo();
            }
        }
        System.out.println();

        System.out.println("-- Solo los Sanadores curan (a Gadito, con vida completa) --");
        for (Personaje p : equipo) {
            if (p instanceof Sanador s) {
                s.curarAliado(nigromante);
            }
        }
        System.out.println();

        // 5) Demostración explícita de curación: se daña al Nigromante y luego
        // se le cura con el Druida y con el Bardo.
        System.out.println("-- Demostración de curación tras recibir daño --");
        nigromante.recibirDanio(300);
        druida.curarAliado(nigromante);
        bardo.curarAliado(nigromante);
        System.out.println();

        System.out.println("-- Estado final --");
        for (Personaje p : equipo) {
            System.out.println(p);
        }
    }
}
