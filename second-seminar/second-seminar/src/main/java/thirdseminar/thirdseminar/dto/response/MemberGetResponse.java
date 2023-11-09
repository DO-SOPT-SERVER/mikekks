package thirdseminar.thirdseminar.dto.response;

import thirdseminar.thirdseminar.domain.Member;
import thirdseminar.thirdseminar.domain.SOPT;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}