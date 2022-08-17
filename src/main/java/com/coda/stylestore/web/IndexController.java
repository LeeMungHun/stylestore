package com.coda.stylestore.web;

import com.coda.stylestore.config.auth.LoginUser;
import com.coda.stylestore.config.auth.dto.SessionUser;
import com.coda.stylestore.service.posts.PostsService;
import com.coda.stylestore.web.dto.PostsResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());
        // CustomOAuth2UserService 로그인 성공시 SessionUser를 세션에 저장 -> @LoginUser 어노테이션화
//        SessionUser user = (SessionUser) httpSession
//                .getAttribute("user");

        if (user != null) {
            model.addAttribute("user_name", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
