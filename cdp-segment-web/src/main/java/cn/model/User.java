package cn.model;



public class User {

    /**
     * 用户表主键Id
     */

    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private String userAge;

    /**
     * 用户住址
     */
    private String userAddr;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户电话号码
     */
    private String userPhone;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userAge='" + userAge + '\'' +
                ", userAddr='" + userAddr + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
