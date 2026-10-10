public interface Sanador {
    // Ahora declara RpgException porque curar puede fallar (aliado nulo o derrotado)
    void curarAliado(Personaje aliado) throws RpgException;
    int getPoderCuracion();
}
