package org.example.pairmatchingsum.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponseDTO {
    private List<int[]> pairs;
}
