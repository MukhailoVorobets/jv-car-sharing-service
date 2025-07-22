package com.example.dto;

import com.example.model.CarType;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CarDto {
    private Long id;
    private String model;
    private String brand;
    private CarType carType;
    private int inventory;
    private BigDecimal dailyFee;
}
