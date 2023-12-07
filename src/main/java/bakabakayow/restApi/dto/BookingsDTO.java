package bakabakayow.restApi.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingsDTO {
    private LocalDateTime playDateStart;
    private LocalDateTime playDateEnd;
    private Long userId;
    private String fieldName;
}
