package thirdseminar.thirdseminar.dto.request.member;

import thirdseminar.thirdseminar.domain.SOPT;

public record MemberCreateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
){}