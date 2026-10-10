import java.util.ArrayList;

public class GestorBatalla {

    private ArrayList<String> historial = new ArrayList<>();

    // Versión 1: un solo atacante, sin oponente definido
    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();
        atacante.atacar();

        System.out.println("[BATALLA] " + atacante.getNombre() + " ataca solo → daño: " + danio);

        historial.add((historial.size() + 1) + ". " + atacante.getNombre() +
                " atacó solo (daño: " + danio + ")");
    }

    // Versión 2: atacante contra un defensor específico
    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        atacante.atacar();

        System.out.println("[BATALLA] " + atacante.getNombre() + " ataca a " +
                defensor.getNombre() + " → daño: " + danio);

        defensor.recibirDanio(danio);
        defensor.defender();

        String resultado = defensor.isEstaVivo() ? "" : " - " + defensor.getNombre() + " derrotado";

        historial.add((historial.size() + 1) + ". " + atacante.getNombre() + " atacó a " +
                defensor.getNombre() + " (daño: " + danio + ")" + resultado);
    }

    // Versión 3: todo un equipo ataca a la vez
    public void ejecutarAtaque(Personaje[] equipo) {
        System.out.println("[BATALLA] Equipo completo ataca → " + equipo.length + " personajes");

        StringBuilder nombres = new StringBuilder();
        for (int i = 0; i < equipo.length; i++) {
            Personaje p = equipo[i];
            p.calcularDanio();
            p.atacar();
            nombres.append(p.getNombre());
            if (i < equipo.length - 1) {
                nombres.append(", ");
            }
        }

        historial.add((historial.size() + 1) + ". Ataque en equipo: " + nombres);
    }

    public void mostrarHistorial() {
        System.out.println("-- Historial --");
        for (String evento : historial) {
            System.out.println(evento);
        }
    }

    public void limpiarHistorial() {
        historial.clear();
    }
}
