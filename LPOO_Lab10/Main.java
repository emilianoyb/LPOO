public class Main {

    // Con 1000 incrementos los hilos casi nunca compiten;
    // con 100000 la race condition se nota.
    private static final int HILOS = 5;
    private static final int INCREMENTOS = 100000;

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("=== Gran Torneo del Gremio ===\n");

        // === Bloque 1: torneo con 3 combates simultáneos ===
        TablaResultados tabla = new TablaResultados();

        Personaje s1 = new Druida("Sylva", 10, 300, 100);
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120);
        Personaje l1 = new Arquero("Legolas", 6, 200,
                                   "Arco", 10, 95);
        Personaje t1 = new Guerrero("Thorin", 9, 400,
                                    "Hacha", 80);
        Personaje b1 = new Druida("Brego", 7, 250, 80);
        Personaje k1 = new Nigromante("Kael", 5, 180, 90);

        // Crear los Runnable
        CombateConcurrente c1 =
            new CombateConcurrente("Campo-1", s1, m1, tabla);
        CombateConcurrente c2 =
            new CombateConcurrente("Campo-2", l1, t1, tabla);
        CombateConcurrente c3 =
            new CombateConcurrente("Campo-3", b1, k1, tabla);

        // Envolver en Thread e iniciar
        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);

        h1.start();
        h2.start();
        h3.start();

        // === Bloque 2: monitor del torneo (hilo propio) ===
        MonitorTorneo monitor =
            new MonitorTorneo("Torneo Principal", 3);
        monitor.start();

        // === Bloque 3: esperar a que todos terminen ===
        try {
            h1.join();   // espera a que Campo-1 termine
            h2.join();   // espera a que Campo-2 termine
            h3.join();   // espera a que Campo-3 termine
            monitor.join();
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
        }

        System.out.println(
            "\nTodos los combates han terminado.");
        tabla.mostrarResultados();

        // === Bloque 4: demostración de race condition ===
        System.out.println("\n=== Race condition ===");
        ContadorCompartido contador = new ContadorCompartido();

        // Sin synchronized — resultado incorrecto
        Thread[] hilos = new Thread[HILOS];
        for (int i = 0; i < HILOS; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTOS; j++) {
                    contador.incrementar();
                }
            });
            hilos[i].start();
        }
        for (Thread t : hilos) t.join();
        System.out.println("Sin sync  - esperado: " +
                           (HILOS * INCREMENTOS) +
                           " | real: " +
                           contador.getContador());

        // Con synchronized — resultado correcto
        contador.resetear();
        for (int i = 0; i < HILOS; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTOS; j++) {
                    contador.incrementarSeguro();
                }
            });
            hilos[i].start();
        }
        for (Thread t : hilos) t.join();
        System.out.println("Con sync  - esperado: " +
                           (HILOS * INCREMENTOS) +
                           " | real: " +
                           contador.getContador());
    }
} 