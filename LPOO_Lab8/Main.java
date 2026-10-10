public class Main {

    public static void main(String[] args) {

        GestionGremio gremio = new GestionGremio();

        // ---------- Bloque 1 — ArrayList: roster ----------
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
        gremio.agregarMiembro(new Guerrero("Thorin", 9, 400, "Hacha", 80));
        gremio.mostrarRoster();

        System.out.println();
        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        System.out.println();
        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null)
            System.out.println("Encontrado: " + encontrado.getNombre());

        // ---------- Bloque 2 — LinkedList: cola de espera ----------
        System.out.println();
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();

        System.out.println();
        gremio.atenderSiguiente();   // atiende a Gandalf (FIFO)
        gremio.mostrarCola();

        // ---------- Bloque 3 — HashMap: inventario ----------
        System.out.println();
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);  // suma → 8

        gremio.mostrarInventario();

        System.out.println();
        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");    // no existe
        gremio.mostrarInventario();

        // ---------- Bloque 4 — HashSet: habilidades únicas ----------
        System.out.println();
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");    // duplicado — no se agrega

        gremio.mostrarHabilidades();

        System.out.println();
        System.out.println("¿Tiene tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación?      " + gremio.tieneHabilidad("Curación"));

        // ---------- Bloque 5 — Resumen del gremio ----------
        System.out.println("\n########## RESUMEN DEL GREMIO ##########");
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}
