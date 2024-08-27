package com.marcosespeche.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {

    private Long id;

    private String memberName;

    private Long memberNum;

    private Date memberSoftDeleteDate;
}
