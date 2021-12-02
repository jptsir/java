package service;

import Dao.UserDaoImpl;
import pojo.User;

/**
 * @author jingpengtao
 * @create 2021-09-23 21:40
 */
public class userserveImpl implements userserve{
   private UserDaoImpl userl=new UserDaoImpl();

    @Override
    public void registUser(User user) {
        int saver = userl.saver(user);

    }

    @Override
    public User login(User user) {

        return userl.fornamepass(user.getUsername(),user.getPassword());
    }


    @Override
    public boolean check(String username) {
        if((userl.forname(username))==null){
           return false;
        }else{
            return true;
        }
    }
}
