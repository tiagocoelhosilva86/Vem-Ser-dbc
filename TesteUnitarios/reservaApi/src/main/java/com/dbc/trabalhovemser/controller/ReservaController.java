package com.dbc.trabalhovemser.controller;
import com.dbc.trabalhovemser.dto.HotelComReservaDTO;
import com.dbc.trabalhovemser.dto.ReservaCreateDTO;
import com.dbc.trabalhovemser.dto.ReservaDTO;
import com.dbc.trabalhovemser.dto.UsuarioComReservaDTO;
import com.dbc.trabalhovemser.exceptions.RegraDeNegocioException;
import com.dbc.trabalhovemser.service.ReservaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/reserva")
@RequiredArgsConstructor
@Slf4j
public class ReservaController {
    private final ReservaService reservaService;


    @ApiOperation(value = "Listar todas as reservas")
    @ApiResponses(value ={
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping
    public List<ReservaDTO> list(){
        return reservaService.list();
    }

    @ApiOperation(value = "Criar uma reserva")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Reserva criada com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PostMapping
    public ReservaDTO create(@Valid @RequestBody ReservaCreateDTO reservaCreateDTO) throws RegraDeNegocioException {
        log.info("Criando reserva");
        ReservaDTO reservaDTO = reservaService.create(reservaCreateDTO);
        log.info("Reserva criada");
        return reservaDTO;
    }

    @ApiOperation(value = "Deletar reserva")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Reserva deletada com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
@DeleteMapping("/{idReserva}")
    public void delete(@Valid @PathVariable("idReserva") Integer id) throws RegraDeNegocioException{
        log.info("Deletando reserva");
        reservaService.delete(id);
        log.info("Reserva deletada");
    }

    @ApiOperation(value = "Atualizar reserva")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Reserva atualizada com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @PutMapping("/{idReserva}")
    public ReservaDTO update(@Valid @PathVariable("idReserva") Integer id, @Valid @RequestBody ReservaCreateDTO reservaCreateDTO) throws RegraDeNegocioException {

        log.info("Atualizando reserva");
        ReservaDTO reservaDTO = reservaService.update(id, reservaCreateDTO);
        log.info("Atualizado com sucesso");

        return reservaDTO;
    }

    @ApiOperation(value = "Listar reserva por ID")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Reserva listada com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/{idReserva}")
    public ReservaDTO listById(@Valid @PathVariable("idReserva") Integer id) throws RegraDeNegocioException {
       return reservaService.getById(id);
    }

    @ApiOperation(value = "Listar reservas por ID do usuário")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = "Reservas listadas com sucesso"),
            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("/listar-por-usuario/{idUsuario}")
    public UsuarioComReservaDTO listarReservasPorUsuario(@Valid @PathVariable Integer idUsuario) throws RegraDeNegocioException{
        return reservaService.reservasPorUsuario(idUsuario);
    }

//    @ApiOperation(value = "Listar reservas por ID de hotel")
//    @ApiResponses(value ={
//            @ApiResponse(code = 200, message = "Reservas listadas com sucesso"),
//            @ApiResponse(code = 400, message = "Algum dado inconsistente"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
//    })
//    @GetMapping("/listar-por-hotel/{idHotel}")
//    public List<HotelComReservaDTO> listarReservasPorHotel(@Valid @PathVariable Integer idHotel) throws RegraDeNegocioException{
//        return reservaService.listReservasPorHotel(idHotel);
//    }



}
