package com.soren.ui;

import java.util.Scanner;

public class Login {
    public void start(){
        System.out.println("游戏的注册页面启动了");

        while (true) {
            System.out.println("╔════════════════════════════════╗");
            System.out.println("    🎮 欢迎来到文字格斗游戏 🎮   ");
            System.out.println("╚════════════════════════════════╝");
            System.out.println("请选择操作：1登录 2注册 3退出");

            Scanner sc = new Scanner(System.in);
            String choose = sc.next();

            switch(choose){
                case "1" :
                    System.out.println("登录");
                    break;
                case "2" :
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
    public void login(){
        System.out.println("登录");
    }
    public void register(){
        System.out.println("注册");
    }
}
