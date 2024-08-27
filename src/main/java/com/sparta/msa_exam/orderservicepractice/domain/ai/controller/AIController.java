package com.sparta.msa_exam.orderservicepractice.domain.ai.controller;

import com.sparta.msa_exam.orderservicepractice.domain.ai.domain.AI;
import com.sparta.msa_exam.orderservicepractice.domain.ai.dto.AIRecordDto;
import com.sparta.msa_exam.orderservicepractice.domain.ai.dto.AIRequestDto;
import com.sparta.msa_exam.orderservicepractice.domain.ai.dto.AIResponseDto;
import com.sparta.msa_exam.orderservicepractice.domain.ai.service.AIService;
import com.sparta.msa_exam.orderservicepractice.global.base.dto.ResponseBody;
import com.sparta.msa_exam.orderservicepractice.global.base.dto.ResponseUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ai")
public class AIController {

    private final AIService aiService;

    @PostMapping("/request")
    public ResponseEntity<ResponseBody<AIResponseDto>> AIRequest(@RequestBody AIRequestDto aiRequestDto) {
        // TODO. 권한 체크, 예외 처리
        String message = aiService.getAIRequest(aiRequestDto.getRequest());
        AIResponseDto aiResponseDto = new AIResponseDto(message);
        return ResponseEntity.ok(ResponseUtil.createSuccessResponse(aiResponseDto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseBody<List<AIRecordDto>>> getMyAIRecord(@PathVariable("userId") Long userId) {
        // TODO. 권한 체크, 예외 처리
        List<AI> records = aiService.getMyAIRecord(userId);
        List<AIRecordDto> aiRecords = records.stream()
                .map(ai -> new AIRecordDto(ai.getRequest(), ai.getResponse()))
                .toList();
        return ResponseEntity.ok(ResponseUtil.createSuccessResponse(aiRecords));
    }
}
