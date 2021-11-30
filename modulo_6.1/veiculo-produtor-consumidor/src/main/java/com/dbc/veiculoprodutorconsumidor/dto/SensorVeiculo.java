package com.dbc.veiculoprodutorconsumidor.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "sensor-veiculo")
public class SensorVeiculo {


    @ApiModelProperty(value = "Data da leitura")
    private LocalDateTime dataLeitura;

    @ApiModelProperty(value = "velocidade")
    private Double velociDade;

    @ApiModelProperty(value = "Rotação")
    private Integer rotacao;

    @ApiModelProperty(value = "sensor frenagem")
    private  Boolean sensorFrenagem;


}
