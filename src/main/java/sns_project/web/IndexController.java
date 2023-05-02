package sns_project.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

//    페딩 템플릿 사용 test 함수
    @GetMapping(value = "/signup")
    public String signup(Model model){
        String name = "Test";
        model.addAttribute("name", name);
        return "signup";
    }

//    회원가입 페이지
    @GetMapping(value = "/join")
    public String join(Model model){
        return "join";
    }
}
