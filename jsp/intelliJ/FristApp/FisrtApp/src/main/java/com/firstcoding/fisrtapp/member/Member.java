package com.firstcoding.fisrtapp.member;

// Beans : 모든 변수는 private, 기본 생성자, getter/setter 메소드
// DTO, VO(Value Object, 읽기 전용-getter만 가짐)
public class Member {

    // id, pw, name
    private String id;
    private String pw;
    private String name;

    public Member() {
    }

    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return this.id + "( " + this.name + " )";
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
