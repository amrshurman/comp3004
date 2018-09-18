package comp3004;

import java.io.IOException;
import java.util.Scanner;

import junit.framework.TestCase;

public class Tester extends TestCase {

	public void testJKQ10() {
		
		int resultJ=0;
		int resultQ=0;
		int resultK=0;
		
		 card card1 = new card("HJ");
		 card card2 = new card("HQ");
		 card card3 = new card("HK");
		 
		 resultJ=card.calculate(card1,resultJ);
		 resultQ=card.calculate(card2,resultQ);
		 resultK=card.calculate(card3,resultK);
		 assertEquals(10,resultJ);
		 assertEquals(10,resultQ);
		 assertEquals(10,resultK);	
	}
	
	public void testAce1() {
		
		int result=0;

		
		 card card1 = new card("HJ");
		 card card2 = new card("HJ");
		 card card3 = new card("HA");
		 
		 result=card.calculate(card1,result);
		 result=card.calculate(card2,result);
		 result=card.calculate(card3,result);
		 assertEquals(21,result);
	}
	
public void testAce11() {
		
		int result=0;

		
		 card card1 = new card("HJ");
		 card card2 = new card("HA");
		 
		 result=card.calculate(card1,result);
		 result=card.calculate(card2,result);
		 assertEquals(21,result);
	}

public void test2oneAces() {
	
	int result=0;

	
	 card card1 = new card("H9");
	 card card2 = new card("HA");
	 card card3 = new card("HA");
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 result=card.calculate(card3,result);
	 assertEquals(21,result);
}

public void test2diffAces() {
	
	int result=0;

	
	 card card1 = new card("HA");
	 card card2 = new card("H9");
	 card card3 = new card("HA");
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 result=card.calculate(card3,result);
	 assertEquals(21,result);
}

public void testplayerBJ() {
	
	int result=0;
	int resultD=0;
	
	 card card1 = new card("HA");
	 card card2 = new card("H10");
	 card card1D = new card("HA");
	 card card2D = new card("H5");
	 
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 resultD=card.calculate(card1D,resultD);
	 resultD=card.calculate(card2D,resultD);
	 
	 assertEquals(true,card.is21(result));
}

public void testDealerBJ() {
	
	int result=0;
	int resultD=0;
	
	 card card1 = new card("HA");
	 card card2 = new card("H10");
	 card card1D = new card("HQ");
	 card card2D = new card("SA");
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 resultD=card.calculate(card1D,resultD);
	 resultD=card.calculate(card2D,resultD);
	 
	 assertEquals(true,card.is21(resultD));
}

public void testC() {
	String input="";
	 Scanner sc = new Scanner(System.in);
	 //input = sc.nextLine();
	 assertEquals("",input);
}
	
public void testF() throws IOException {
	byte[] data;
	data =card.readFile("Test1.txt");
	 assertEquals(11,data.length);
}

}
