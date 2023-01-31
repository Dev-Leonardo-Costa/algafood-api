package com.algafood.api.controller;

import com.algafood.domain.service.VendaQueryService;
import com.algafood.dto.VendaDiariaDTO;
import com.algafood.filter.VendaDiariaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/estatisticas")
public class EstatisticasController {

    @Autowired
    private VendaQueryService vendaQueryService;

    @GetMapping("/vendas-diarias")
    public List<VendaDiariaDTO> consultarVendasDiarias(VendaDiariaFilter filtro){
        return  vendaQueryService.consultarVendasDiarias(filtro);
    }

}
