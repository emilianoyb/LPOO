public class Main {

    public static void main(String[] args) {

        System.out.println("=== RPG — Demostración de Polimorfismo ===\n");

        // 3a — Variables de tipo padre (Personaje) apuntando a objetos hijo
        Personaje p1 = new Guerrero("Zoro", 5, 200, 95, "Cota de Malla");
        Personaje p2 = new Mago("Imu", 10, 150, 150, "Fuego");
        Personaje p3 = new Arquero("Ussop", 3, 150, "Arco Largo", 30, 95);

        // ---------------- calcularDanio() por tipo ----------------
        System.out.println("-- calcularDanio() por tipo --");
        System.out.println(p1.getNombre() + " (Guerrero) daño: " + p1.calcularDanio());
        System.out.println(p2.getNombre() + " (Mago)     daño: " + p2.calcularDanio());
        System.out.println(p3.getNombre() + " (Arquero)  daño: " + p3.calcularDanio());
        System.out.println();

        // 3b — Arreglo polimórfico: mismo tipo de referencia (Personaje),
        // pero cada llamada a atacar() ejecuta la versión sobreescrita real
        // según el objeto (despacho dinámico).
        Personaje[] equipo = { p1, p2, p3 };

        System.out.println("-- Arreglo polimórfico --");
        for (Personaje p : equipo) {
            p.atacar();
        }
        System.out.println();

        // 3c — GestorBatalla con las tres sobrecargas de ejecutarAtaque()
        System.out.println("-- GestorBatalla --");
        GestorBatalla gestor = new GestorBatalla();

        gestor.ejecutarAtaque(p1);            // versión 1: un solo atacante
        gestor.ejecutarAtaque(p2, p3);        // versión 2: atacante vs defensor
        gestor.ejecutarAtaque(equipo);        // versión 3: equipo completo
        System.out.println();

        gestor.mostrarHistorial();
        System.out.println();

        // 3d — instanceof para identificar el tipo real del objeto
        System.out.println("-- instanceof --");
        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero.");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago.");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero.");
            }
        }
        System.out.println();

        // Parte 4 — Demostración de la sobrecarga adicional: mostrarEstado()
        System.out.println("-- Sobrecarga adicional: mostrarEstado() --");
        p1.mostrarEstado();              // versión sin parámetros
        p1.mostrarEstado(true);          // versión con detalle completo (toString)
        p1.mostrarEstado(">>>");         // versión con prefijo personalizado
    }
}
