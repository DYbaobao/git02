package cn.dvddemo;
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
    
     
     //����
     public void initial(){
    	 dvd.name[0]="�������";
    	 dvd.state[0]=0;
    	 dvd.date[0]="2013-7-1";
    	 dvd.count[0]=30;
    	 dvd.p[0]=1;
    	 dvd.name[1]="�������";
    	 dvd.state[1]=1;
    	 dvd.count[1]=12;
    	 dvd.p[1]=3;
    	 dvd.name[2]="��������";
    	 dvd.state[2]=1;
    	 dvd.count[2]=15;
    	 dvd.p[2]=6;
    	 
     }
   
     //�˵�
     int choice;
    
     public void starMenu(){
    	
    	 System.out.println("��ӭʹ������DVD������");
    	 System.out.println("----------------------------");
    	 System.out.println("--1.����DVD--");
    	 System.out.println("--2.�鿴DVD--");
    	 System.out.println("--3.ɾ��DVD--");
    	 System.out.println("--4.���DVD--");
    	 System.out.println("--5.�黹DVD--");
    	 System.out.println("--6.����DVD--");
    	 System.out.println("--7.��DVD--");
    	 System.out.println("--8.��       ��--");
    	 System.out.println("--9.��       ��--");
    	 System.out.println("----------------------------");
    	
    	 
     }
         //ѡ��
         boolean bl = true;
         boolean in= true;
	     public void choice(){
	    	 System.out.println("��ѡ��: ");
	    	 initial();
	    	 System.out.println("---------------------");
	    	 while(bl){
	    		
	    		 
	    		 
	    		
		    		 choice=input.nextInt();
		    			
	    		 
			    	 switch(choice){
			    	 case 1:
			    		 System.out.println("--������DVD");
			    		 insert();
			    		 returnMain();
			    		 break;
			    	 case 2:
			    		 System.out.println("--���鿴DVD");
			    		 dvd.show();
			    		 select();
			    		 returnMain();
			    		 break;
			
			    	 case 3:
			    		 System.out.println("--��ɾ��DVD");
			    	     delete();
			    		 returnMain();
			    		 break;
			    	 case 4:
			    		 System.out.println("--�����DVD");
			    		 lend();
			    		 
			    		 returnMain();
			    		 break;
			    	 case 5:
			    		 System.out.println("--���黹DVD");
			    		 returnDvd();
			    		 returnMain();
			    		 break;
			    	 case 6:
			    		 System.out.println("--������DVD");
			    		 list();
			    		
			    		 returnMain();
			    		 break;
			    	 case 7:
			    		 System.out.println("--����DVD����");
			    		
			    		 huaiPaiHang();
			    		 returnMain();
			    		 break;
			    	 case 8:
			    		 System.out.println("--���齱�");
			    		 
			    		 chouJiang();
			    		 returnMain();
			    		 break;
			    	 case 9:
			    		 System.out.println("--����        ��");
			    		 bl=false;
			    		 break;
			    	 }
			    	 
	    		 
		    	
	    		
	    		 }
	    	 }
     
   
    //��������
     public void returnMain(){
    	 System.out.println("---------------------");
    	
    	 System.out.println("����0����:");
    	 if(input.nextInt()==0){
    		 starMenu();
    	 }else{
    		 System.out.println("�������,�쳣��ֹ��");
    	 }
    	 System.out.println("---------------------");
     }
     //�鿴DVD
     public void select(){
    	 System.out.println("---------------------");
     	for (int i = 0; i < dvd.name.length; i++) {
 			if(dvd.name[i]==null){
 				break;
 			}else if(dvd.state[i]==0){
 				System.out.println((i+1)+"\t�ѽ��\t"+"<<"+dvd.name[i]+">>\t"+dvd.date[i]+"\t"+dvd.p[i]);
 			}else if(dvd.state[i]==1){
 				System.out.println((i+1)+"\t�� ��\t"+"<<"+dvd.name[i]+">>"+"\t\t\t"+dvd.p[i]);
 			}
 		}
     	System.out.println("---------------------");
      }
     //����DVD
     public void insert (){
    	 System.out.println("---------------------");
    	
	    	 System.out.println("����������DVD������:");
	    	String  name1= input.next();
	    	 for (int i  = 0;   i< dvd.name.length;  i++) {
				if(dvd.name[i]==null){
					dvd.name[i]=name1;
					dvd.state[i]=1;
					break;
				}
			 }
	    	 System.out.println("����DVD"+"<<"+name1+">>"+"�ɹ���");
    	
 			 
 		 
    	 System.out.println("---------------------");
     }
     //ɾ��DVD
     public void delete(){
    	 System.out.println("---------------------");
         
	    	 System.out.println("������ɾ��DVD������:");
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
	 				System.out.println("ɾ����"+name2+"���ɹ�!");
	 				bl= true;
	 				break;
	 			}else if(dvd.name[i]!=null&&dvd.name[i].trim().equalsIgnoreCase(name2.trim())&&dvd.state[i]==0){
	 				System.out.println("��"+name2+"��Ϊ���״̬,����ɾ��!");
	 				
	 				bl= true;
	 				break;
	 				
	 			}
	    	 }
 		 
    	 
    	 System.out.println("---------------------");
     }
     //���
     public void lend(){
    	 System.out.println("---------------------");
    	 System.out.println("����������DVD������:");
    	 String  name3= input.next(); 
    	
    	 //����
    	 for (int i  = 0;   i< dvd.name.length;  i++) {
 			if(dvd.name[i]==null){
 				System.out.println("Sorry,����DVD������,����Խ�������,��0������");
 				break;
 				
 			}else if(dvd.name[i].trim().equalsIgnoreCase(name3.trim())&&dvd.state[i]==1){
 				System.out.println("��"+name3+"��"+"���Խ��DVD");
 			
 				
 				while(bl){
 					System.out.println("�������������ڸ�ʽΪ:(XXXX-XX-XX)");
 	 				 date1=input.next();
 					int index =date1.trim().indexOf("-");
 	 				int lastIndex= date1.trim().lastIndexOf("-");
 	 			
	 				if( index==4&&lastIndex==7&&date1.substring(lastIndex+1, date1.length()).length()==2){
	 					    dvd.date[i]=date1;
	 					     dvd.state[i]=0;
	 		 			    System.out.println("����ɹ�!!!!");
	 		 			   
	 		 			    break;
	 				}else{
	 					System.out.println("���ڸ�ʽ����ȷ��");
	 					continue;
	 				}
 				}
 				dvd.count[i]++;
 				break;
 			}else if(dvd.name[i].trim().equalsIgnoreCase(name3.trim())&&dvd.state[i]==0){
 				System.out.println("��Ҫ���DVD"+"��"+name3+"��"+"�Ѿ����ȥ��");
 				break;
 			}
 		 }
    	 System.out.println("---------------------");
     }
     //�黹
     public void returnDvd(){
    	 System.out.println("---------------------");
    	 System.out.println("��������黹��DVD������:");
    	 String  name3= input.next();
			System.out.println("��������黹�����ڸ�ʽΪ:(XXXX-XX-XX)");
			 date2=input.next();
			 boolean bl= true;
			 while(bl){
				 
					int index =date2.indexOf("-");
	 				int lastIndex= date2.lastIndexOf("-");
	 				 
	 				if( index==4&&lastIndex==7&&date2.substring(lastIndex+1, date2.length()).length()==2){
	 					 
	 				
	 					 //��״̬
	 					 for(int i  = 0;   i< dvd.name.length;  i++){
	 						 
	 						if(dvd.name[i]!=null&&dvd.name[i].trim().equalsIgnoreCase(name3.trim())&&dvd.state[i]==0){
	 							dvd.state[i]=1;
	 							 dvd.p[i]++;
	 							
	 							 System.out.println("�������:"+dvd.date[i]);
	 		 		    		 System.out.println("�黹����:"+date2);
	 		 		    		 money=charge(dvd.date[i],date2);
	 		 		    		 System.out.println("Ӧ�����Ľ��Ϊ:"+money );
	 		 		    		 money(money);
	 		 		    		System.out.println("�黹��"+name3+"���ɹ���������");
	 		 		    		 bl=false;
	 		 		 			   break;
	 						}else{
	 							System.out.println("�黹ʧ��δ��");
	 							bl=false;
	 							break;
	 						}
	 					 }
	 					
	 				}else{
	 					System.out.println("���ڸ�ʽ����ȷ��");
	 					System.out.println("���������������ڸ�ʽΪ:(XXXX-XX-XX)");
	 					date2=input.next();
	 					continue;
	 					
	 				}
 			 } 
    	 
    		
    		
    		
			 System.out.println("---------------------");
    	 }
    	 
    
     //����
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
     //����
     public void money(double  charge){
       System.out.println("---------------------");
   
	   System.out.println("�������㸶����:");
	   money=input.nextDouble();
	   System.out.println("��ĸ�����Ϊ"+money);
	   sum=money-charge;
	   System.out.println("��"+"       "+"��"+"      "+"��"+sum);
       System.out.println("��ӭ���´�������");
       System.out.println("���������ѽ�����100����Բμӱ���ĳ齱������ذ�8��");
	   System.out.println("---------------------");
     }
     //����
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
    	 System.out.println("����"+"\t"+"����");
    	 for (int i = 0; i < count1.length; i++) {
    	
    		 if(name6[i]!=null){
    		   
			   System.out.println(count1[i]+"\t"+"��"+name6[i]+"��");
    		 }
		 }
    	 System.out.println("---------------------");
     }
    //��
     public void huaiPaiHang(){
    	 System.out.println("---------------------");
    	 String []  name6= new String [50];
    	 int []  p1 = new int [50];
    	 for (int i = 0; i < name6.length; i++) {
			 
				 name6[i]=dvd.name[i];
				 p1[i]=dvd.p[i];
			
		 }
    	
    	 for (int i = 0; i < name6.length-1; i++) {
			for (int j = 0; j < name6.length-i-1; j++) {
				if(p1[j]>p1[j+1]){
					int temp=p1[j];
					p1[j]=p1[j+1];
					p1[j+1]=temp;
					String tem=name6[j];
					name6[j]=name6[j+1];
					name6[j+1]=tem;
				}
			}
		 }
    	 System.out.println("�𻵳̶�<1Ϊ��>"+"\t"+"����");
    	 for (int i = 0; i < name6.length; i++) {
    		 if(name6[i]!=null){
	    		   
				   System.out.println(p1[i]+"\t\t"+"��"+name6[i]+"��");
	    		 }
		}
    	 for (int i = 0; i < p1.length; i++) {
	    		
	           if(dvd.name[i].trim()!=null&&dvd.state[i]==1&&dvd.p[i]>=5){
	    			 System.out.println("��"+dvd.name[i]+"��"+"���Ѿ�����5��,����ɾ����");
	    			
	    			 boolean bl=true;
	    			 while(bl){
	    				 System.out.println("�Ƿ�ɾ��(y/n):");
		    			 String choice=input.next();
		    			 if(choice.equals("y")||choice.equals("n")){
			    			 if(choice.equals("y")){
			    				 System.out.println("--��ɾ��DVD");
					    	     delete();
					    		 returnMain();
					    		 starMenu();
			    				 choice();
					    		 break;
			    				 
			    			 }else if(choice.equals("n")){
			    				 System.out.println("--����0�������˵�");
			    				 returnMain();
			    				 starMenu();
			    				 choice();
			    			 }
		    			 }else{
		    				 System.out.println("�������������:");
		    				 continue;
		    			 }
	    			 }
	    	  }
		 }
    	
     }
    //�齱
     public void  chouJiang(){
    	 int m=0;
    	 if(money>100){
    		 System.out.println("��ӭ�������齱�������");
    		 System.out.println("����1��ʼ�齱");
    		 int v= input.nextInt();
    		 if(v==1){
    			m= s();
    			switch(m){
    			case 1:
    				System.out.println("��ϲ������ˢһ֧");
    				break;
    			case 2:
    				System.out.println("��ϲ����ˮ��һ��");
    				break;
    			case 3:
    				System.out.println("��ϲ����ϴ��ˮһƿ");
    				break;
       		    }
    		 }
    		 
    	 }else{
    		 System.out.println("������ѽ��û�з��ϻ��Ҫ��");
    	 }
     }
     //�����
     public int s(){
    	 int d=0;
    	  d=(int)(Math.random()*2)+1;
          return  d;
     }
     //
     
}
