package secondSeminar.secondSeminar.domain;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ServiceMember {

    @Id
    @GeneratedValue
    private Long id;

    private String nickname;
    private String password;

    @Builder
    public ServiceMember(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
}
