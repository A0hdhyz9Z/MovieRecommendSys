package com.example.ex3_2_back.domain.movie;

import com.example.ex3_2_back.entity.Movie;
import com.example.ex3_2_back.entity.TagHub;
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
@Schema(description = "SearchDomain")
public class SearchDomain {
    @Schema(defaultValue = "Cat")
    String movieName;
}
