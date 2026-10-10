public class Personaje implements Combatiente {

    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void recibirDanio(int danio) {
        puntosVida -= danio;

        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }

        System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);

        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    // Método base de daño: será sobreescrito por cada subclase (polimorfismo)
    public int calcularDanio() {
        return nivel * 10;
    }

    @Override
    public void atacar() {
        System.out.println("[" + nombre + "] ataca con un golpe básico.");
    }

    @Override
    public void defender() {
        System.out.println("[" + nombre + "] se pone en guardia.");
    }

    // ---------- Sobrecarga adicional (Parte 4): mostrarEstado() ----------

    // Versión 1: información básica
    public void mostrarEstado() {
        System.out.println(nombre + " - Nivel " + nivel + " - Vida: " + puntosVida);
    }

    // Versión 2: información completa (usa toString())
    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println(toString());
        } else {
            mostrarEstado();
        }
    }

    // Versión 3: con un prefijo/formato personalizado
    public void mostrarEstado(String prefijo) {
        System.out.println(prefijo + " " + nombre + " (Nivel " + nivel + ", Vida " + puntosVida + ")");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Nivel: " + nivel + " | Vida: " + puntosVida +
                " | Vivo: " + (estaVivo ? "Sí" : "No");
    }
}
