package sns_project.web;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sns_project.domain.user.Users;
import sns_project.domain.user.UsersRepository;
import sns_project.web.dto.UsersSaveRequestDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UsersRepository usersRepository;

    @After
    public void tearDown() throws Exception {
        usersRepository.deleteAll();
    }

    @Test
    public void users_insert() throws  Exception {
        String user_id = "Test_ID";
        String password = "Test_pw";
        String nickname = "Test_nick";
        String user_name = "Test_name";

        UsersSaveRequestDto requestDto = UsersSaveRequestDto.builder()
                .user_id(user_id)
                .password(password)
                .nickname(nickname)
                .user_name(user_name)
                .build();

        String url = "http://localhost:" + port + "/api/v1/users";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Users> all = usersRepository.findAll();
        assertThat(all.get(0).getUser_id()).isEqualTo(user_id);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
        assertThat(all.get(0).getNickname()).isEqualTo(nickname);
        assertThat(all.get(0).getUser_name()).isEqualTo(user_name);

    }
}
