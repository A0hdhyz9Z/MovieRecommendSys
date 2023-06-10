package com.example.ex3_2_back.domain.movie;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description ="FilterDomain" )
public class FilterDomain {
    String message;
    final List<String> tags = new ArrayList<>();
    final List<String> genres = new ArrayList<>();
}
