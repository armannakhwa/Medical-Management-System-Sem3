import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



class login extends JFrame implements ActionListener
{

JLabel username=new JLabel("Enter username");
JLabel password=new JLabel("Enter password");

JTextField user=new JTextField();
JPasswordField pass = new JPasswordField();  

JButton submit=new JButton("Login");



login()
{
	
setLayout(null);
setVisible(true);
setSize(600,400);
setTitle("Medical Management System Login");



ImageIcon img = new ImageIcon("medical.png","Something Error");
JLabel image = new JLabel(img);
image.setBounds(2,0,680,70);
    add(image);

username.setBounds(20,80,120,40);
add(username);


password.setBounds(20,110,90,20);
add(password);



user.setBounds(150,90,90,20);
user.setToolTipText("Enter username Here"); 
add(user);


pass.setBounds(150,120,90,20);
pass.setToolTipText("Enter password Here"); 
add(pass);

  

submit.setBounds(150,200,90,30);
add(submit);

submit.addActionListener(this);
}
public void actionPerformed(ActionEvent e)
{
if(user.getText().equals("famt") && String.valueOf(pass.getText()).equals("famtAV"))
{
new screen();
}
else
{
JOptionPane.showMessageDialog(this,user.getText()+"Invalid Input");
}
}
}

class screen extends JFrame implements ActionListener
{
	JButton sbmt,asbmt,settingbtn;
Label hb=new Label("Cliked Checking");

Label medical_name_e=new Label("Enter Medical Name: ");
Label medical_address_e=new Label("Enter Medical Address: ");
Label medical_phone_e=new Label("Enter Medical Phone: ");



JLabel medical_name=new JLabel("Enter Medical Name");
JLabel medical_address=new JLabel("Enter Medical Address");
JLabel medical_phone=new JLabel("Enter Medical Phone/mbl");



TextField medical_namet_e=new TextField();
TextField medical_addresst_e=new TextField();
TextField medical_phonet_e=new TextField();
TextField p_name,p_price,p_quantity;  

//For Sale product
TextField p_id=new TextField("1");
TextField p_q=new TextField("2");
TextField p_p=new TextField("3");
Choice p_n=new Choice();


//******************************method add choice data */
 public static String[] add(String[] originalArray, String newItem)
{
    int currentSize = originalArray.length;
    int newSize = currentSize + 1;
    String[] tempArray = new String[ newSize ];
    for (int i=0; i < currentSize; i++)
    {
        tempArray[i] = originalArray [i];
    }
    tempArray[newSize- 1] = newItem;
    return tempArray;   
}
//******************************End method  add choice data */


screen()
{
    JPanel p1=new JPanel();   
    JPanel p2=new JPanel();  
    JPanel p3=new JPanel();  
    JPanel p5=new JPanel();  
 JPanel p6=new JPanel();  

ImageIcon img = new ImageIcon("medical2.png","Something Error");
JLabel image = new JLabel(img);
image.setBounds(2,5,680,90);
   

//***************************Get Data and Set Medical Name,Address Mob *******************/
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/JAVAMP","root","");  
Statement stmt=con.createStatement();  
ResultSet rs7=stmt.executeQuery("select * from Medical_Info");  

while(rs7.next())  
{

medical_name.setText(rs7.getString(2));
medical_address.setText(rs7.getString(3));
medical_phone.setText(rs7.getString(4));
}
con.close();  }
catch(Exception e2){ System.out.println(e2);}  
//***************************End Get Data and Set Medical Name,Address Mob *******************/



medical_name.setBounds(300,10,280,30);
medical_name.setForeground(Color.red);
Font font = new Font("Aharoni", Font.BOLD,20);
medical_name.setFont(font);
add(medical_name);



medical_address.setBounds(300,40,280,30);
medical_address.setForeground(Color.red);
medical_address.setFont(font);
add(medical_address);



medical_phone.setBounds(300,70,280,30);
medical_phone.setForeground(Color.red);
medical_phone.setFont(font);
add(medical_phone);

 add(image);

    JTabbedPane tp=new JTabbedPane();  
    tp.add("Sale",p1);  
    tp.add("add Product",p2);  
    tp.add("view product Records",p3);
    tp.setBounds(20,120,500,400);
    tp.add("view sale Records",p6);    
    tp.add("Setting",p5);     
    add(tp);  
    setSize(700,700);  
    setLayout(null);  
    setVisible(true);  


//**************************************************Sale Product fields*********************** */
p1.setLayout(null);

Label Product_id=new Label("Customer Name");
Product_id.setBounds(5,5,95,20);
//Choice p_id=new Choice();
p_id=new TextField("");
p_id.setBounds(125,10,190,24);


Label Product_name=new Label("Product Name");
Product_name.setBounds(5,50,90,20);
//_n=new Choice();
p_n.setBounds(120,50,190,2);

Label Product_quantity=new Label("Quantity");
Product_quantity.setBounds(5,100,90,20);
//p_q=new TextField("1");
p_q.setBounds(120,100,190,20);


Label Product_price=new Label("Price");
Product_price.setBounds(5,150,90,20);
//p_p=new TextField("1");
//p_p.setEditable(false);
//p_p.setText(String.valueOf((Math.floor(Math.random()*500+1))));
p_p.setBounds(120,150,190,20);


sbmt=new JButton("Sale");
sbmt.setBounds(120,200,90,20);

sbmt.addActionListener(this);
//**************************************************End Sale Product fields*********************** */



//***************************************************get Data from DB and Add Data To Choice List******************** */


//String a[]={"Acetaminophen","Adderall","Alprazolam","Amitriptyline","Amlodipine","Amoxicillin","Ativan","Atorvastatin","Azithromycin","Ciprofloxacin","Citalopram","Clindamycin","Clonazepam"};
String a[]={""};


try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/JAVAMP","root","");  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from Medical");  
int pc=1;
while(rs.next())  
{
a=add(a,rs.getString(2));
}
con.close();}catch(Exception e){ System.out.println(e);}  



for(int i=0;i<a.length;i++)
{
p_n.add(a[i]);
//p_id.add(String.valueOf(i));
}

//***************************************************End get Data from DB and Add Data To Choice List******************** */

p1.add(Product_id);
p1.add(p_id);

p1.add(Product_name);
p1.add(p_n);

p1.add(Product_quantity);
p1.add(p_q);
p1.add(Product_price);
p1.add(p_p);
p1.add(sbmt);





//****************************************Add Product***********************************************************************

p2.setLayout(null);

/*
Label a_id=new Label("Product id");
a_id.setBounds(5,5,90,20);
TextField a_id1=new TextField();
a_id1.setBounds(120,5,90,20);
*/


Label a_n=new Label("Product Name");
a_n.setBounds(5,50,90,20);
p_name=new TextField();
p_name.setBounds(120,50,190,20);


Label a_q=new Label("Quantity");
a_q.setBounds(5,100,90,20);
p_quantity=new TextField();
p_quantity.setBounds(120,100,190,20);


Label a_p=new Label("Price");
a_p.setBounds(5,150,90,20);
p_price=new TextField();
p_price.setBounds(120,150,190,20);


asbmt=new JButton("ADD Product");
asbmt.setBounds(120,200,110,20);
asbmt.addActionListener(this);
/*
p2.add(a_id);
p2.add(a_id1);
*/

p2.add(a_n);
p2.add(p_name);

p2.add(a_q);
p2.add(p_quantity);

p2.add(a_p);
p2.add(p_price);

p2.add(asbmt);

//****************************************End Add Product***********************************************************************


p5.setLayout(null);
medical_name_e.setBounds(5,5,140,20);

medical_namet_e.setBounds(160,5,120,20);


medical_address_e.setBounds(5,55,140,20);
medical_addresst_e.setBounds(160,55,120,20);



medical_phone_e.setBounds(5,100,140,20);
medical_phonet_e.setBounds(160,100,120,20);

p5.add(medical_name_e);
p5.add(medical_namet_e);

p5.add(medical_address_e);
p5.add(medical_addresst_e);

p5.add(medical_phone_e);
p5.add(medical_phonet_e);

settingbtn=new JButton("Update");
settingbtn.setBounds(220,200,90,20);

p5.add(settingbtn);
settingbtn.addActionListener(this);




//**************************************************Add Product*********************** */
//System.out.println(ProductData);  
    DefaultTableModel tm=new DefaultTableModel();
   JTable j= new JTable(tm); 

   //Add Colums
    tm.addColumn("Product id");
    tm.addColumn("Product name");  
    tm.addColumn("Available Quantity");
    tm.addColumn("Price");



try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/JAVAMP","root","");  
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from Medical");  

while(rs.next())  
{

tm.insertRow(tm.getRowCount(),new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
}

con.close();  }
catch(Exception e){ System.out.println(e);}  


        JScrollPane sp = new JScrollPane(j); 
        p3.add(sp); 



//**********************************************View Sale Product Record */
//**************************************************Add Product*********************** */
//System.out.println(ProductData);  
    DefaultTableModel tm1=new DefaultTableModel();
   JTable j1= new JTable(tm1); 

   //Add Colums
    tm1.addColumn("Customer id");
     tm1.addColumn("Customer Name");
    tm1.addColumn("Product name");  
    tm1.addColumn("Quantity");
    tm1.addColumn("Price");



try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con1=DriverManager.getConnection("jdbc:mysql://localhost/JAVAMP","root","");  
Statement stmtt=con1.createStatement();  
ResultSet rss=stmtt.executeQuery("select * from Sale");  

while(rss.next())  
{

tm1.insertRow(tm1.getRowCount(),new Object[]{rss.getString(1),rss.getString(2),rss.getString(3),rss.getString(4),rss.getString(5)});
}

con1.close();  }
catch(Exception ue){ System.out.println(ue);}  


        JScrollPane sp1 = new JScrollPane(j1); 
        p6.add(sp1); 

}


public void actionPerformed(ActionEvent e)
{

if(e.getActionCommand().equals("ADD Product"))
{

try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/JAVAMP","root","");  
Statement stmt2=con.createStatement();  
stmt2.executeUpdate("insert into Medical values(null,'"+p_name.getText()+"',"+p_quantity.getText()+","+p_price.getText()+")");  

JOptionPane.showMessageDialog(this,"Product add Sucessfully"+p_name.getText()+" "+p_quantity.getText()+" "+p_price.getText());
JOptionPane.showMessageDialog(this,"Now Our System is Restarting #AN");
System.exit(0);
}
catch(Exception ee)
{

    System.out.println(ee);
}
}
//***************************End Add Product ******************************* */








//***************************Sale Product ******************************* */
else if(e.getActionCommand().equals("Sale"))
{




   System.out.println(p_id.getText()+p_n.getSelectedItem()+p_q.getText()+p_p.getText());


//save into database
try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/JAVAMP","root","");  
Statement stmt2=con.createStatement();  
stmt2.executeUpdate("insert into sale values(null,'"+p_id.getText()+"','"+p_n.getSelectedItem()+"',"+p_q.getText()+","+p_p.getText()+")");  

}
catch(Exception ee)
{

    System.out.println(ee);
}



JOptionPane.showMessageDialog(this,"Product Sale Sucessfully");	
}
//***************************End Sale Product ******************************* */








//***************************Set Data and Set Medical Name,Address Mob *******************/
else
{
medical_name.setText(medical_namet_e.getText());
medical_address.setText(medical_addresst_e.getText());
medical_phone.setText(medical_phonet_e.getText());
try{
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/JAVAMP","root","");  
Statement stmt2=con.createStatement();  
int mid=0;
String sql = "UPDATE  Medical_Info set Medical_Name='"+medical_namet_e.getText()+"',Medical_Address='"+medical_addresst_e.getText()+"',Medical_Mobile="+medical_phonet_e.getText()+" where medical_id=0";
stmt2.executeUpdate(sql);

JOptionPane.showMessageDialog(this,"Data Updated Succesfully");
}
catch(Exception ee)
{

    System.out.println(ee);
}

//***************************Set Data and Set Medical Name,Address Mob *******************/



}
}
}




public class mainp{
public static void main(String args[])
{


new login();

//new screen();
 


}
}