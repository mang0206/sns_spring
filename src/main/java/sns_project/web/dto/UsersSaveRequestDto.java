package sns_project.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sns_project.domain.user.Users;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
    private String user_id;
    private String password;
    private String nickname;
    private String user_name;

    @Builder
    public UsersSaveRequestDto(String user_id,String password,String nickname,String user_name){
        this.user_id = user_id;
        this.password = password;
        this.nickname = nickname;
        this.user_name = user_name;
    }

    public Users toEntity() {
        return Users.builder()
                .user_id(user_id)
                .password(password)
                .nickname(nickname)
                .user_name(user_name)
                .build();
    }
}
