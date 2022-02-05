package modals;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {
    String title;
    String description;
    String preconditions;
    int parent_id;
}
