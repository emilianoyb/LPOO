package vehiculo;

public class Vehiculo {

    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadMax;

    public Vehiculo(String marca, String modelo, int anio, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadMax = velocidadMax;
    }

    // Sobrecarga de constructor: si no se conoce la velocidad máxima, se asume 0.0
    public Vehiculo(String marca, String modelo, int anio) {
        this(marca, modelo, anio, 0.0);
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    public void setAnio(int anio) {
        if (anio >= 1885 && anio <= 2100) {
            this.anio = anio;
        } else {
            System.out.println("Error: año no válido.");
        }
    }

    public void setVelocidadMax(double vel) {
        if (vel > 0) {
            this.velocidadMax = vel;
        } else {
            System.out.println("Error: velocidad máxima no válida.");
        }
    }

    // Sobrecarga: misma acción, pero acepta la velocidad como entero
    public void setVelocidadMax(int vel) {
        setVelocidadMax((double) vel);
    }

    public void describir() {
        System.out.println("Marca: " + marca + " | Modelo: " + modelo +
                " | Año: " + anio + " | Vel. Máx: " + velocidadMax + " km/h");
    }

    // Sobrecarga: permite imprimir un encabezado personalizado antes de describir()
    public void describir(String encabezado) {
        System.out.println(encabezado);
        describir();
    }

    @Override
    public String toString() {
        return String.format("Marca: %s | Modelo: %s | Año: %d | Vel. Máx: %.1f km/h",
                marca, modelo, anio, velocidadMax);
    }
}
