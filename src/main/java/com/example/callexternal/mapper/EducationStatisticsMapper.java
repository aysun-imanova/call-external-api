package com.example.callexternal.mapper;

import com.example.callexternal.dao.entity.EducationStatisticsEntity;
import com.example.callexternal.model.client.dto.ClientResponseDto;
import com.example.callexternal.model.response.EducationStatisticsResponse;

public enum EducationStatisticsMapper {
    EDUCATION_STATISTIC_MAPPER;
    public EducationStatisticsEntity toEntity(ClientResponseDto client){
        return EducationStatisticsEntity.builder()
                .indicator(client.getIndicator())
                .year(client.getYear())
                .count(client.getCount())
                .build();
    }

    public EducationStatisticsResponse toStatisticsResponse(EducationStatisticsEntity entity) {
        return EducationStatisticsResponse.builder()
                .indicator(entity.getIndicator())
                .year(entity.getYear())
                .count(entity.getCount())
                .build();
    }


}
