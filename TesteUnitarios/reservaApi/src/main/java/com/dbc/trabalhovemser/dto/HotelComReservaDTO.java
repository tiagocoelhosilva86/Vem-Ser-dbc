package com.dbc.trabalhovemser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class HotelComReservaDTO extends HoteisDTO {

    private List<ReservaSemHotelDTO> reservas;
}
