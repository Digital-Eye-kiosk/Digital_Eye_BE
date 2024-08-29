package DigitalEye.demo.dto.request.both;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FinalChoiceRequestDto (
        @JsonProperty(value = "id") Long id,
        @JsonProperty(value = "train_table_id") Long train_table_id
){

}
