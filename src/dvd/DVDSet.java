package dvd;

public class DVDSet {
    String [] name= new String[50];//名字
    int [] state =new int [50];  //状态
    String [] date =new String [50];//日期
    int [] count = new int [50];  //次数
    
    public void show(){
    	System.out.println("序号"+"\t状态"+"\t名称"+"\t\t借出日期");
    }
    
}
