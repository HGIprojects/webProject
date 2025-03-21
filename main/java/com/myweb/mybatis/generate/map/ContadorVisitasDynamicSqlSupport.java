package com.myweb.mybatis.generate.map;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ContadorVisitasDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ContadorVisitas contadorVisitas = new ContadorVisitas();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = contadorVisitas.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> pais = contadorVisitas.pais;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> fecha = contadorVisitas.fecha;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> ip = contadorVisitas.ip;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> clicked = contadorVisitas.clicked;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ContadorVisitas extends AliasableSqlTable<ContadorVisitas> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> pais = column("pais", JDBCType.VARCHAR);

        public final SqlColumn<LocalDateTime> fecha = column("fecha", JDBCType.TIMESTAMP);

        public final SqlColumn<String> ip = column("ip", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> clicked = column("clicked", JDBCType.BIT);

        public ContadorVisitas() {
            super("contador_visitas", ContadorVisitas::new);
        }
    }
}