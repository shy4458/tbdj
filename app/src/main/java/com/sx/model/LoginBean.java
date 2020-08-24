package com.sx.model;

/***       Author  shy 
 *         Time   2018/6/20 0020    13:29      */

public class LoginBean {


    /**
     * code : 1
     * data : {"userId":"1003549514738434049","userOtherId":"45454545","userName":"123","userPwd":"C4CA4238A0B923820DCC509A6F75849B","userPost":3,"userStatus":1,"userHeadpic":"1003549510279888897.jpg","userPhone":"","userEmail":"","userToken":"674e5765bf338d7b4a3f9be71ac4bae6efa4093b;1003549514738434049"}
     * message : 用户登录成功
     */

    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * userId : 1003549514738434049
         * userOtherId : 45454545
         * userName : 123
         * userPwd : C4CA4238A0B923820DCC509A6F75849B
         * userPost : 3
         * userStatus : 1
         * userHeadpic : 1003549510279888897.jpg
         * userPhone :
         * userEmail :
         * userToken : 674e5765bf338d7b4a3f9be71ac4bae6efa4093b;1003549514738434049
         */

        private String userId;
        private String userOtherId;
        private String userName;
        private String userPwd;
        private int userPost;
        private int userStatus;
        private String userHeadpic;
        private String userPhone;
        private String userEmail;
        private String userToken;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserOtherId() {
            return userOtherId;
        }

        public void setUserOtherId(String userOtherId) {
            this.userOtherId = userOtherId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }

        public int getUserPost() {
            return userPost;
        }

        public void setUserPost(int userPost) {
            this.userPost = userPost;
        }

        public int getUserStatus() {
            return userStatus;
        }

        public void setUserStatus(int userStatus) {
            this.userStatus = userStatus;
        }

        public String getUserHeadpic() {
            return userHeadpic;
        }

        public void setUserHeadpic(String userHeadpic) {
            this.userHeadpic = userHeadpic;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }
    }
}
