package com.example.ex3_2_back.domain.rate;

import com.example.ex3_2_back.entity.Rate;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Schema(description = "PostRateDomain")
public class PostRateDomain {
    Float rating;
}
