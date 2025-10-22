package biblioteca.com.demo.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "queja")
public class Queja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_cliente", length = 150)
    private String nombreCliente;

    @Column(length = 200)
    private String email;

    @Column(length = 30)
    private String telefono;

    @Column(name = "tipo", nullable = false)
@Enumerated(EnumType.STRING)
private TipoQueja tipo = TipoQueja.CONSULTA;


    @Column(length = 200)
    private String asunto;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    @Column(nullable = false)
    private Boolean tratado = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

  
    public Queja() {
    }

    
    public Queja(String nombreCliente, String email, String telefono, TipoQueja tipo, String asunto, String mensaje) {
        this.nombreCliente = nombreCliente;
        this.email = email;
        this.telefono = telefono;
        this.tipo = tipo;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoQueja getTipo() {
        return tipo;
    }

    public void setTipo(TipoQueja tipo) {
        this.tipo = tipo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Boolean getTratado() {
        return tratado;
    }

    public void setTratado(Boolean tratado) {
        this.tratado = tratado;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
