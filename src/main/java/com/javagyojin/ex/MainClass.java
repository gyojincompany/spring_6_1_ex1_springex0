package com.javagyojin.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String configLocation1 = "classpath:applicationCTX.xml";
		String configLocation2 = "classpath:applicationCTX1.xml";		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());//ȫ�浿
		System.out.println(student1.getAge());//20
		System.out.println(student1.getHobbys());//����,�,��ȭ����
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student studentHong = studentInfo.getStudent();//student1�� studentHong ����
		System.out.println(studentHong.getName());//ȫ�浿
		System.out.println(studentHong.getAge());//20
		System.out.println(studentHong.getHobbys());//����,�,��ȭ����
		
		if(student1.equals(studentHong)) {
			System.out.println("student1�� studentHong�� ���� ��ü�Դϴ�.");
		}
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student2.getName());//�̼���
		System.out.println(student2.getAge());//40
		System.out.println(student2.getHobbys());//Ȱ���...
		
		if(student1.equals(student2)) {
			System.out.println("student1�� student2�� ���� ��ü�Դϴ�.");
		} else {
			System.out.println("student1�� student2�� �ٸ� ��ü�Դϴ�.");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getFather());//���žƺ�
		System.out.println(family.getMother());//���ž���
		System.out.println(family.getSister());//���Ŵ���
		System.out.println(family.getBrother());//���ŵ���
		
		ctx.close();
		
	}

}
