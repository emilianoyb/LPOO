package com.tienda.model;

import java.math.BigDecimal;

// Datos que se muestran en las tarjetas del panel
public class ResumenInventario {

    private final long titulos;
    private final long unidades;
    private final BigDecimal valorInventario;
    private final long agotados;
    private final long pocoStock;

    public ResumenInventario(long titulos, long unidades,
                             BigDecimal valorInventario,
                             long agotados, long pocoStock) {
        this.titulos = titulos;
        this.unidades = unidades;
        this.valorInventario = valorInventario;
        this.agotados = agotados;
        this.pocoStock = pocoStock;
    }

    public long getTitulos()               { return titulos; }
    public long getUnidades()              { return unidades; }
    public BigDecimal getValorInventario() { return valorInventario; }
    public long getAgotados()              { return agotados; }
    public long getPocoStock()             { return pocoStock; }
}
