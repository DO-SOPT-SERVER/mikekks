package secondSeminar.secondSeminar.dto.request.member;

import secondSeminar.secondSeminar.domain.enums.Part;


public record MemberProfileUpdateRequest (
        int generation,
        Part part
){}
