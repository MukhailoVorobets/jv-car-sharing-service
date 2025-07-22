package com.example.service;

import com.example.dto.CarDto;
import com.example.dto.CreateCarRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    CarDto save(CreateCarRequestDto requestDto);

    Page<CarDto> findAll(Pageable pageable);

    CarDto getCarById(Long id);

    CarDto updateCarById(Long id, CreateCarRequestDto requestDto);

    void deleteById(Long id);
}
