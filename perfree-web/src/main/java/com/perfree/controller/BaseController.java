package com.perfree.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.setting.dialect.Props;
import com.perfree.common.Constants;
import com.perfree.common.OptionCache;
import com.perfree.model.Menu;
import com.perfree.model.User;
import com.perfree.service.MenuService;
import com.perfree.service.OptionService;
import com.perfree.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.List;

@Controller
public class BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private MenuService menuService;

    /**
     * 获取已登录用户信息
     * @return User
     */
    public User getUser(){
        Subject subject = SecurityUtils.getSubject();
        User user=new User();
        PrincipalCollection principals = subject.getPrincipals();
        if (principals == null) {
            return null;
        }
        BeanUtils.copyProperties(principals.getPrimaryPrincipal(), user);
        user = userService.getById(user.getId().toString());
        user.setPassword(null);
        user.setSalt(null);
        return user;
    }

    /**
     * 根据用户id获取后台菜单
     * @return List<Menu>
     */
    public List<Menu> getMenuByUserIdAndType() {
        return menuService.getMenuByUserIdAndType(getUser().getId(), 1);
    }

    /**
     * 获取当前启用的主题
     * @return String
     */
    public String currentTheme() {
        return OptionCache.getOption(Constants.OPTION_WEB_THEME);
    }

    /**
     * 获取当前启用的主题
     * @return String
     */
    public String currentThemePage() {
        return "static/themes/" + OptionCache.getOption(Constants.OPTION_WEB_THEME);
    }

    /**
     * 多出这个方法是因为直接返回的话,idea报黄线且不能自动链接至该文件(该死的强迫症)
     * @param viewPath viewPath
     * @return String
     */
    public String view(String viewPath) {
        return viewPath;
    }

    public String pageView(String viewPath) {
        File file = new File(Constants.PROD_RESOURCES_PATH + Constants.SEPARATOR +  viewPath);
        File devFile = new File(Constants.DEV_RESOURCES_PATH + Constants.SEPARATOR + viewPath);
        if (!file.exists() && !devFile.exists()) {
            return "redirect:/404";
        }
        return viewPath;
    }

    /**
     * 自动判断返回哪个页面
     * @param validPath 要判断的地址
     * @param themeViewPath 该页面在主题中的路径
     * @param adminViewPath 该页面在系统中的路径
     * @return String
     */
    public String view(String validPath, String themeViewPath, String adminViewPath) {
        File file = new File(Constants.PROD_THEMES_PATH + Constants.SEPARATOR + currentTheme() + validPath);
        File devFile = new File(Constants.DEV_THEMES_PATH + Constants.SEPARATOR + currentTheme() + validPath);
        if (file.exists() || devFile.exists()) {
            return view("static/themes/" + currentTheme() + themeViewPath);
        } else {
            return view(adminViewPath);
        }
    }

    /**
     * 获取安装进度
     * @return String
     */
    public String getInstallStatus() {
        File file = new File(Constants.DB_PROPERTIES_PATH);
        if (!file.exists()) {
            return null;
        }
        Props dbSetting = new Props(FileUtil.touch(file), CharsetUtil.CHARSET_UTF_8);
        return dbSetting.getStr("installStatus");
    }
}
