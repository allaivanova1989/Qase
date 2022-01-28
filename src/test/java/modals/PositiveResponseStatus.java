package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositiveResponseStatus {
    boolean status;
    Result result;

}
