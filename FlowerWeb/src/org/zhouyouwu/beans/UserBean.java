package org.zhouyouwu.beans;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

@Data
public class UserBean {
    @NonNull
    @Size(max = 11, min = 8)
    private String userId;

    @NonNull
    @Size(max = 16, min = 8)
    private String password;

    @NonNull
    @Size(max = 12, min = 2)
    private String username;

    public UserBean(){}

    public UserBean(String userId, String password, String username){
        this.userId = userId;
        this.password = password;
        this.username = username;
    }
}
