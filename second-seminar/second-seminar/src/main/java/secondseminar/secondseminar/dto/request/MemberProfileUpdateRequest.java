package secondseminar.secondseminar.dto.request;

import secondseminar.secondseminar.domain.enums.Part;


public record MemberProfileUpdateRequest (
        int generation,
        Part part
){}
