package ar.edu.frc.utn.bda.alquilerDeBicicletas.entities;

import ar.edu.frc.utn.bda.alquilerDeBicicletas.support.LocalDateTimeConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ALQUILERES")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alquiler {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ALQUILERES")
    @TableGenerator(name = "ALQUILERES", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq",
            pkColumnValue="ALQUILERES",
            initialValue=1, allocationSize=1)
    private Integer id;

    @Column(name = "ID_CLIENTE")
    private String idCliente;

    @Column(name = "ESTADO")
    private Integer estado;

    @Column(name = "FECHA_HORA_RETIRO")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaHoraRetiro;

    @Column(name = "FECHA_HORA_DEVOLUCION")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime fechaHoraDevolucion;

    @Column(name = "MONTO")
    private Double monto;

    @ManyToOne
    @JoinColumn(name = "ESTACION_RETIRO", referencedColumnName = "ID")
    @Column(name = "ESTACION_RETIRO")
    private Estacion estacionRetiro;

    @ManyToOne
    @JoinColumn(name = "ESTACION_DEVOLUCION", referencedColumnName = "ID")
    @Column(name = "ESTACION_DEVOLUCION")
    private Estacion estacionDevolucion;

    @ManyToOne
    @JoinColumn(name = "ID_TARIFA", referencedColumnName = "ID")
    @Column(name = "ID_TARIFA")
    private Tarifa tarifa;
}
