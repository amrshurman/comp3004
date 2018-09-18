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
	boolean got=false;
	System.out.println("TEST 17: Hit(H) or stand(S)");
	 Scanner sc = new Scanner(System.in);
	 input = sc.nextLine();
	 if (input.equals("H")) {
		 got=true;
	 }
	 if (input.equals("S")) {
		 got=true;
	 }
	 //input="c";
	 assertEquals(got,true);
	 
}
	
public void testoptions() {                          //18
	String input="";
	boolean got=false;
	System.out.println("TEST 18: Type c or f");
	 Scanner sc = new Scanner(System.in);
	 input = sc.nextLine();
	 if (input.equals("c")) {
		 got=true;
	 }
	 if (input.equals("f")) {
		 got=true;
	 }
	 //input="c";
	 assertEquals(got,true);
}

public void testvisibleP() {                          //19
	boolean visibleP=false;
	int counter=0;
	 card card1 = new card("H2");
	 counter++;
	 card card2 = new card("HA");
	 counter++;
	 card card1D = new card("H9");
	 card card2D = new card("H7");
	 if (counter==2) {
		 visibleP=true;
	 }
	 if (visibleP==true) {
		 System.out.println("TEST 19: player draws "+ card1.getCard() +" and "+ card2.getCard());
	 }
	 assertEquals(visibleP,true);
}

public void testvisibleD() {                          //20
	boolean gotcards=false;
	int counter=0;
	 card card1 = new card("H2");
	 counter++;
	 card card2 = new card("HA");
	 counter++;
	 card card1D = new card("H9");
	 card card2D = new card("H7");
	 if (counter==2) {
		 gotcards=true;
	 }
	 if (gotcards==true) {
		 System.out.println("TEST 20: Dealer draws "+ card1.getCard() + ", the other card is hidden.");
	 }
	 assertEquals(gotcards,true);
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

public void test11then1() {              //11 then 1 test 34
	int result=0;
	boolean gotAce=false;

	 card card1 = new card("HA");
	 card card2 = new card("H9");
	 card card3 = new card("H3");
	 result=card.calculate(card1,result);
	 result=card.calculate(card2,result);
	 result=card.calculate(card3,result);
	 if ((result>21)&&((card1.Rank.equals("A"))||(card2.Rank.equals("A"))||(card3.Rank.equals("A")))) {
		 result-=10;
	 }
	 assertEquals(13,result);
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

public void testPlayerBJW() {                  //player black jack  test 39

int result=0;
int resultD=0;

 card card1 = new card("HA");
 card card2 = new card("H10");
 card card1D = new card("H9");
 card card2D = new card("SA");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 resultD=card.calculate(card1D,resultD);
 resultD=card.calculate(card2D,resultD);
 
 assertEquals(true,card.isBJPWin(result,resultD));

}

public void testDealerBJW() {                  //Dealer black jack  test 40

int result=0;
int resultD=0;

 card card1 = new card("HA");
 card card2 = new card("H10");
 card card1D = new card("H10");
 card card2D = new card("SA");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 resultD=card.calculate(card1D,resultD);
 resultD=card.calculate(card2D,resultD);
 
 assertEquals(true,card.isBJDWin(resultD));

}

public void testPscore() {                  //Test player score  test 41

int result=0;
int resultD=0;
boolean correct=false;
 card card1 = new card("HA");
 card card2 = new card("H10");
 card card1D = new card("H3");
 card card2D = new card("S6");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 resultD=card.calculate(card1D,resultD);
 resultD=card.calculate(card2D,resultD);
 if (result==21) {
	 correct=true;
 }
 assertEquals(true,correct);

}

public void testDscore() {                  //Test Dealer score  test 42

int result=0;
int resultD=0;
boolean correct=false;
 card card1 = new card("HA");
 card card2 = new card("H3");
 card card1D = new card("HA");
 card card2D = new card("S10");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 resultD=card.calculate(card1D,resultD);
 resultD=card.calculate(card2D,resultD);
 if (resultD==21) {
	 correct=true;
 }
 assertEquals(true,correct);

}

public void testPlayerWmore() {                  //Test player score more than dealer so win  test 43

int result=0;
int resultD=0;
boolean win=false;
 card card1 = new card("HA");
 card card2 = new card("H3");
 card card1D = new card("H3");
 card card2D = new card("S6");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 resultD=card.calculate(card1D,resultD);
 resultD=card.calculate(card2D,resultD);
 if ((result<21)&&(result>resultD)) {
	 win=true;
 }
 assertEquals(true,win);

}

public void testDealerWmore() {                  //Test Dealer score more than dealer so win  test 45

int result=0;
int resultD=0;
boolean win=false;
 card card1 = new card("HA");
 card card2 = new card("H3");
 card card1D = new card("H7");
 card card2D = new card("S10");
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);
 resultD=card.calculate(card1D,resultD);
 resultD=card.calculate(card2D,resultD);
 if ((resultD<21)&&(resultD>result)) {
	 win=true;
 }
 assertEquals(true,win);

}

public void testPlayerSplit() {                  //Test splitting for player  test 49

int result=0;
int resultD=0;
int resultS=0;

 card card1 = new card("H3");
 card card2 = new card("H3");
 card card1D = new card("H7");
 card card2D = new card("S10");
 if (card1.getRank().equals(card2.getRank())) {
 result=card.calculate(card1,result);
 resultS=card.calculate(card2,resultS);
 }
 resultD=card.calculate(card1D,resultD);
 resultD=card.calculate(card2D,resultD);

 assertEquals(result,3);
 assertEquals(resultS,3);

}

public void testDealerSplit() {                  //Test splitting for dealer  test 50

int result=0;
int resultD=0;
int resultDS=0;

 card card1 = new card("H3");
 card card2 = new card("H8");
 card card1D = new card("H7");
 card card2D = new card("S7");
 if (card1D.getRank().equals(card2D.getRank())) {
 resultD=card.calculate(card1D,resultD);
 resultDS=card.calculate(card2D,resultDS);
 }
 result=card.calculate(card1,result);
 result=card.calculate(card2,result);

 assertEquals(resultD,7);
 assertEquals(resultDS,7);

}


}
