package secondseminar.secondseminar.dto.request;

import secondseminar.secondseminar.domain.SOPT;

public record MemberCreateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
){}