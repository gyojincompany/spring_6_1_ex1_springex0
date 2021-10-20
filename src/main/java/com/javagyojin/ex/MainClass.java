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
		System.out.println(student1.getName());//홍길동
		System.out.println(student1.getAge());//20
		System.out.println(student1.getHobbys());//수영,운동,영화감상
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student studentHong = studentInfo.getStudent();//student1과 studentHong 같음
		System.out.println(studentHong.getName());//홍길동
		System.out.println(studentHong.getAge());//20
		System.out.println(studentHong.getHobbys());//수영,운동,영화감상
		
		if(student1.equals(studentHong)) {
			System.out.println("student1과 studentHong은 같은 객체입니다.");
		}
		
		Student student2 = ctx.getBean("student2", Student.class);
		System.out.println(student2.getName());//이순신
		System.out.println(student2.getAge());//40
		System.out.println(student2.getHobbys());//활쏘기...
		
		if(student1.equals(student2)) {
			System.out.println("student1과 student2는 같은 객체입니다.");
		} else {
			System.out.println("student1과 student2는 다른 객체입니다.");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getFather());//순신아빠
		System.out.println(family.getMother());//순신엄마
		System.out.println(family.getSister());//순신누나
		System.out.println(family.getBrother());//순신동생
		
		ctx.close();
		
	}

}
