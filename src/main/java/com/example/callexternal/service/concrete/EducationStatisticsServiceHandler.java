package com.example.callexternal.service.concrete;

import com.example.callexternal.client.EducationStatisticsClient;
import com.example.callexternal.dao.entity.EducationStatisticsEntity;
import com.example.callexternal.dao.repository.EducationStatisticsRepository;
import com.example.callexternal.exception.NotFoundException;
import com.example.callexternal.model.client.response.ClientResponse;
import com.example.callexternal.model.response.EducationStatisticsResponse;
import com.example.callexternal.service.abstraction.EducationStatisticService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.callexternal.exception.ErrorMessage.STATISTICS_NOT_FOUND_EXCEPTION;
import static com.example.callexternal.mapper.EducationStatisticsMapper.EDUCATION_STATISTIC_MAPPER;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EducationStatisticsServiceHandler implements EducationStatisticService {


    EducationStatisticsRepository repository;
    EducationStatisticsClient client;

    @Override
    public void saveStatistics() {
        var clientResponse = client.getEducationStatistics();

        Optional.ofNullable(clientResponse)
                .map(ClientResponse::getStatDtos)
                .ifPresentOrElse(statDtos -> {
                            repository.saveAll(statDtos.stream()
                                    .map(EDUCATION_STATISTIC_MAPPER::toEntity)
                                    .toList());

                            log.info("Statistics DTOs successfully save to the db...");
                        },
                        () -> log.warn("No data received from the API."));
    }

//    @Override
//    public void saveStatistics() {
//        var clientResponse = client.getEducationStatistics();
//
//        Optional.ofNullable(clientResponse)
//                .map(ClientResponse::getStatDtos)
//                .ifPresentOrElse(statDtos -> {
//                            repository.saveAll(statDtos.stream()
//                                    .map(EDUCATION_STATISTIC_MAPPER::toEntity)
//                                    .toList());
//
//                            log.info("Statistics DTOs successfully save to the db...");
//                        },
//                        () -> log.warn("No data received from the API."));
//    }

    @Override
    public List<EducationStatisticsResponse> getAllStatistics() {
        log.info("Fetching all statistics from db");
        return repository.findAll()
                .stream()
                .map(EDUCATION_STATISTIC_MAPPER::toStatisticsResponse)
                .toList();
    }
    @Override
    public EducationStatisticsResponse getById(Long id) {
       log.info("Fetching statistics with ID {} ", id);
       return EDUCATION_STATISTIC_MAPPER.toStatisticsResponse(fetchIfExist(id));
    }

    @Override
    public void deleteStatistics(Long id) {
        log.info("Deleting statistics with ID {} ", id);
        repository.deleteById(id);

    }

    EducationStatisticsEntity fetchIfExist(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(STATISTICS_NOT_FOUND_EXCEPTION.getMessage(), STATISTICS_NOT_FOUND_EXCEPTION.getCode()));
    }
}
