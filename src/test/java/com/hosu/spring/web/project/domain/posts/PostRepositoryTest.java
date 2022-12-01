package com.hosu.spring.web.project.domain.posts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;



    @Test
    @DisplayName("게시글저장 - 불러오기")
    public void loadBoard(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 - 본문";

        postRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .author("hojune0904@gmail.com")
                .build());
        //when
        List<Posts> postsList = postRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_add()    {
        LocalDateTime now = LocalDateTime.of(2022,11,30,0,0,0);
        postRepository.save(Posts.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                .build());

        List<Posts> postsList = postRepository.findAll();

        Posts posts = postsList.get(0);

        System.out.println("createDate : " + posts.getCreatedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}