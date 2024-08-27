package com.marcosespeche.mappers;

import com.marcosespeche.dtos.MemberDTO;
import com.marcosespeche.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MemberMapperImpl.class)
class MemberMapperTest {

    @Autowired
    private MemberMapper mapper;

    @Test
    public void mapToDTOTest() {

        Member member = Member.builder()
                .memberNum(1L)
                .memberName("Marcos Espeche")
                .memberSoftDeleteDate(null)
                .build();

        member.setId(0L);

        MemberDTO dto = mapper.memberToMemberDTO(member);

        assertEquals(member.getId(), dto.getId());
        assertEquals((member.getMemberNum()), dto.getMemberNum());
        assertEquals(member.getMemberName(), dto.getMemberName());
        assertEquals(member.getMemberSoftDeleteDate(), dto.getMemberSoftDeleteDate());
    }

    @Test
    public void mapToMemberTest() {

        MemberDTO dto = MemberDTO.builder()
                .memberNum(1L)
                .id(null)
                .memberName("Marcos Espeche")
                .memberSoftDeleteDate(null)
                .build();

        Member member = mapper.memberDTOToMember(dto);

        // @Builder annotation do not generate builder method for inherited attributes
        // So id builder method do not exist, that's why the test fail for that field
        assertEquals(member.getId(), dto.getId());
        assertEquals((member.getMemberNum()), dto.getMemberNum());
        assertEquals(member.getMemberName(), dto.getMemberName());
        assertEquals(member.getMemberSoftDeleteDate(), dto.getMemberSoftDeleteDate());

    }
}