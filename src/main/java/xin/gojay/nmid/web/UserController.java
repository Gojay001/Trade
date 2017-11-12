package xin.gojay.nmid.web;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xin.gojay.nmid.entity.User;
import xin.gojay.nmid.service.UserService;
import xin.gojay.nmid.util.ResponseUtil;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
@Controller
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param nickname 用户昵称
     * @param password 用户密码
     * @param tel 用户电话
     * @param qq 用户QQ（可选）
     * @param email 用户邮箱（可选）
     * @param address 用户地址
     * @return 响应
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    @ResponseBody
    public ResponseUtil signUp(@Param("username") String username,
                               @Param("nickname") String nickname,
                               @Param("password") String password,
                               @Param("tel") String tel,
                               @Param("qq") String qq,
                               @Param("email") String email,
                               @Param("address") String address) {
        User user = new User();
        user.setUsername(username);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setTel(tel);
        user.setQq(qq);
        user.setEmail(email);
        user.setAddress(address);
        return userService.insertUser(user);
    }

    /**
     * 用户登录
     * @param username 用户名
     * @param password 密码
     * @return 响应
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody
    public ResponseUtil checkUser(@Param("username") String username,
                                  @Param("password") String password) {
        return userService.checkUserLogin(username, password);
    }

    /**
     * 修改用户信息
     * @param id 用户id
     * @param nickname 用户昵称
     * @param password 用户密码
     * @param tel 用户电话
     * @param qq 用户QQ（可选）
     * @param email 用户邮箱（可选）
     * @param address 用户地址
     * @return 响应
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public ResponseUtil updateUser(@Param("id") Integer id,
                                   @Param("nickname") String nickname,
                                   @Param("password") String password,
                                   @Param("tel") String tel,
                                   @Param("qq") String qq,
                                   @Param("email") String email,
                                   @Param("address") String address) {
        User user = userService.getUserById(id);
        user.setNickname(nickname);
        user.setPassword(password);
        user.setTel(tel);
        user.setQq(qq);
        user.setEmail(email);
        user.setAddress(address);
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/signUp1", method = RequestMethod.POST)
    @ResponseBody
    public ResponseUtil signUp(@Param("username") String username,
                               @Param("password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setNickname("hujie");
        user.setPassword(password);
        user.setTel("13611112222");
        user.setQq("123456");
        user.setEmail("hujie@foxmail.com");
        user.setAddress("hujie");
        System.out.println(user.toString());
        return userService.insertUser(user);
    }
}
