package com.android.frame.bean;

import java.util.List;

/**
 * Created by jason on 2017/12/4.
 */

public class TestRetrofitUtilBean {

    /**
     * result : 0
     * message : FriendStatus List
     * data : {"friendsStatus":[{"user_id":1225508,"active_status":5,"invite_status":0},{"user_id":1207963,"active_status":4,"invite_status":0},{"user_id":1222268,"active_status":3,"invite_status":0},{"user_id":1222269,"active_status":4,"invite_status":0},{"user_id":1214089,"active_status":5,"invite_status":0},{"user_id":1136153,"active_status":3,"invite_status":0}]}
     */

    private int result;
    private String message;
    private DataBean data;

    public int getResult() { return result;}

    public void setResult(int result) { this.result = result;}

    public String getMessage() { return message;}

    public void setMessage(String message) { this.message = message;}

    public DataBean getData() { return data;}

    public void setData(DataBean data) { this.data = data;}

    public static class DataBean {
        private List<FriendsStatusBean> friendsStatus;

        public List<FriendsStatusBean> getFriendsStatus() { return friendsStatus;}

        public void setFriendsStatus(List<FriendsStatusBean> friendsStatus) { this.friendsStatus = friendsStatus;}

        public static class FriendsStatusBean {
            /**
             * user_id : 1225508
             * active_status : 5
             * invite_status : 0
             */

            private int user_id;
            private int active_status;
            private int invite_status;

            public int getUser_id() { return user_id;}

            public void setUser_id(int user_id) { this.user_id = user_id;}

            public int getActive_status() { return active_status;}

            public void setActive_status(int active_status) { this.active_status = active_status;}

            public int getInvite_status() { return invite_status;}

            public void setInvite_status(int invite_status) { this.invite_status = invite_status;}


            @Override
            public String toString() {
                return "FriendsStatusBean{" + "user_id=" + user_id + ", active_status=" + active_status + ", invite_status=" + invite_status + '}';
            }
        }
    }

    @Override
    public String toString() {
        return "TestRetrofitUtilBean{" + "result=" + result + ", message='" + message + '\'' + ", data=" + data.toString()+ '}';
    }
}
