package com.hunguigu.realm;

import com.hunguigu.dao.StaffDao;
import com.hunguigu.dao.UserDao;
import com.hunguigu.vo.Role;
import com.hunguigu.vo.Staff;
import com.hunguigu.vo.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.eclipse.jetty.server.Request;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserDao userDao;


    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名   getPrimaryPrincipal() 获取到的对象 取决于 认证时，构造传的第一个参数
        AuthenticationToken token = (AuthenticationToken)principalCollection.getPrimaryPrincipal();
        String username = (String)token.getPrincipal();
        System.out.println("获取到的用户名："+username);

        //将拥有的角色信息查出来(根据当前的登录成功的用户名查询)
        //根据用户名从数据库中查询出该用户拥有的角色
        List<String> roles = userDao.queryRoleNameByUserName(username);

        //将拥有的权限信息查出来(根据当前的登录成功的用户名查询)
        List<String> menus = userDao.queryMenuNameByUserName(username);


        //返回权限信息(SimpleAuthorizationInfo)由父类AuthenticatingRealm 进行授权
        SimpleAuthorizationInfo simpleAuthorizationInfo =
                new SimpleAuthorizationInfo();

        simpleAuthorizationInfo.addRoles(roles);
        simpleAuthorizationInfo.addStringPermissions(menus);


        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //1.从token中过去用户名
        String username = (String)token.getPrincipal();
        //String pwd = (String) token.getCredentials();

        //2.根据用户名查询当前数据表中该用户名对应的密码（数据表的数据）
        User user = userDao.queryUserName(username);

        //3.判断  取得用户对象为空   当前用户名不存在
        if(user==null){
            throw new UnknownAccountException("抱歉！该账户不存在。。。");
        }
        //不为空   继续下面操作

        //4.验证
        //返回认证信息(SimpleAuthenticationInfo)由父类AuthenticatingRealm 进行认证
        //构造方法 3个参数
        //1：将token传入
        //2：将数据表查到的密码传入
        //3：当前类的名字 (String)
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(token,user.getPassword(),user.getAccount());

        //将rids设置到sessioin中
        //通过职工id查询出角色id
        List<Role> list = userDao.queryStaff_RoleBySid(user.getId());

        String rids = "";
        for(int i=0;i<list.size();i++){
            rids+=list.get(i).getId()+",";
        }
//        session.setAttribute("rids",rids.substring(0,rids.length()-1));

        //4.验证
        //返回认证信息(SimpleAuthenticationInfo)由父类AuthenticatingRealm 进行认证
        //构造方法 3个参数
        //1：将token传入
        //2：将数据表查到的密码传入
        //3.加盐
        //4：当前类的名字 (String)
//        SimpleAuthenticationInfo simpleAuthenticationInfo =
//                new SimpleAuthenticationInfo(token,staff.getPwd(), ByteSource.Util.bytes("陈航吃"),staff.getLoginName());

        return simpleAuthenticationInfo;
    }


}
