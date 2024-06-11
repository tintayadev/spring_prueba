package com.example.demo.persistence.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "compras", schema = "public")
public class Compra {
    @Id
    @ColumnDefault("nextval('compras_id_compra_seq'::regclass)")
    @Column(name = "id_compra", nullable = false)
    private Integer idCompra;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente idCliente;

    @Column(name = "fecha")
    private Instant fecha;

    @Column(name = "medio_pago", length = Integer.MAX_VALUE)
    private String medioPago;

    @Column(name = "comentario", length = 300)
    private String comentario;

    @Column(name = "estado", length = Integer.MAX_VALUE)
    private String estado;


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Instant getFecha() {
        return fecha;
    }

    public void setFecha(Instant fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}