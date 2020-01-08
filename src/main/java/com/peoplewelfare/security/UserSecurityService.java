package com.peoplewelfare.security;

import com.peoplewelfare.model.Login;
import com.peoplewelfare.model.PersonDetail;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Repository("userSecurityService")
public class UserSecurityService implements IUserSecurityService {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private SessionFactory sessionFactory;

	private NamedParameterJdbcTemplate jdbcTemplate;


	//	@Transactional(readOnly=true,propagation=Propagation.REQUIRED)
	public UserSecurityWrapper loadUserByUsername(Login validateLogin) throws UsernameNotFoundException {

		logger.info("===========================UserSecurityService======================");

		UserSecurityWrapper userS = null;
		PersonDetail user = null;
		try {

			Query query = sessionFactory.getCurrentSession().createQuery(" from PersonDetail p where p.personId =:personId  and p.password=:personPassword");
			query.setParameter("personId", validateLogin.getPersonId());
			query.setParameter("personPassword", validateLogin.getPersonPassword());
			List<PersonDetail> users = query.list();


			if (users != null && !users.isEmpty())
				user = users.get(0);

			if (null != user) {

				List<GrantedAuthority> roles = new ArrayList<>();

				userS = new UserSecurityWrapper(user.getPersonId(), user.getPassword(), user.isEnabled(),
						!user.isExpired(), !user.isCredentialsExpired(), !user.isLocked(), roles);
				userS.setSysUserId(user.getPersonId());

			}
		} catch (Exception e) {

			logger.info("Error Occured while fetching user details for " + e);
		}
		return userS;
	}


	@Override
	public UsernamePasswordAuthenticationToken createAuthenticationToken(UserDetails user, Authentication authentication, String hospitalCode) {

		String userId = ((UserSecurityWrapper) user).getSysUserId();

		CustomAuthToken authToken = (CustomAuthToken) authentication;

		return new UsernamePasswordAuthenticationToken(user,
				authToken.getCredentials());
	}


}
