package thirdseminar.thirdseminar.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Withdraw {

    @Id
    @GeneratedValue
    private Long id;
    private String reason;


    private MemberId memberId; // @OneToOne, @JoinColumn 미사용
    private String memberName;
}
