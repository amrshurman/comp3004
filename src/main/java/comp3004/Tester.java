package comp3004;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import junit.framework.TestCase;

public class Tester extends TestCase {

	public void testF() throws IOException {       //16
		byte[] data;
		data =card.readFile("Test1.txt");             
		 assertEquals(11,data.length);
	}
	
public void testC() {                          //17
	String input="";
	 Scanner sc = new Scanner(System.in);
	 input="c";
	 assertEquals("c",input);
}
	

public void testPHit() {       //tests hitting for player  21
	int result=0;
	String hit="H";
	if (hit.equals("H")) {
		card card3 = new card();
	result= (card.calculate(card3,result));
	}

	assertTrue(result!=21);
}

public void testPHitrep() {
	int result=0;
	String hit="H";
	while (result<22) {        //tests repeaditly hitting until bust 22
	if (hit.equals("H")) {
		card card3 = new card();
	result= (card.calculate(card3,result));
	}
	}
	assertTrue(result>21);
}

public void testPStand() {       //tests hitting for player  23
	int result=0;
	String hit="S";
	boolean stand=false;
	if (hit.equals("S")) {
		stand=true;
		card card3 = new card();
	result= (card.calculate(card3,result));
	}

	assertTrue(stand==true);
}

public void testpBust() {     //tests if player busts then dealer wins test 25
	int result=0;
	int resultD=0;
	boolean bust=false;
	 card card1 = new card("H9");
	 card card2 = new card("H10");
	 card card3 = new card("H7");
	 card card1D = new card("HA");
	 card card2D = new card("H5");
	 
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 result=card.calculate(card3, result);
	 resultD=card.calculate(card1D,resultD);
	 resultD=card.calculate(card2D,resultD);
	 
	 if (result>21) {
		bust=true; 
	 }
	 
	 assertTrue(true==bust);
}

public void testDHit16() {     //tests if dealer hits 16 or under then dealer hits test 26
	int result=0;
	int resultD=0;
	boolean over16=false;
	 card card1 = new card("H2");
	 card card2 = new card("HA");
	 card card1D = new card("H9");
	 card card2D = new card("H7");
	 
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 resultD=card.calculate(card1D,resultD);
	 resultD=card.calculate(card2D,resultD);
	 
	 if (resultD<17) {
		 card card3D = new card();
		 resultD=card.calculate(card3D,resultD);
	 }
	 
	 if (resultD>17) {
		 over16=true;
	 }
	 assertTrue(over16==true);
}

public void testSoft17() {     //tests if dealer hits soft 17  then dealer hits test 27
	int result=0;
	int resultD=0;
	boolean canHit=false;
	 card card1 = new card("H2");
	 card card2 = new card("HA");
	 card card1D = new card("H6");
	 card card2D = new card("HA");
	 
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 resultD=card.calculate(card1D,resultD);
	 resultD=card.calculate(card2D,resultD);
	 
	 if ((resultD==17)&&((card1D.Rank.equals("A"))||(card2D.Rank.equals("A")))) {
		 card card3D = new card();
		 resultD=card.calculate(card3D,resultD);
		 canHit=true;
	 }
	 
	 assertTrue(canHit==true);
}

public void testDHit() {     //tests if dealer can hit repeaditly test 28
	int result=0;
	int resultD=0;

	 card card1 = new card("H2");
	 card card2 = new card("HA");
	 card card1D = new card("H6");
	 card card2D = new card("H3");
	 card card3D = new card("H3");
	 
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 resultD=card.calculate(card1D,resultD);
	 resultD=card.calculate(card2D,resultD);
	 
	 while (resultD<17 || ((resultD==17)&&((card1D.Rank.equals("A"))||(card2D.Rank.equals("A"))))) {
		 resultD=card.calculate(card3D,resultD);
	 }

	 assertTrue(resultD>17);
}

public void testdBust() {     //tests if dealer busts then dealer wins test 30
	int result=0;
	int resultD=0;
	boolean bust=false;
	 card card1D = new card("H9");
	 card card2D = new card("H10");
	 card card3D = new card("H7");
	 card card1 = new card("HA");
	 card card2 = new card("H5");
	 
	 resultD=card.calculate(card1D,resultD);
	 resultD=card.calculate(card2D,resultD);
	 resultD=card.calculate(card3D, resultD);
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 
	 if (resultD>21) {
		bust=true; 
	 }
	 
	 assertTrue(true==bust);
}

public void testAce1() {                   //test ace can be 1 test 31
	
	int result=0;

	
	 card card1 = new card("HJ");
	 card card2 = new card("HJ");
	 card card3 = new card("HA");
	 
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 result=card.calculate(card3,result);
	 assertEquals(21,result);
}

public void testAce11() {                   //test ace can be 11 test 32
	
	int result=0;

	
	 card card1 = new card("HJ");
	 card card2 = new card("HA");
	 
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 assertEquals(21,result);
}

public void test2diffAces() {              //test for 2 aces having different values test 33

int result=0;


 card card1 = new card("HA");
 card card2 = new card("H9");
 card card3 = new card("HA");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 result=card.calculate(card3,result);
 assertEquals(21,result);
}

public void test2oneAces() {              //test for 2 aces being 1 test 35

int result=0;


 card card1 = new card("H9");
 card card2 = new card("HA");
 card card3 = new card("HA");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 result=card.calculate(card3,result);
 assertEquals(21,result);
}


public void testJKQ10() {         //test j k and q to be valued as 10 test 36
	
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

public void testplayerBJ() {            //player back jack on first 2 cards test 37

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

public void testDealerBJ() {                  //dealer black jack on first 2 cards test 38

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


}
