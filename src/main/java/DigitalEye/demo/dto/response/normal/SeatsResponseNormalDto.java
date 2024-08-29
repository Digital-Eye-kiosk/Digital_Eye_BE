package DigitalEye.demo.dto.response.normal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record SeatsResponseNormalDto(
        @JsonProperty("train_table_id")Long train_table_id
) implements Serializable {
    public static SeatsResponseNormalDto of(final Long train_table_id){
        return SeatsResponseNormalDto.builder().train_table_id(train_table_id).build();
    }
}
