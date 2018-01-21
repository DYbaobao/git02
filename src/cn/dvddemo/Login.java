package cn.dvddemo;
import java.util.*;
public class Login {
	Scanner input = new Scanner(System.in);
	String name;
	String password;
	String name1;
	String password1;
    public void show(){
    	System.out.println("-----------欢迎来到DVD租赁系统----------------");
    	System.out.println(" -------------欢迎来注册用户----------------");
    	System.out.println("请输入用户名:");
        name= input.next();
        System.out.println("请输入密码:");
        password = input.next();
        System.out.println("注册成功！！");
        System.out.println("---------------------------------------");
    }
    public void denLu(){
    	boolean bl = true;
    	System.out.println("-----------欢迎来到DVD租赁系统----------------");
    	System.out.println(" -------------欢迎来登录用户----------------");
    	while(bl){
	    	System.out.println("请输入注册时的用户名:");
	        name1= input.next();
	        System.out.println("请输入注册时的密码:");
	        password1 = input.next();
	        if(name1.equalsIgnoreCase(name)&&password1.equalsIgnoreCase(password)){
	        	System.out.println("恭喜你登录成功！！");
	        	bl=false;
	        }else{
	        	System.out.println("用户名或密码错误！");
	        	continue;
	        }
    	}
        System.out.println("---------------------------------------");
    }
}
