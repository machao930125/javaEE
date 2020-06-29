package com.chao.spring;

public class UserController {
    @MyAutowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }
}
