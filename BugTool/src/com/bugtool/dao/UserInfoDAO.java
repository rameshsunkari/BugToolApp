package com.bugtool.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.bugtool.model.UserInfo;
import com.bugtool.util.BugTooUtils;

/**
 * Home object for domain model class UserInfo.
 * 
 * @see com.bugmodel.dao.UserInfo
 * @author rsunkari
 */
@Repository("userInfoDAO")
public class UserInfoDAO extends BaseDAO<UserInfo> {
	
	public UserInfoDAO() {
		super(UserInfo.class);
	}

	public boolean checkUserLogin(String email, String password) {
		boolean success = false;
		
		String pass = null;
		try {
			pass = BugTooUtils.encrypt(password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		success = findByCriteria(Restrictions.and(Restrictions.eq("emailid", email),
				Restrictions.eq("pswd", pass))).size() > 0 ? true : false;

		return success;
	}
	
	public UserInfo findUserByEmailId(String email){
		return (UserInfo) findByCriteria(Restrictions.eq("emailid", email)).get(0);
	}
	

}
