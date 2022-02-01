package modals;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class TestRun {
    private String runTitle;
    private String description;
    private String plan;
    private String environment;
    private String milestone;
    private String defaultAssignee;

}
