package org.example.pairmatchingsum.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestDTO {
    @NotNull(message = "TargetNumber cannot be null!")
    private int targetNumber;

    @NotEmpty(message = "The numbers list cannot be empty!")
    @Size(min = 2, message = "The numbers list must contain at least two elements")
    private List<Integer> numbers;
}
