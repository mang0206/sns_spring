package sns_project.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sns_project.service.users.UsersService;
import sns_project.web.dto.UsersSaveRequestDto;

import java.io.IOException;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

@RequiredArgsConstructor
//@RestController
@Controller
public class UsersApiController {

    private final UsersService usersService;

    @GetMapping(value = "/join")
    public String join(Model model){
        return "join";
    }

    @GetMapping(value = "/sineup")
    public String sineup(Model model){
        String name = "Test";
        model.addAttribute("name", name);
        return "sineup";
    }

    @PostMapping("/api/v1/users")
    public Long save(@RequestBody UsersSaveRequestDto requestDto) {
        return usersService.save(requestDto);
    }
}
