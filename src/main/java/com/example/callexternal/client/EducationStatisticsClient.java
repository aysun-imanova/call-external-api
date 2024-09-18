package com.example.callexternal.client;

import com.example.callexternal.client.decoder.CustomErrorDecoder;
import com.example.callexternal.model.client.response.ClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "education-statistics",
        url = "${client.urls.education-statistics}",
        configuration = CustomErrorDecoder.class)
public interface EducationStatisticsClient {

    @GetMapping("/v2/az/json/statistics/education/correspondingInstitutions")
    ClientResponse getEducationStatistics();
}
