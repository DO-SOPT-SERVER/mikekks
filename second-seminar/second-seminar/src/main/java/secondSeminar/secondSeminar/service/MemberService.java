package secondSeminar.secondSeminar.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import secondSeminar.secondSeminar.domain.Member;
import secondSeminar.secondSeminar.domain.SOPT;
import secondSeminar.secondSeminar.dto.request.member.MemberCreateRequest;
import secondSeminar.secondSeminar.dto.request.member.MemberProfileUpdateRequest;
import secondSeminar.secondSeminar.dto.response.MemberGetResponse;
import secondSeminar.secondSeminar.exception.ErrorMessage;
import secondSeminar.secondSeminar.repository.MemberJpaRepository;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getMemberByIdV1(Long id) {
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getMemberByIdV2(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.MEMBER_NOT_FOUND_EXCEPTION.getMessage())));
    }

    public MemberGetResponse getMemberByIdV3(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public String create(MemberCreateRequest request) {
        Member member =  memberJpaRepository.save(Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.generation(), request.part()));
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }

    public MemberGetResponse getByIdV2(Long memberId) {
        return MemberGetResponse.of(findById(memberId));
    }


    public Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException(ErrorMessage.MEMBER_NOT_FOUND_EXCEPTION.getMessage())
        );
    }

}