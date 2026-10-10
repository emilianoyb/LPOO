public class Main {

    public static void main(String[] args) {

        System.out.println("---RPG - Sistema con Manejo de Excepciones---");

        Druida druida = new Druida("Sylva", 7, 200, 180, 100, "Lobo Feroz");
        Nigromante nigromante = new Nigromante("Malachar", 6, 200, 150, 8, 5);
        MotorCombate motor = new MotorCombate();

        // Escenario 1 — Turno normal sin excepción
        // (el daño de Sylva derrota a Malachar)
        motor.ejecutarTurno(druida, nigromante);

        // Escenario 2 — Personaje derrotado intenta atacar
        try {
            druida.recibirDanio(9999);   // primero derrota al druida
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        }
        motor.ejecutarTurno(druida, nigromante);  // captura PersonajeDerrotadoException

        // Escenario 3 — Arquero sin flechas
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);  // captura RecursoInsuficienteException

        // Escenario 4 — Curar aliado derrotado (Malachar ya fue derrotado en el escenario 1)
        System.out.println("\n-- Intento de curar aliado derrotado --");
        Druida druida2 = new Druida("Elowen", 5, 160, 120, 80, "Ciervo Antiguo");
        try {
            druida2.curarAliado(nigromante);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        // Escenario 5 — Daño negativo con finally
        System.out.println("\n-- Bloque manual try-catch-finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        // Extra — Excepción NO chequeada: PersonajeNuloException (error de programación)
        System.out.println("\n-- Extra: excepción no chequeada (null) --");
        try {
            druida2.curarAliado(null);
        } catch (PersonajeNuloException e) {
            System.out.println("Capturado: " + e.getMessage());
        } catch (RpgException e) {
            System.out.println("Error de juego: " + e.getMessage());
        }

        // Escenario 6 — Mostrar bitácora completa
        motor.mostrarBitacora();
    }
}
