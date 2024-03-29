package software.hvb.blog.valuableendpointstests.users;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(SnakeCaseStrategy.class)
public record User (
        Long id,
        String firstName,
        String lastName
) {
    // empty by design
}
