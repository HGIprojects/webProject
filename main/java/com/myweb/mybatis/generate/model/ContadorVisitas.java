package com.myweb.mybatis.generate.model;

import jakarta.annotation.Generated;
import java.io.Serializable;
import java.time.LocalDateTime;

public class ContadorVisitas implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String pais;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private LocalDateTime fecha;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String ip;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Boolean clicked;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPais() {
        return pais;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPais(String pais) {
        this.pais = pais == null ? null : pais.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public LocalDateTime getFecha() {
        return fecha;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIp() {
        return ip;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Boolean getClicked() {
        return clicked;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setClicked(Boolean clicked) {
        this.clicked = clicked;
    }
}