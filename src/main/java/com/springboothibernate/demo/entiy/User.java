package com.springboothibernate.demo.entiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User implements UserDetails {
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户状态:0=正常,1=禁用
     */
    private Boolean state;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像图片地址
     */
    private String headImgUrl;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码加盐
     */
    @JsonIgnore
    private String salt;

    /**
     * 登录密码
     */
    @JsonIgnore
    private String password;

    /**
     * 创建时间
     */

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="create_time")
    private Date createtime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="edite_time")
    private Date editetime;

    /**
     * 修改人
     */
    private String editor;

    /**
     * 逻辑删除:0=未删除,1=已删除
     */
    @JsonIgnore
    private Boolean deleted;


public  User(Long id,String name,String password){
    this.id=id;
    this.name=name;
    this.password=password;
}
    public User(){

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
