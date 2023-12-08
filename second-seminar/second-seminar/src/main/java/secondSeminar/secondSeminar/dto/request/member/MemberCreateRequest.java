package secondSeminar.secondSeminar.dto.request.member;

import secondSeminar.secondSeminar.domain.SOPT;

public record MemberCreateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
){}