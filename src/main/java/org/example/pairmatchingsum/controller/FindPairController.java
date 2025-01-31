package org.example.pairmatchingsum.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.pairmatchingsum.dto.RequestDTO;
import org.example.pairmatchingsum.dto.ResponseDTO;
import org.example.pairmatchingsum.service.FindPairService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pairsum")
@RequiredArgsConstructor
public class FindPairController {

    private final FindPairService findPairService;

    @PostMapping("/")
    public ResponseEntity<ResponseDTO> findPairs(@Valid @RequestBody RequestDTO request) {
        return ResponseEntity.ok(findPairService.findPair(request));
    }
}
