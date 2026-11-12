package com.tienda.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
public class Videojuego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "Máximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "Selecciona una plataforma")
    private String plataforma;

    @NotBlank(message = "Selecciona un género")
    private String genero;

    @NotBlank(message = "Selecciona una clasificación")
    private String clasificacion;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Digits(integer = 6, fraction = 2,
            message = "Máximo 6 enteros y 2 decimales")
    @Column(precision = 8, scale = 2)
    private BigDecimal precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Max(value = 100000, message = "Stock demasiado grande")
    private Integer stock;

    @NotNull(message = "El año es obligatorio")
    @Min(value = 1970, message = "Año no válido")
    @Max(value = 2100, message = "Año no válido")
    private Integer anioLanzamiento;

    // Constructor vacío (requerido por JPA)
    public Videojuego() {}

    public Videojuego(String titulo, String plataforma, String genero,
                      String clasificacion, BigDecimal precio,
                      Integer stock, Integer anioLanzamiento) {
        this.titulo = titulo;
        this.plataforma = plataforma;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.stock = stock;
        this.anioLanzamiento = anioLanzamiento;
    }

    public Long getId()                { return id; }
    public String getTitulo()          { return titulo; }
    public String getPlataforma()      { return plataforma; }
    public String getGenero()          { return genero; }
    public String getClasificacion()   { return clasificacion; }
    public BigDecimal getPrecio()      { return precio; }
    public Integer getStock()          { return stock; }
    public Integer getAnioLanzamiento() { return anioLanzamiento; }

    public void setId(Long id)                   { this.id = id; }
    public void setTitulo(String titulo)         { this.titulo = titulo; }
    public void setPlataforma(String p)          { this.plataforma = p; }
    public void setGenero(String genero)         { this.genero = genero; }
    public void setClasificacion(String c)       { this.clasificacion = c; }
    public void setPrecio(BigDecimal precio)     { this.precio = precio; }
    public void setStock(Integer stock)          { this.stock = stock; }
    public void setAnioLanzamiento(Integer a)    { this.anioLanzamiento = a; }
}
