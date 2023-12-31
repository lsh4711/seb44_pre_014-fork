package com.server.tag.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.tag.entity.Tag;
import com.server.tag.mapper.TagMapper;
import com.server.tag.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {
    private TagService tagService;
    private TagMapper tagMapper;

    public TagController(TagService tagService,
            TagMapper tagrapper) {
        this.tagService = tagService;
        this.tagMapper = tagrapper;
    }

    @GetMapping("/search")
    public ResponseEntity getTagsByTagName(@RequestParam("tagName") String tagName) {
        List<Tag> tags = tagService.findAllByTagName(tagName);
        List<String> tagNames = tagMapper.tagsToTagNames(tags);

        return new ResponseEntity<>(tagNames, HttpStatus.OK);
    }

    // @GetMapping
    // public String redirect() {
    //     // return "redirect:{리다이렉트할 주소}";
    //     // return "redirect:https://{도메인 및 포트}/{경로(path)}?{쿼리도 가능}"; 
    //     return "redirect:https"; // 예시
    // }
}
