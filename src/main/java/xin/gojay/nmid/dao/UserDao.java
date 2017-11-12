package xin.gojay.nmid.dao;

import xin.gojay.nmid.entity.User;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public interface UserDao {
    /**
     * 将用户信息写入数据库
     * @param user 用户实体
     * @return 成功标志
     */
    int insertUser(User user);

    /**
     * 查询用户名所对应的用户实体
     * @param username 用户名
     * @return 用户实体
     */
    User getUserByName(String username);

    /**
     * 通过id查询用户
     * @param userId 用户id
     * @return 用户实体
     */
    User getUserById(Integer userId);

    /**
     * 更新用户信息
     * @param user 用户实体
     * @return 成功标志
     */
    int updateUser(User user);
}
