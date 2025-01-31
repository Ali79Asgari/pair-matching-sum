package org.example.pairmatchingsum.service;

import org.example.pairmatchingsum.dto.RequestDTO;
import org.example.pairmatchingsum.dto.ResponseDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FindPairServiceTest {

    @InjectMocks
    private FindPairServiceImpl findPairService;

    @Test
    @Order(1)
    public void findPairTest() {
        int targetNumber = 10;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        RequestDTO request = RequestDTO.builder()
                .targetNumber(targetNumber)
                .numbers(numbers)
                .build();

        ResponseDTO response = findPairService.findPair(request);

        List<int[]> pairs = Arrays.asList(
                new int[]{9, 1},
                new int[]{8, 2},
                new int[]{7, 3},
                new int[]{6, 4}
        );

        ResponseDTO exceptedResponse = ResponseDTO.builder()
                .pairs(pairs)
                .build();

        System.out.println(response);
        assertThat(response.getPairs()).containsExactlyInAnyOrderElementsOf(exceptedResponse.getPairs());
    }
}
