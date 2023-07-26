package bootcamp2306_av.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

//POJO -> plain old java object
//DTO -> data transfer object
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestAppErrorResponse {
    private String errorMessage;
    private String errorCode;
    private Integer httpStatus;
    private String httpMessage;
    private Instant time;
}
