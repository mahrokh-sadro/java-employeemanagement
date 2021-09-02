//https://www.youtube.com/watch?v=U3Ibvu0htNs&list=PLG7VJOKS5_G0usTijS3rIIRiCF32v5uHq&index=2

package emailApp;

import java.util.Scanner;
import java.lang.Math;


public class Email {
	private String m_firstname;
	private String m_lastname;
	private String m_department;
	private String m_password;
	private String m_email;
	private int m_passwordLength=8;
	private int m_mailBoxCap=500;
	private String m_emailSuffix="myCompany.com";
	private String m_alternativeEmail;
	
	public Email(String fname,String lname) {
		m_firstname=fname;
		m_lastname=lname;
		m_department=setDepartment();
		m_password=generatePassword(m_passwordLength);
		m_email=setEmail();
	}
	
	private String setDepartment() {
		System.out.println("Enter 1 for Sales\n 2 for Development\n 3 for Accounting\n 0 for Exit\n enter: ");
		Scanner input=new Scanner(System.in);
		int choice=input.nextInt();
		String ret;
		if(choice==1) ret="Sales";
		else if(choice==2) ret="Development";
		else if(choice==3) ret="Accounting";
		//else if(choice==0) ret="Sales";
		else ret="";
		//System.out.println("ur department is "+ choice);

		return ret;
	}
	
	private String generatePassword(int length) {
	
		String base="qwertyuioplkjhgfdsazxcvbnm1234567890!@#$%^&*";
		char[] password=new char[m_passwordLength];
		for(int i=0;i<m_passwordLength;i++) {
			int randomIndex=(int)(Math.random()*base.length());
			password[i]=base.charAt(randomIndex);
			
		}
		String ret=password.toString();
		//System.out.println("pass is "+ret);
		return ret;
	}
	
//	private int setPasswordLength() {
//		System.out.println("enter the length,greater than 6 :");
//		Scanner input=new Scanner(System.in);
//		int length=input.nextInt();
//		System.out.println("ur pass length is "+length);
//		return length;
//	}
//	
	
	private String setEmail() {
		String ret=m_firstname.toLowerCase()+"-"+m_lastname.toLowerCase()+"@"+m_department+"-"+m_emailSuffix;
		//System.out.println("ur email is "+ret);
		return ret;
	}
	
	public void setMailBoxCap(int capacity) {
		m_mailBoxCap=capacity;
	}
	
	public void setAlternativeEmail(String email) {
		m_email=email;
	}
	
	public void setNewPassword(String password) {
		m_password=password;
	}
	
	public int getMailboxCapacity() {
		return m_mailBoxCap;
	}
	
	public String getAlternativeEmail() {
		return m_alternativeEmail;
	}
	
	//do we need getpass?
	
	public void printInfo() {
		System.out.println("name: "+m_firstname+ " "+m_lastname+"\n"+
				           "email: "+ m_email+"\n"+   
				           "department: " + m_department+"\n");
	}
}
