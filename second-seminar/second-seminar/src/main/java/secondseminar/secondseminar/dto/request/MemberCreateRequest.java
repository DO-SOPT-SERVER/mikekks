package secondseminar.secondseminar.dto.request;

import lombok.Data;
import secondseminar.secondseminar.domain.SOPT;

@Data
public class MemberCreateRequest {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}