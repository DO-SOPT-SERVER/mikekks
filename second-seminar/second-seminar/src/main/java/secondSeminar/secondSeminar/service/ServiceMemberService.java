package secondSeminar.secondSeminar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secondSeminar.secondSeminar.domain.ServiceMember;
import secondSeminar.secondSeminar.dto.request.servicemember.ServiceMemberRequest;
import secondSeminar.secondSeminar.repository.ServiceMemberJpaRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ServiceMemberService {

    private final ServiceMemberJpaRepository serviceMemberJpaRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String create(ServiceMemberRequest request) {
        ServiceMember serviceMember = ServiceMember.builder()
                .nickname(request.nickname())
                .password(passwordEncoder.encode(request.password()))
                .build();
        serviceMemberJpaRepository.save(serviceMember);

        return serviceMember.getId().toString();
    }

    public void signIn(ServiceMemberRequest request) {
        ServiceMember serviceMember = serviceMemberJpaRepository.findByNickname(request.nickname())
                .orElseThrow(() -> new RuntimeException("해당하는 회원이 없습니다."));
        if (!passwordEncoder.matches(request.password(), serviceMember.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
    }

}
