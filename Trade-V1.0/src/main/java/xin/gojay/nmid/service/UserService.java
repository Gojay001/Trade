package xin.gojay.nmid.service;

import xin.gojay.nmid.entity.User;
import xin.gojay.nmid.util.ResponseUtil;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public interface UserService {
    /**
     * 新增用户
     * @param user 用户bean
     * @return 响应状态
     */
    ResponseUtil insertUser(User user);

    /**
     * 验证用户信息格式
     * @param user 用户实体
     * @return 成功标志
     */
    int checkUserInfo(User user);

    /**
     * 验证用户名是否存在
     * @param username 用户名
     * @return 成功标志
     */
    int usernameIsExist(String username);

    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户实体
     */
    User getUserByName(String username);

    /**
     * 根据id查询用户
     * @param userId 用户id
     * @return 用户实体
     */
    User getUserById(Integer userId);

    /**
     * 验证用户登陆
     * @param username 用户名
     * @param password 用户密码
     * @return 响应状态
     */
    ResponseUtil checkUserLogin(String username, String password);

    /**
     * 更改用户信息
     * @param user 用户实体
     * @return 响应状态
     */
    ResponseUtil updateUser(User user);
}
