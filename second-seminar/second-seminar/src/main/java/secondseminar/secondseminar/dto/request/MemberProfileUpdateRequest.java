package secondseminar.secondseminar.dto.request;

import lombok.Data;
import secondseminar.secondseminar.domain.enums.Part;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
