package com.coda.stylestore.service.posts;


import com.coda.stylestore.domain.posts.Posts;
import com.coda.stylestore.domain.posts.PostsRepository;
import com.coda.stylestore.web.dto.PostsResponseDto;
import com.coda.stylestore.web.dto.PostsSaveRequestDto;
import com.coda.stylestore.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requeDto) {
        return postsRepository.save(requeDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalIdentifierException("해당게시글이 없습니다 id = " + id));

        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalIdentifierException("해당 게시글이 없습니다. id = "+ id));

        return new PostsResponseDto(entity);
    }
}
