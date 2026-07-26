package com.soren.ui;

import com.soren.domain.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public void start(){
        System.out.println("游戏的注册页面启动了");
        ArrayList<User> list = new ArrayList<>();

        while (true) {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("    🎮 欢迎来到文字格斗游戏 🎮   ");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("请选择操作：1登录 2注册 3退出");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch(choose){
                case "1" :
                    login(list);
                    System.out.println("登录");
                    break;
                case "2" :
                    register(list);
                    System.out.println("注册");
                    break;
                case "3" :
                    System.out.println("用户选择了退出操作");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误");
                    break;

            }
        }
    }

    public void register(ArrayList<User> list) {
        System.out.println("注册");
        //键盘录入用户名，密码，  ---> User对象  --->集合
        //1.创建User对象
        User user = new User();
        //2.键盘录入用户名
        Scanner sc = new Scanner(System.in);


        // - 用户名唯一
        // - 长度必须在3 ~ 16位
        // - 只能由字母、数字组成，不能是纯数字
        while (true) {
            System.out.println("请输入用户名");
            String name = sc.next();
            // - 用户名唯一
            // - 长度必须在3 ~ 16位
            // - 只能由字母、数字组成，不能是纯数字
            if (!checkLen(3, 16, name)) {
                System.out.println("用户名长度必须在3 ~ 16位");
                continue;
            }
            if (!checkUserName(name)) {
                System.out.println("用户名格式不正确");
                continue;
            }
            if (contains(list, name)) {
                System.out.println("用户名已存在");
                continue;
            }
            user.setName(name);
            break;
        }

        //3.键盘录入密码
        String password1;
        while (true) {
            System.out.println("请输入密码");
            password1 = sc.next();
            System.out.println("请再次输入密码");
            String password2 = sc.next();
            //- 长度3 ~ 8位
            //- 只能是字母加数字的组合，不能有其他字母
            if (!checkLen(3, 8, password1)) {
                System.out.println("密码长度必须在3 ~ 8位");
                continue;
            }
            if (!checkoutPassword(password1)) {
                System.out.println("密码格式不正确");
                continue;
            }
            //校验两次密码是否一致
            if (!password1.equals(password2)){
                System.out.println("两次密码不一致");
                continue;
             }
            //把密码设置到对象当中
            user.setPassword(password1);
            break;
        }

        //4.把User对象添加到集合中
        list.add(user);
        //5.提示成功
        System.out.println(user.getName()+"注册成功 ");


    }


    public void login(ArrayList<User> list){
        System.out.println("登录");
    }

    public Boolean checkLen(int minLen,int maxLen,String str){
        return str.length() <= maxLen && str.length() >= minLen;
    }
    public Boolean checkUserName(String username) {
        int[] count = getCount(username);
        return count[0] > 0 && count[1] >= 0 && count[2] == 0;
    }

    public Boolean checkoutPassword(String password) {
        int[] count = getCount(password);
        return count[0] > 0 && count[1] > 0 && count[2] == 0;
    }

    // - 用户名唯一
    public Boolean contains(ArrayList<User> list,String username){
        for (int i = 0; i < list.size(); i++) {
            User u= list.get(i);
            if (u.getName().equals(username))
                return true;
        }
        return false;

    }

    public int[] getCount(String userInfo){
        int charCount = 0;
        int numCount = 0;
        int otherCount = 0;
        // - 只能由字母、数字组成，不能是纯数字
        for (int i = 0; i < userInfo.length(); i++) {
            char c = userInfo.charAt(i);
            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                charCount++;
            else if(c >= '0' && c <= '9')
                numCount++;
            else
                otherCount++;
        }
        return new int[]{charCount, numCount, otherCount};
    }

}
