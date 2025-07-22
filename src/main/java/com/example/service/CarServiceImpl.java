package com.example.service;

import com.example.dto.CarDto;
import com.example.dto.CreateCarRequestDto;
import com.example.mapper.CarMapper;
import com.example.model.Car;
import com.example.repository.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository repository;
    private final CarMapper carMapper;

    @Override
    public CarDto save(CreateCarRequestDto requestDto) {
        Car saveCar = repository.save(carMapper.toModel(requestDto));
        return carMapper.toDto(saveCar);
    }

    @Override
    public Page<CarDto> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(carMapper::toDto);
    }

    @Override
    public CarDto getCarById(Long id) {
        Car carFromDb = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Car not found with id:" + id));
        return carMapper.toDto(carFromDb);
    }

    @Override
    public CarDto updateCarById(Long id, CreateCarRequestDto requestDto) {
        Car carFromDb = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Car not found with id:" + id));
        carMapper.updateModel(requestDto, carFromDb);
        return carMapper.toDto(repository.save(carFromDb));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
