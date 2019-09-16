package com.yuw.control;

import com.yuw.bean.UserInfoBean;
import com.yuw.service.IUserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserLoginControl {

    @Resource
    private IUserInfoService userInfoService;

    /**
     * 表单数据和Control层的方法参数之间具有一一映射关系；
     * 要求；前台页面的表单控件的name属性值和Control层方法参数的名字一致即可；
     */
    @RequestMapping("login")
    public String doLogin(String userName, String userPsw) {
        System.out.println("后台登录处理：" + userName + ":" + userPsw);
        // 返回视图路径
        return "logined";
    }

    /*
    如果方法参数名和前台页面的表单控件的name属性值不一样，则需要使用 @RequestParam 注解进行绑定
     */
    @RequestMapping("/login2")
    public String doLogin2(@RequestParam("userName") String userN, String userPsw) {
        System.out.println("后台登录处理：" + userN + ":" + userPsw);
        // 返回视图路径
        return "logined";
    }

    /*
    映射关系：要求实体类的属性名和前台页面的表单控件的name属性值一一对应
    课堂作业：
        如果使用 @RequestParam 对方法参数进行绑定，是否可行？
     */
    @RequestMapping("/login3")
    public String doLogin3(UserInfoBean userInfoB) {
        if (userInfoB != null) {
            System.out.println("后台登录处理：" + userInfoB.getUsername() + ":" + userInfoB.getUserpsw());
        } else {
            System.out.println("后台登录：null");
        }
        // 调用service的接口方法，进行登录的业务逻辑处理
        List<UserInfoBean> lstUserInfos = userInfoService.doLogin(userInfoB);

        // 登录判定
        if (lstUserInfos != null && lstUserInfos.size() > 0) {
            // 登录成功
            System.out.println("登录成功：" + lstUserInfos.get(0).toString());
            // 返回视图路径
            return "logined";
        } else {
            // 登录不成功
            System.out.println("登录失败");
            // 返回登录页面
            return "../../index";
        }
    }

}
