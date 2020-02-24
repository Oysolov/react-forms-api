package com.hoysolov.reactformsapi.payload;

public class UserProfileResponse {

    private Long id;
    private String email;
    private String username;
    private String sex;
    private Integer devSkills;

    public UserProfileResponse(Long id, String email, String username, String sex, Integer devSkills) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.sex = sex;
        this.devSkills = devSkills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getDevSkills() {
        return devSkills;
    }

    public void setDevSkills(Integer devSkills) {
        this.devSkills = devSkills;
    }

}
