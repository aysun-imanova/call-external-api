package com.example.callexternal.controller;

import com.example.callexternal.model.response.EducationStatisticsResponse;
import com.example.callexternal.service.abstraction.EducationStatisticService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("v1/statistics")
public class EducationStatisticsController {
    EducationStatisticService service;

    @PostMapping()
    @ResponseStatus(CREATED)
    public void saveStatistics() {
        service.saveStatistics();
    }

    @GetMapping
    @ResponseStatus(OK)
    public List<EducationStatisticsResponse> getAllStatistics() {
        log.info("Received request to get all statistics");
        return service.getAllStatistics();

    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public EducationStatisticsResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteStatistics(@PathVariable Long id){
        service.deleteStatistics(id);
    }
}
