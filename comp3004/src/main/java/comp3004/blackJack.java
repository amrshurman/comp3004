package comp3004;


import java.io.IOException;
import java.util.*;

	
public class blackJack extends card{

	public static void main(String[] args) throws IOException {
		boolean breaked=false;
		boolean bust=false;
		boolean bustD=false;
		boolean soft17=false;
		boolean split=false;
		boolean splitD=false;
		boolean splitBust=false;

		int result=0;
		int resultS=0;
		int resultD=0;
		int resultDS=0;
	String input;
	 Scanner sc = new Scanner(System.in);
	
	 System.out.println("Do you wish to use console(c) or file(f) mode?");
	 input = sc.nextLine();
	 if (input.equals("c")) {		 
	 card card1 = new card();
	 card card2 = new card();
	card1.Rank="2";
	card2.Rank="2";
	card1.Card="H2";
	card2.Card="H2";
	 card cardD1 = new card();
	 card cardD2 = new card();
	
	System.out.println("Dealer has drawn a " + cardD1.getCard()+ ", the other card he drew is hidden for now.");
	System.out.println("Your first card acquired is "+card1.getCard());
	System.out.println("Your second card acquired is " + card2.getCard());
	
 if (card1.getRank()==card2.getRank()) {
	System.out.println("Since you got 2 identical ranked cards, you can split, do you wish to split(D)?");	
	 input = sc.nextLine();
	 if (input.equals("D")) {	
		 split=true;
	 }
	 }
	
 if (cardD1.getRank()==cardD2.getRank()) {
	 splitD=true;
 }
 
 if (splitD==false) {
 resultD=calculate(cardD1,resultD);
 resultD=calculate(cardD2,resultD);
 }
 if (splitD==true) {
	 resultD=calculate(cardD1,resultD);
	 resultDS=calculate(cardD2,resultDS);
 }
 
	if (split==false) {
	result=calculate(card1,result);
	result=calculate(card2,result);
	}
	
	 if (split==true) {
		 result=calculate(card1,result);
		 resultS=calculate(card2,resultS);
	 }
	
	System.out.println("Total : " + result);
	while (true) {
		if ((result==21)||(resultS==21)) {
			System.out.println("You got BlackJack!");
			break;
		}
		else if ((result<21)&&(resultD<21)&&(split==false)){
			
				
	System.out.println("Hit(H) or Stand(S)?");
	input = sc.nextLine();
	if (input.equals("H")) {
		card card3 = new card();
	System.out.println(card3.getCard());
	result= (calculate(card3,result));
	System.out.println("Total : " + result);
	}
	else {
		System.out.println("You stand");
		break;
	}
	}
		
		else if ((result<21)&&(resultS<21)&&(resultD<21)&&(split==true)){
			while ((splitBust==false)&&(result<21)) {
			System.out.println("For First try within the split");
			System.out.println("Hit(H) or Stand(S)?");
			input = sc.nextLine();
			if (input.equals("H")) {
				card card3 = new card();
			System.out.println(card3.getCard());
			result= (calculate(card3,result));
			System.out.println("Total : " + result);
			if (result>21) {
				System.out.println("you bust on this try");
				System.out.println("");
			}
			}   
			else {
				System.out.println("You stand");
				System.out.println("");
				splitBust=true;
			}   
	}
			splitBust=false;
			while ((splitBust==false)&&(resultS<21)) {
				System.out.println("For Second try within the split");
				System.out.println("Hit(H) or Stand(S)?");
				input = sc.nextLine();
				if (input.equals("H")) {
					card card3 = new card();
				System.out.println(card3.getCard());
				resultS= (calculate(card3,resultS));
				System.out.println("Total : " + resultS);
				if (resultS>21) {
					System.out.println("you bust on this try");
				}
				}
				else {
					System.out.println("You stand");
					splitBust=true;
					break;
				}
				
			}
			break;
		}
		
	else {
		System.out.println("You break");

		breaked=true;
		break;
	
	}
	}
	while (true) {
		if (breaked==true) {
			System.out.println("Dealer wins because you bust.");
			break;
		}
		else if (resultD==21){
		System.out.println("Dealer wins with BlackJack");
		break;
	}
	else if ((resultD>result)&&(resultD<22)) {
		System.out.println("Dealer wins with " + resultD);
		break;
	}
	else if ((resultD<17)||(soft17==true)) {
		card cardD3 = new card();
		System.out.println("Dealer has drawn "+ cardD3.getCard());
		resultD= (calculate(cardD3,resultD));
		System.out.println("Dealer has a Total : " + resultD);
	}
	else if (resultD>21) {
		System.out.println("Dealer busts, you win");
		break;
	}
	else {
		System.out.println("Dealer stands with " + resultD);
		if (((result>resultD)&&(result<22))||((resultS>resultD)&&(resultS<22))) {
			System.out.println("You win by having a closer number to 21.");
		break;
		}
		System.out.println("Dealer wins by having a closer number to 21.");
		break;
	}
	}
	} 
	 
	 ////////////////////////////////////////////////////FILE
	 
	 else if (input.equals("f")) {
		 byte[] data;
		 int count = 0;
		 System.out.println("Enter the name of the file you want to read.");
		 input = sc.nextLine();
		 data=readFile(input);
		 String decryptedMsg = new String(data,0,data.length);
		 System.out.println(decryptedMsg);
		 
		 String Card1str=new String(data,0,2);
		 if (decryptedMsg.charAt(2)=='0') {
			 Card1str=new String(data,count,3);
			 count++;
		 }
		 count+=3;
		 String Card2str=new String(data,count,2);
		 if (decryptedMsg.charAt(count+2)=='0')  {
			 Card2str=new String(data,count,3);
			 count++;
		 }
		 count+=3;
		 String CardD1str=new String(data,count,2);
		 if (decryptedMsg.charAt(count+2)=='0')  {
			 CardD1str=new String(data,count,3);
			 count++;
		 }
		 count+=3;
		 String CardD2str=new String(data,count,2);
		 if (count+2<data.length) {

		 if (decryptedMsg.charAt(count+2)=='0'){
			 CardD2str=new String(data,count,3);
			 count++;
		 }
		 }
		 count+=3;

		 card cardD1= new card(CardD1str);
		 card cardD2= new card(CardD2str);
		 card card1= new card(Card1str);
		 card card2= new card(Card2str);
		 
		 System.out.println("You drew " +translater(Card1str)+ " as your first card.");
		 System.out.println("You drew " +translater(Card2str)+ " as your second card.");
		 System.out.println("The Dealer drew " +translater(CardD1str)+ " as their first card.");
		 System.out.println("You Dealer drew " +translater(CardD2str)+ " as their second card.");
		 
		 resultD=calculate(cardD1,resultD);
		 resultD=calculate(cardD2,resultD);
		 result=calculate(card1,result);
		 result=calculate(card2,result);
		 System.out.println("Total : " + result);
		 while (true) {
		 if (result==21) {
			 System.out.println("You got a BlackJack!");
			 
		 }
		 else if (resultD==21) {
			 System.out.println("Dealer got a BlackJack! , therefore, he wins!");
			 break;
		 }
			else if ((result<21)&&(resultD<21) && (data.length>=count+2)){
				
				if (decryptedMsg.charAt(count)== 'S') {
					System.out.println("Player stands");
					count+=2;
				}
				
				else if (decryptedMsg.charAt(count)== 'H') {
					while (true) {
						if (decryptedMsg.charAt(count)== 'H') {
					System.out.println("Player hits");
					count+=2;
					card card4 = new card(new String (data,count,2));
					System.out.println("Player draws " + translater(card4.getCard()));
					result= (calculate(card4,result));
					if (result<=21) {
					System.out.println("Total : " + result);
					count+=3;
					}
				}
						else {
							System.out.println("Player busts with "+ result);
							break;
						}
				}
				}
				
				else {
					card card3 = new card(new String (data,count,2));
					System.out.println("Player draws " + translater(card3.getCard()));
					result= (calculate(card3,result));
					if (result<=21) {
					System.out.println("Total : " + result);
					count+=3;
					}
					else {
						System.out.println("Player busts with " + result + " .");
						bust=true;
					}
				}
				
				
				
	 }
		 		if (data.length>=count+2) {
		 			
		 			if (decryptedMsg.charAt(count)== 'S') {
						System.out.println("Dealer stands");
						count+=2;
					}
		 			else if (decryptedMsg.charAt(count)== 'H') {
						while (true) {
							if (decryptedMsg.charAt(count)== 'H') {
						System.out.println("Dealer hits");
						count+=2;
						card card4 = new card(new String (data,count,2));
						System.out.println("Dealer draws " + translater(card4.getCard()));
						result= (calculate(card4,resultD));
						if (resultD<=21) {
						System.out.println("Total : " + resultD);
						count+=3;
						}
					}
							else {
								break;
							}
					}
					}
					else {
						card cardD3 = new card(new String (data,count,2));
						System.out.println("Dealer draws " + translater(cardD3.getCard()));
						resultD= (calculate(cardD3,resultD));
						if (resultD<=21) {
						System.out.println("Total : " + resultD);
						count+=3;
						}
						else {
							System.out.println("Dealer busts with " + resultD + " .");
							bustD=true;
							break;
						}
					}
		 		}
		 		

		 		if ((result>resultD)||(bustD==true)) {
		 			System.out.println("Player wins");
		 			break;
		 		}
		 		else if ((resultD>result)||(bust==true)) {
		 			System.out.println("Dealer wins.");
		 			break;
		 		}
	 }
		 
	 }
	}
}  
