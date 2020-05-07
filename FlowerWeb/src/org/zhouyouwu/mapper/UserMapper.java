package org.zhouyouwu.mapper;

import org.zhouyouwu.beans.UserBean;

import java.util.List;

/**用户信息增删查改
 *
 */
public interface UserMapper {
    public int addUser(UserBean user);
    public List<UserBean> selectUserList();
    public UserBean selectUser(String userId);
}
