package xin.gojay.nmid.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.gojay.nmid.dao.UserDao;
import xin.gojay.nmid.entity.User;
import xin.gojay.nmid.service.UserService;
import xin.gojay.nmid.util.RegexUtil;
import xin.gojay.nmid.util.ResponseUtil;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final int USERNAME_LENGTH = 11;
    private static final int NICKNAME_LENGTH = 22;
    private static final int PASSWORD_LENGTH = 22;
    private static final int QQ_LENGTH = 11;
    private static final int TRUE = 1;
    private static final int FALSE = 0;
    private ResponseUtil responseUtil = null;

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public ResponseUtil insertUser(User user) {
        // 用户名是否存在
        if (usernameIsExist(user.getUsername()) != FALSE) {
            responseUtil = new ResponseUtil(400, "user existed");
            return responseUtil;
        }
        // 验证输入信息
        if (checkUserInfo(user) != TRUE) {
            responseUtil = new ResponseUtil(400, "info error");
            return responseUtil;
        }
        if (userDao.insertUser(user) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        responseUtil.setBody(user);
        return responseUtil;
    }

    @Override
    public int checkUserInfo(User user) {
        if (user.getUsername() == null || "".equals(user.getUsername()) || user.getUsername().length() > USERNAME_LENGTH) {
            return FALSE;
        }
        if (user.getNickname() == null || "".equals(user.getNickname()) || user.getNickname().length() > NICKNAME_LENGTH) {
            return FALSE;
        }
        if (user.getPassword() == null || "".equals(user.getPassword()) || user.getPassword().length() > PASSWORD_LENGTH) {
            return FALSE;
        }
        if (!RegexUtil.isMobile(user.getTel())) {
            return FALSE;
        }
        if (user.getQq() == null || "".equals(user.getQq()) || user.getQq().length() > QQ_LENGTH) {
            return FALSE;
        }
        if (!RegexUtil.isEmail(user.getEmail())) {
            return FALSE;
        }
        if (user.getAddress() == null || "".equals(user.getAddress())) {
            return FALSE;
        }
        return TRUE;
    }

    @Override
    public int usernameIsExist(String username) {
        int status = FALSE;
        if (getUserByName(username) != null) {
            status = TRUE;
        }
        return status;
    }

    @Override
    public User getUserByName(String username) {
        return userDao.getUserByName(username);
    }

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public ResponseUtil checkUserLogin(String username, String password) {
        User user = getUserByName(username);
        if (usernameIsExist(username) != TRUE || !user.getPassword().equals(password)) {
            responseUtil = new ResponseUtil(400, "user error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(200, "success");
        responseUtil.setBody(user);
        return responseUtil;
    }

    @Override
    public ResponseUtil updateUser(User user) {
        if (checkUserInfo(user) != TRUE) {
            responseUtil = new ResponseUtil(400, "user error");
            return responseUtil;
        }
        if (userDao.updateUser(user) != TRUE) {
            responseUtil = new ResponseUtil(500, "error");
            return responseUtil;
        }
        responseUtil = new ResponseUtil(201, "success");
        responseUtil.setBody(user);
        return responseUtil;
    }
}
