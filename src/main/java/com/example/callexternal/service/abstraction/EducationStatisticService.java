package com.example.callexternal.service.abstraction;

import com.example.callexternal.model.response.EducationStatisticsResponse;

import java.util.List;

public interface EducationStatisticService {
    void saveStatistics();

    List<EducationStatisticsResponse> getAllStatistics();

    EducationStatisticsResponse getById(Long id);

    void deleteStatistics(Long id);
}
