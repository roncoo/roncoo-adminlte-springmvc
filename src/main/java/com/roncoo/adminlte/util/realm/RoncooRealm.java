package com.roncoo.adminlte.util.realm;

import java.util.HashSet;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class RoncooRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		HashSet<String> roleSet = new HashSet<String>();
		HashSet<String> permissionSet = new HashSet<String>();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		String username = (String) principals.getPrimaryPrincipal();
		if (username != null) {
			roleSet.add("user");
			permissionSet.add("user:*");
			permissionSet.add("admin:*");
		}
		authorizationInfo.setRoles(roleSet);
		authorizationInfo.setStringPermissions(permissionSet);
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		return new SimpleAuthenticationInfo(username, password, "roncooRealm");
	}

}
