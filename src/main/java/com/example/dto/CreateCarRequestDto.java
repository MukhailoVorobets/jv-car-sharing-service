package com.example.dto;

import com.example.model.CarType;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateCarRequestDto {
    @NotBlank
    private String model;
    @NotBlank
    private String brand;
    @NotNull
    private CarType carType;
    @NotNull
    @Positive
    private int inventory;
    @NotNull
    @Positive
    @Digits(integer = 8, fraction = 2)
    private BigDecimal dailyFee;
}
