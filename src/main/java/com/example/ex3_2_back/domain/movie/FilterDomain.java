package com.example.ex3_2_back.domain.movie;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FilterDomain {
    final List<String> tags = new ArrayList<>();
}
