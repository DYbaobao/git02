package cn.dvddemo;
import java.util.*;
public class Login {
	Scanner input = new Scanner(System.in);
	String name;
	String password;
	String name1;
	String password1;
    public void show(){
    	System.out.println("-----------��ӭ����DVD����ϵͳ----------------");
    	System.out.println(" -------------��ӭ��ע���û�----------------");
    	System.out.println("�������û���:");
        name= input.next();
        System.out.println("����������:");
        password = input.next();
        System.out.println("ע��ɹ�����");
        System.out.println("---------------------------------------");
    }
    public void denLu(){
    	boolean bl = true;
    	System.out.println("-----------��ӭ����DVD����ϵͳ----------------");
    	System.out.println(" -------------��ӭ����¼�û�----------------");
    	while(bl){
	    	System.out.println("������ע��ʱ���û���:");
	        name1= input.next();
	        System.out.println("������ע��ʱ������:");
	        password1 = input.next();
	        if(name1.equalsIgnoreCase(name)&&password1.equalsIgnoreCase(password)){
	        	System.out.println("��ϲ���¼�ɹ�����");
	        	bl=false;
	        }else{
	        	System.out.println("�û������������");
	        	continue;
	        }
    	}
        System.out.println("---------------------------------------");
    }
}
