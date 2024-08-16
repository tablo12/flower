package com.flower.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberUpdateDto {


    private Long mno;

    @NotBlank(message = "Id는 필수 입력 값입니다.")
    private String mid;

    @NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요")
    private String mpw;

    private String mphone;

    @NotBlank(message = "이름은 필수 입력 값입니다.")
    private String mname;

    @NotEmpty(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해주세요.")
    private String memail;

    private String mbirth;

}