package com.example.demo.controller.dto;

import lombok.Data;
import com.example.demo.entity.Menu;

import java.util.List;


/**
 * 接受前端登录请求的参数
 */
@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;
    private String token;
    private String role;
    private List<Menu> menus;
}
