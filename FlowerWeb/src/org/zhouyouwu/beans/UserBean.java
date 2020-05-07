package org.zhouyouwu.beans;

import lombok.Data;
import lombok.NonNull;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.Size;

@Alias("User")
@Data
public class UserBean {
    @NonNull
    @Size(max = 11, min = 8, message = "8-11个字符")
    private String userId;

    @NonNull
    @Size(max = 16, min = 8, message = "8-16个字符")
    private String password;

    @NonNull
    @Size(max = 12, min = 2, message = "2-12个字符")
    private String username;

    public UserBean(){}

    public UserBean(String userId, String password, String username){
        this.userId = userId;
        this.password = password;
        this.username = username;
    }
}
