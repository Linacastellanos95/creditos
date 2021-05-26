package ar.com.ada.creditos.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

    @Entity
    @Table(name = "prestamo")
public class Prestamo {

    @Id
    @Column (name = "prestamo_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamoId;

    private BigDecimal importe;

    private int cuotas;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column (name = "fecha_alta")
    private Date fechaAlta;
    
    // de muchos a 1 --> Significa que cada cliente puede tener muchos prestamos
    @ManyToOne
    @JoinColumn(name = "cliente_id",referencedColumnName = "cliente_id") 
    private Cliente cliente;

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.cliente.agregarPrestamo(this); // Relación bidireccional
    }

    
}
