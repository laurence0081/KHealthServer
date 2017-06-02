package com.khealth.user.util;

import java.util.Random;

public class CardMaker {
	
	public String getRandStr(int length) {
		String charValue = "";
	    for (int i = 0; i < length; i++){
			char temp = '0';
			int tempInt = randomInt(0,43);
			if(9 < tempInt && tempInt < 17) tempInt -= 7;
			temp += tempInt;
		    charValue += String.valueOf(temp);
	    }
		return charValue;
	}
	public String getRandCardNo(int length) {
		String charValue = "";
	    for (int i = 0; i < length; i++){
			char temp = '0';
			int tempInt = randomInt(0,9);
			temp += tempInt;
		    charValue += String.valueOf(temp);
	    }
		return charValue;
	}
	
	 public int randomInt(int from, int to){
		  Random r = new Random();
		  return from + r.nextInt(to - from);
	}
	 
	/*public int createCards(int num, int type){
		int result = 0;		
		Account account = null;
		CardMaker cm = new CardMaker();
		
		for(int i = 0; i < num; i++){
			account = new Account();
			account.setAccount("BJ01612"+cm.getRandCardNo(9));
			account.setPassword(cm.getRandStr(16));
			account.setState(0);
			account.setType(type);
		}
		
		
		return result;
	}*/
	 
	public static void main(String[] args){
		CardMaker cm = new CardMaker();

		System.out.println(cm.getRandCardNo(9) + "          " + cm.getRandStr(16));		
	}
}
