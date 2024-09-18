package com.example.callexternal.model.client.response;

import com.example.callexternal.model.client.dto.ClientResponseDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientResponse {
    List<ClientResponseDto> statDtos;
}
