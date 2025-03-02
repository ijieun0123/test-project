package com.example.testproject.controller;

import com.example.testproject.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @PostMapping(value="/default")
    public String postMethod(){
        return "Hello World";
    }

    @PostMapping(value="/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.forEach((key, value) -> sb.append(key + " : " + value + "\n"));

        return sb.toString();
    }

    @PostMapping(value="/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

}
