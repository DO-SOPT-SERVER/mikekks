package thirdseminar.thirdseminar.dto.request.member;

import thirdseminar.thirdseminar.domain.enums.Part;


public record MemberProfileUpdateRequest (
        int generation,
        Part part
){}
