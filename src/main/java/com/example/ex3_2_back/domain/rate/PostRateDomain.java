package com.example.ex3_2_back.domain.rate;

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
    @Schema(defaultValue = "5")
    Float rating;
}
