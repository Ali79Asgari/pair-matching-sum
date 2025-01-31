package org.example.pairmatchingsum.service;

import org.example.pairmatchingsum.dto.RequestDTO;
import org.example.pairmatchingsum.dto.ResponseDTO;

public interface FindPairService {
    ResponseDTO findPair(RequestDTO request);
}
