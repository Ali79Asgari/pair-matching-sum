package org.example.pairmatchingsum.service;

import org.example.pairmatchingsum.dto.RequestDTO;
import org.example.pairmatchingsum.dto.ResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FindPairServiceImpl implements FindPairService {

    @Override
    public ResponseDTO findPair(RequestDTO request) {
        List<int[]> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : request.getNumbers()) {
            int complement = request.getTargetNumber() - num;
            if (seen.contains(complement)) {
                result.add(new int[]{num, complement});
            }
            seen.add(num);
        }

        ResponseDTO response = ResponseDTO.builder()
                .pairs(result)
                .build();

        return response;
    }
}
