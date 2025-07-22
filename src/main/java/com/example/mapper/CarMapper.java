package com.example.mapper;

import com.example.config.MapperConfig;
import com.example.dto.CarDto;
import com.example.dto.CreateCarRequestDto;
import com.example.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface CarMapper {
    Car toModel(CreateCarRequestDto requestDto);

    CarDto toDto(Car car);

    void updateModel(CreateCarRequestDto requestDto, @MappingTarget Car car);

}
