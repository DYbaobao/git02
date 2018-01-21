package dvd;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DVDMgr {
	 String date1;
	 String date2;
     DVDSet dvd = new DVDSet();
     double  money1;
     double sum;
     double  money;
     Scanner input = new Scanner(System.in);
    
     
     //数据
     public void initial(){
    	 dvd.name[0]="罗马假日";
    	 dvd.state[0]=0;
    	 dvd.date[0]="2013-7-1";
    	 dvd.count[0]=30;
    	
    	 dvd.name[1]="风声鹤唳";
    	 dvd.state[1]=1;
    	 dvd.count[1]=12;
    	
    	 dvd.name[2]="浪漫满屋";
    	 dvd.state[2]=1;
    	 dvd.count[2]=15;
    	
    	 
     }
   
     //菜单
     int choice;
    
     public void starMenu(){
    	
    	 System.out.println("欢迎使用迷你DVD管理器");
    	 System.out.println("----------------------------");
    	 System.out.println("--1.新增DVD--");
    	 System.out.println("--2.查看DVD--");
    	 System.out.println("--3.删除DVD--");
    	 System.out.println("--4.借出DVD--");
    	 System.out.println("--5.归还DVD--");
    	 System.out.println("--6.排行DVD--");
    	 System.out.println("--7.退       出--");
    	 System.out.println("----------------------------");
    	
    	 
     }
         //选择
         boolean bl = true;
	     public void choice(){
	    	 
	    	 initial();
	    	 System.out.println("---------------------");
	    	 while(bl){ 
	    		  System.out.println("请选择: ");
	    	      choice=input.nextInt();
		    	 switch(choice){
		    	 case 1:
		    		 System.out.println("--》新增DVD");
		    		 insert();
		    		 returnMain();
		    		 break;
		    	 case 2:
		    		 System.out.println("--》查看DVD");
		    		 dvd.show();
		    		 select();
		    		 returnMain();
		    		 break;
		
		    	 case 3:
		    		 System.out.println("--》删除DVD");
		    	     delete();
		    		 returnMain();
		    		 break;
		    	 case 4:
		    		 System.out.println("--》借出DVD");
		    		 lend();
		    		 
		    		 returnMain();
		    		 break;
		    	 case 5:
		    		 System.out.println("--》归还DVD");
		    		 returnDvd();
		    		 returnMain();
		    		 break;
		    	 case 6:
		    		 System.out.println("--》排行DVD");
		    		 list();
		    		
		    		 returnMain();
		    		 break;
		    	
		    	 case 7:
		    		 System.out.println("--》退        出");
		    		 bl=false;
		    		 break;
		    	 }
	    	 }
	    	 System.out.println("---------------------");
     }
   
    //返回主菜
     public void returnMain(){
    	 System.out.println("---------------------");
    	
    	 System.out.println("输入0返回:");
    	 if(input.nextInt()==0){
    		 starMenu();
    	 }else{
    		 System.out.println("输入错误,异常终止！");
    	 }
    	 System.out.println("---------------------");
     }
     //查看DVD
     public void select(){
    	 System.out.println("---------------------");
     	for (int i = 0; i < dvd.name.length; i++) {
 			if(dvd.name[i]==null){
 				break;
 			}else if(dvd.state[i]==0){
 				System.out.println((i+1)+"\t已借出\t"+"<<"+dvd.name[i]+">>\t"+dvd.date[i]);
 			}else if(dvd.state[i]==1){
 				System.out.println((i+1)+"\t可 借\t"+"<<"+dvd.name[i]+">>");
 			}
 		}
     	System.out.println("---------------------");
      }
     //新增DVD
     public void insert (){
    	 System.out.println("---------------------");
    	
	    	 System.out.println("请输入新增DVD的名字:");
	    	 String  name1= input.next();
	    	 for (int i  = 0;   i< dvd.name.length;  i++) {
				if(dvd.name[i]==null){
					dvd.name[i]=name1;
					dvd.state[i]=1;
					break;
				}
			 }
	    	 System.out.println("新增DVD"+"<<"+name1+">>"+"成功！");
    	
 			 
 		 
    	 System.out.println("---------------------");
     }
     //删除DVD
     public void delete(){
    	 System.out.println("---------------------");
         
	    	 System.out.println("请输入删除DVD的名字:");
	    	 String  name2= input.next(); 
	    	
	    	 for (int i  = 0;   i< dvd.name.length;  i++) {
	    		 if(dvd.name[i]!=null&&dvd.name[i].trim().equalsIgnoreCase(name2.trim())&&dvd.state[i]==1){
	 				 int j=i;
	 				while(dvd.name[j+1]!=null){
	 					dvd.name[j]=dvd.name[j+1];
	 					dvd.date[j]=dvd.date[j+1];
	 					dvd.state[j]=dvd.state[j+1];
	 					j++;
	 				}
	 				dvd.name[j]=null;
	 				dvd.date[j]=null;
	 				System.out.println("删除《"+name2+"》成功!");
	 				bl= true;
	 				break;
	 			}else if(dvd.name[i]!=null&&dvd.name[i].trim().equalsIgnoreCase(name2.trim())&&dvd.state[i]==0){
	 				System.out.println("《"+name2+"》为借出状态,不能删除!");
	 				
	 				bl= true;
	 				break;
	 				
	 			}
	    	 }
 		 
    	 
    	 System.out.println("---------------------");
     }
     //借出
     public void lend(){
    	 System.out.println("---------------------");
    	 System.out.println("请输入你借的DVD的名字:");
    	 String  name3= input.next(); 
    	 
    	 //遍历
    	 for (int i  = 0;   i< dvd.name.length;  i++) {
 			if(dvd.name[i]==null){
 				System.out.println("Sorry,你借的DVD不存在,你可以借其他的,按0键看看");
 				break;
 				
 			}else if(dvd.name[i].trim().equalsIgnoreCase(name3.trim())&&dvd.state[i]==1){
 				System.out.println("《"+name3+"》"+"可以借出DVD");
 			
 				
 				while(bl){
 					System.out.println("请输入你借的日期格式为:(XXXX-XX-XX)");
 	 				 date1=input.next();
 					int index =date1.trim().indexOf("-");
 	 				int lastIndex= date1.trim().lastIndexOf("-");
 	 			
	 				if( index==4&&lastIndex==7&&date1.substring(lastIndex+1, date1.length()).length()==2){
	 					    dvd.date[i]=date1;
	 					     dvd.state[i]=0;
	 		 			    System.out.println("借出成功!!!!");
	 		 			   
	 		 			    break;
	 				}else{
	 					System.out.println("日期格式不正确！");
	 					continue;
	 				}
 				}
 				dvd.count[i]++;
 				break;
 			}else if(dvd.name[i].trim().equalsIgnoreCase(name3.trim())&&dvd.state[i]==0){
 				System.out.println("你要借的DVD"+"《"+name3+"》"+"已经借出去了");
 				break;
 			}
 		 }
    	 System.out.println("---------------------");
     }
     //归还
     public void returnDvd(){
    	 System.out.println("---------------------");
    	 System.out.println("请输入你归还的DVD的名字:");
    	 String  name3= input.next();
			System.out.println("请输入你归还的日期格式为:(XXXX-XX-XX)");
			 date2=input.next();
			 boolean bl= true;
			 while(bl){
					int index =date2.indexOf("-");
	 				int lastIndex= date2.lastIndexOf("-");
	 				 
	 				if( index==4&&lastIndex==7&&date2.substring(lastIndex+1, date2.length()).length()==2){
	 					 System.out.println("归还《"+name3+"》成功！！！！");
	 				
	 					 //改状态
	 					 for(int i  = 0;   i< dvd.name.length;  i++){
	 						if(dvd.name[i]!=null&&dvd.name[i].trim().equalsIgnoreCase(name3.trim())&&dvd.state[i]==0){
	 							dvd.state[i]=1;
	 							
	 							 System.out.println("借出日期:"+dvd.date[i]);
	 		 		    		 System.out.println("归还日期:"+date2);
	 		 		    		 money=charge(dvd.date[i],date2);
	 		 		    		 System.out.println("应付租金的金额为:"+money );
	 		 		    		 money(money);
	 		 		    		 bl=false;
	 		 		 			   break;
	 						}
	 					 }
	 					
	 				}else{
	 					System.out.println("日期格式不正确！");
	 					System.out.println("请输入你借书的日期格式为:(XXXX-XX-XX)");
	 					date2=input.next();
	 					continue;
	 					
	 				}
 			 } 
    	 
    		
    		
    		
			 System.out.println("---------------------");
    	 }
    	 
    
     //日期
     public long charge(String dstr1,String dstr2){
    	 long charge=0;
    	 SimpleDateFormat  sd= new SimpleDateFormat("yyyy-MM-dd");
    	 try{
    		  Date d1 =sd.parse(dstr1);
    		  Date d2 =sd.parse(dstr2);
    		  charge =(d2.getTime()-d1.getTime())/(24*60*60*1000);
    	 }catch(ParseException e){
    		 e.printStackTrace();
    	 }
    	 return charge;
     }
     //消费
     public void money(double  charge){
       System.out.println("---------------------");
     
	   System.out.println("请输入你付款金额:");
	   money=input.nextDouble();
	   System.out.println("你的付款金额为"+money);
	   sum=money-charge;
	   System.out.println("找"+"       "+"回"+"      "+"你"+sum);
       System.out.println("欢迎你下次再来！");
     
	   System.out.println("---------------------");
     }
     //排行
     public void list(){
    	 System.out.println("---------------------");
    	 String []  name6= new String [50];
    	 int []  count1 = new int [50];
    	 for (int i = 0; i < name6.length; i++) {
			 
				 name6[i]=dvd.name[i];
				 count1[i]=dvd.count[i];
			
		 }
    	
    	 for (int i = 0; i < name6.length-1; i++) {
			for (int j = 0; j < name6.length-i-1; j++) {
				if(count1[j]<count1[j+1]){
					int temp=count1[j];
					count1[j]=count1[j+1];
					count1[j+1]=temp;
					String tem=name6[j];
					name6[j]=name6[j+1];
					name6[j+1]=tem;
				}
			}
		 }
    	 System.out.println("次数"+"\t"+"名称");
    	 for (int i = 0; i < count1.length; i++) {
    	
    		 if(name6[i]!=null){
    		   
			   System.out.println(count1[i]+"\t"+"《"+name6[i]+"》");
    		 }
		 }
    	 System.out.println("---------------------");
     }
  
    
}
