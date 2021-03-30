package dao;

import pojo.User;

public interface UserDao {

    /**
     * query user information based on username
     * @param username
     * @return
     * @author Haoran Qi
     * @date
     */
    User queryUserByUsername(String username);

    /**
     * save user information
     * @param user
     * @return
     * @author Haoran Qi
     * @date
     */
    int saveUser(User user);

    /**
     * query user by username and password if return null, means no such user exists
     * @param username
	 * @param password
     * @return
     * @author Haoran Qi
     * @date
     */
    User queryByUsernameAndPwd(String username, String password);

    /**
     * counts the total numbers of user in database
     * @param
     * @return
     * @author Haoran Qi
     * @date
     */
    Integer queryTotalUser();
}
