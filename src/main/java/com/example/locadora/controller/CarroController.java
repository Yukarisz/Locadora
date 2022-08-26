package com.example.locadora.controller;

import com.example.locadora.dto.CarroDto;
import com.example.locadora.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CarroController {

    @Autowired
    CarroService carroService;


    @GetMapping("/carros")
    public List<CarroDto> getAllNotes() {
        return carroService.buscarCarros();
    }

    @PostMapping("/carros")
    public void createCarros(@Valid @RequestBody CarroDto carro) {
         carroService.salvarCarro(carro);
    }

    @GetMapping("/carros/{id}")
    public CarroDto getCarroById(@PathVariable(value = "id") Long carroId) {
        return carroService.buscarCarro(carroId);
    }
}
