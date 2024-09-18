package com.example.callexternal.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EducationStatisticsResponse {
    String indicator;
    Long year;
    Double count;
}
