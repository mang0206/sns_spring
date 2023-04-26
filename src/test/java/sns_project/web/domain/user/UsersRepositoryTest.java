package sns_project.web.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sns_project.domain.user.Users;
import sns_project.domain.user.UsersRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersRepositoryTest {
    @Autowired
    UsersRepository usersRepository;

    @After
    public void cleanup() {
        usersRepository.deleteAll();
    }

    @Test
    public void user_test() {
        //given
        String user_id = "Test_ID";
        String password = "Test_pw";
        String nickname = "Test_nick";
        String user_name = "Test_name";

        usersRepository.save(Users.builder()
                        .user_id(user_id)
                        .password(password)
                        .nickname(nickname)
                        .user_name(user_name)
                        .build());

        List<Users> userList = usersRepository.findAll();

        Users users = userList.get(0);
        assertThat(users.getUser_id()).isEqualTo(user_id);
        assertThat(users.getPassword()).isEqualTo(password);
        assertThat(users.getNickname()).isEqualTo(nickname);
        assertThat(users.getUser_name()).isEqualTo(user_name);

    }

}
