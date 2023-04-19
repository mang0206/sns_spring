package sns_project.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class testCotrollerDtoTest {

    @Test
    public void lombokTEst() {
        String name = "test";
        int amount = 1000;

        testControllerDto dto = new testControllerDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
