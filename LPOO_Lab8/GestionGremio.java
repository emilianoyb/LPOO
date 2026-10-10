import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class GestionGremio {

    private ArrayList<Personaje> roster;
    private LinkedList<String> colaTurnos;
    private HashMap<String, Integer> inventario;
    private HashSet<String> habilidades;

    public GestionGremio() {
        roster      = new ArrayList<>();
        colaTurnos  = new LinkedList<>();
        inventario  = new HashMap<>();
        habilidades = new HashSet<>();
    }

    // ──────────────────────────────────────────
    // SECCIÓN 1 — ArrayList: roster de personajes
    // ──────────────────────────────────────────

    public void agregarMiembro(Personaje p) {
        roster.add(p);
        System.out.println("[Gremio] " + p.getNombre() + " se unió al gremio.");
    }

    public void eliminarMiembro(String nombre) {
        Iterator<Personaje> it = roster.iterator();
        while (it.hasNext()) {
            Personaje p = it.next();
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                it.remove();   // forma segura de eliminar durante la iteración
                System.out.println("[Gremio] " + nombre + " abandonó el gremio.");
                return;
            }
        }
        System.out.println("[Gremio] No se encontró: " + nombre);
    }

    public Personaje buscarPorNombre(String nombre) {
        for (Personaje p : roster) {       // for-each
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public void mostrarRoster() {
        System.out.println("\n=== Roster del Gremio (" + roster.size() + " miembros) ===");

        // Ancho de la columna de nombres para alinear la tabla
        int anchoNombre = 0;
        for (Personaje p : roster) {
            anchoNombre = Math.max(anchoNombre, p.getNombre().length());
        }

        for (int i = 0; i < roster.size(); i++) {
            Personaje p = roster.get(i);
            System.out.println((i + 1) + ". " +
                    String.format("%-" + anchoNombre + "s", p.getNombre()) +
                    " | Nivel: " + String.format("%-2d", p.getNivel()) +
                    " | Vida: " + p.getPuntosVida());
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 2 — LinkedList: cola de turnos (FIFO)
    // ──────────────────────────────────────────

    public void encolarSolicitante(String nombre) {
        colaTurnos.addLast(nombre);    // agrega al final
        System.out.println("[Cola] " + nombre +
                           " en posición " + colaTurnos.size());
    }

    public String atenderSiguiente() {
        if (colaTurnos.isEmpty()) {
            System.out.println("[Cola] No hay solicitantes en espera.");
            return null;
        }
        String atendido = colaTurnos.removeFirst();   // saca del frente
        System.out.println("[Cola] Atendiendo a: " + atendido);
        return atendido;
    }

    public void mostrarCola() {
        System.out.println("\n=== Cola de Espera (" + colaTurnos.size() + ") ===");
        int pos = 1;
        for (String nombre : colaTurnos) {    // for-each sobre LinkedList
            System.out.println(pos++ + ". " + nombre);
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 3 — HashMap: inventario (nombre → cantidad)
    // ──────────────────────────────────────────

    public void agregarItem(String item, int cantidad) {
        boolean existia = inventario.containsKey(item);
        int total = inventario.getOrDefault(item, 0) + cantidad;
        inventario.put(item, total);

        if (existia) {
            System.out.println("[Inventario] " + item + ": " + total + "  (acumulada)");
        } else {
            System.out.println("[Inventario] " + item + ": " + total);
        }
    }

    public void usarItem(String item) {
        if (!inventario.containsKey(item)) {
            System.out.println("[Inventario] No existe en inventario: " + item);
            return;
        }

        int cantidad = inventario.get(item);
        if (cantidad > 0) {
            cantidad--;
            inventario.put(item, cantidad);
            System.out.println("[Inventario] " + item + " usada. Restante: " + cantidad);
        }

        if (cantidad == 0) {
            inventario.remove(item);
            System.out.println("[Inventario] " + item + " se agotó y se eliminó del inventario.");
        }
    }

    public void mostrarInventario() {
        System.out.println("\n=== Inventario del Gremio ===");
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
            System.out.println(String.format("%-16s", entry.getKey()) +
                               "> " + entry.getValue());
        }
    }

    // ──────────────────────────────────────────
    // SECCIÓN 4 — HashSet: habilidades únicas
    // ──────────────────────────────────────────

    public void registrarHabilidad(String habilidad) {
        boolean nueva = habilidades.add(habilidad);   // false si ya existía
        if (nueva) {
            System.out.println("[Habilidades] " + habilidad + " registrada.");
        } else {
            System.out.println("[Habilidades] " + habilidad + " ya estaba registrada.");
        }
    }

    public boolean tieneHabilidad(String habilidad) {
        return habilidades.contains(habilidad);
    }

    public void mostrarHabilidades() {
        System.out.println("\n=== Habilidades del Gremio ===");
        for (String habilidad : habilidades) {
            System.out.println("- " + habilidad);
        }
    }
}
