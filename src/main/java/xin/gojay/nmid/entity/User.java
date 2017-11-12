package xin.gojay.nmid.entity;

/**
 * @author Gojay
 * @date 2017/11/6.
 */
public class User {
    private Integer id;
    private String username;
    private String nickname;
    private String password;
    private String tel;
    private String qq;
    private String email;
    private String address;

    public User() {
    }

    public User(Integer id, String username, String nickname, String password, String tel, String qq, String email, String address) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.tel = tel;
        this.qq = qq;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}