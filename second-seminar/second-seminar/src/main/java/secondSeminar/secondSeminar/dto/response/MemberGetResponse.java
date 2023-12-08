package secondSeminar.secondSeminar.dto.response;

import secondSeminar.secondSeminar.domain.Member;
import secondSeminar.secondSeminar.domain.SOPT;

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