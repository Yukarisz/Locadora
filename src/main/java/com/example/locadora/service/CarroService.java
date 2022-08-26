package com.example.locadora.service;

import com.example.locadora.dto.CarroDto;
import com.example.locadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.locadora.model.Carro;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public CarroDto buscarCarro(long id){

        var carroEntity=carroRepository.findById(id).get();
        //.orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        return CarroDto.builder()
                .cor(carroEntity.getCor())
                .build();
    }
    public List<CarroDto> buscarCarros(){

        var carroEntity=carroRepository.findAll();
        List<CarroDto> carros = new ArrayList<>();
        carroEntity.forEach(carro -> {
           CarroDto carroDto =  CarroDto.builder()
                    .cor(carro.getCor())
                    .marca(carro.getMarca())
                    .placa(carro.getPlaca())
                   .id(carro.getId())
                    .modelo(carro.getModelo())
                    .build();
            carros.add(carroDto);
        });

        return carros;
    }
    public void salvarCarro(CarroDto carro){
        Carro carroEntity = Carro.builder()
                .cor(carro.getCor())
                .marca(carro.getMarca())
                .placa(carro.getPlaca())
                .modelo(carro.getModelo())
                .build();

        carroRepository.save(carroEntity);


    }

}
