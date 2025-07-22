package com.example.controller;

import com.example.dto.CarDto;
import com.example.dto.CreateCarRequestDto;
import com.example.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public CarDto createCar(@RequestBody CreateCarRequestDto requestDto) {
        return carService.save(requestDto);
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @GetMapping
    public Page<CarDto> getAllCars(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @PutMapping("/{id}")
    public CarDto update(@PathVariable Long id, @RequestBody CreateCarRequestDto requestDto) {
        return carService.updateCarById(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
