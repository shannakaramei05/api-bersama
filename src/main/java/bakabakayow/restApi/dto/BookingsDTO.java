package bakabakayow.restApi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingsDTO {
    private Long userId;
    private String fieldName;
    private LocalDateTime playDateStart;
    private LocalDateTime playDateEnd;
}
