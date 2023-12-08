package thirdseminar.thirdseminar.domain;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Embeddable
@Getter
@EqualsAndHashCode
public class CategoryId implements Serializable {
    private String categoryId;
}
