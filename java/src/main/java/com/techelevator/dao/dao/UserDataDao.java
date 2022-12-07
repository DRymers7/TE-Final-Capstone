<<<<<<< HEAD
package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.UserData;

import java.util.List;

public interface UserDataDao {

    public List<UserData> getUserData(int userId);

}
=======
package com.techelevator.dao.dao;

import com.techelevator.model.ModelClasses.UserData;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface UserDataDao {

    UserData getUserData(int userId) throws SQLException;
}
>>>>>>> 9fea58df152620235fea24ea0405fa6d8ccb0276
