package comp3004;


import java.io.IOException;
import java.util.*;

	
public class blackJack extends card{

	public static void main(String[] args) throws IOException {
		boolean breaked=false;
		boolean bust=false;
		boolean bustD=false;
		boolean split=false;
		boolean splitD=false;
		boolean splitBust=false;
		boolean normal=true;
		boolean normalD=true;
		boolean gotAce=false;
		
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
	 
	 card cardD1 = new card();
	 card cardD2 = new card();
	
//	 cardD1.Rank="2";
	//	cardD2.Rank="2";          TESTING STUFF
		//cardD1.Card="H2";
		//cardD2.Card="H2";
	 
	System.out.println("Dealer has drawn a " + cardD1.getCard()+ ", the other card he drew is hidden for now.");
	System.out.println("Your first card acquired is "+card1.getCard());
	System.out.println("Your second card acquired is " + card2.getCard());
	
 if (card1.getRank()==card2.getRank()) {
	System.out.println("Since you got 2 identical ranked cards, you can split, do you wish to split(D)? press anything else for normal mode.");	
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
	else if ((splitD==true)&&((resultD+resultDS)<17)) {
		System.out.println("Dealer gets 2 identical ranked cards.");
		System.out.println("Dealer decides to split.");
		
		System.out.println("");
		
		card cardD3 = new card();
		System.out.println("For first attempt.");
		System.out.println("Dealer has drawn "+ cardD3.getCard());
		resultD= (calculate(cardD3,resultD));
		System.out.println("Dealer has a Total : " + resultD);
		while ((resultD<21) &&(splitD==true)) {
		 if ((resultD<17)||((resultD==17)&&((cardD1.getRank()=="A")||(cardD3.getRank()=="A")))) {
				card cardD4 = new card();
				System.out.println("Dealer has drawn "+ cardD4.getCard());
				resultD= (calculate(cardD4,resultD));
				System.out.println("Dealer has a Total : " + resultD);
			}
		 else if (resultD>21) {
			 System.out.println("Dealer busts, you win");
		 }
		 else {
			 splitD=false;
		 }
	}
		
		splitD=true;
		card cardD5 = new card();
		System.out.println("For second attempt.");
		System.out.println("Dealer has drawn "+ cardD5.getCard());
		resultDS= (calculate(cardD5,resultDS));
		System.out.println("Dealer has a Total : " + resultDS);
		while ((resultDS<21) &&(splitD==true)) {
		 if ((resultDS<17)||((resultDS==17)&&((cardD2.getRank()=="A")||(cardD5.getRank()=="A")))) {
				card cardD4 = new card();
				System.out.println("Dealer has drawn "+ cardD4.getCard());
				resultDS= (calculate(cardD4,resultDS));
				System.out.println("Dealer has a Total : " + resultDS);
			}
		 else if (resultDS>21) {
			 System.out.println("Dealer busts, you win");
		 }
		 else {
			 splitD=false;
		 }
	}
		
	}
	else if ((resultD<17)||((resultD==17)&&((cardD1.getRank()=="A")||(cardD2.getRank()=="A")))) {
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
		else if ((resultD==21)||(resultDS==21)) {
			System.out.println("Dealer wins with blackjack!.");
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
		 
		 if (cardD1.Rank.equals(cardD2.Rank)) {
			 splitD=true;
			 normal=false;
		 }

		 if (card1.Rank.equals(card2.Rank)) {
			 split=true;
			 normalD=false;
		 }
		 
		 System.out.println("You drew " +translater(Card1str)+ " as your first card.");
		 System.out.println("You drew " +translater(Card2str)+ " as your second card.");
		 System.out.println("The Dealer drew " +translater(CardD1str)+ " as their first card.");
		 System.out.println("You Dealer drew " +translater(CardD2str)+ " as their second card.");
		 
		 if (splitD==false) {
		 resultD=calculate(cardD1,resultD);
		 resultD=calculate(cardD2,resultD);
		 }
		 else {
			 resultD=calculate(cardD1,resultD);
			 resultDS=calculate(cardD2,resultDS);
		 }
		 
		 if (split==false) { 
		 result=calculate(card1,result);
		 result=calculate(card2,result);
		 }
		 else {
			 result=calculate(card1,result);
			 resultS=calculate(card2,resultS);
		 }
		 
		 System.out.println("Total : " + result);
		 while (true) {
		 if (result==21) {
			 System.out.println("You got a BlackJack!");
			 
		 }
		 else if (resultD==21) {
			 System.out.println("Dealer got a BlackJack! , therefore, he wins!");
			 break;
		 }
		 else if (decryptedMsg.charAt(count)== 'S') {
			 System.out.println("Player stands");
			 count+=2;
			 //break;
		 }
		 
		 else if (split==true) {
			 if (decryptedMsg.charAt(count)== 'D') {
					System.out.println("Player splits");
					System.out.println("Player plays for his first split.");
					count+=2;
					System.out.println("Player hits");
					card card4 = new card(new String (data,count,2));
					System.out.println("Player draws " + translater(card4.getCard()));
					result= (calculate(card4,result));
					if (result<21) {
					System.out.println("Total : " + result);
					count+=3;
			 }
			 }
			 while (split==true){
					
					if (decryptedMsg.charAt(count)== 'S') {
						System.out.println("Player stands");
						count+=2;
						split=false;
					}
					
					else if (decryptedMsg.charAt(count)== 'H') {
						System.out.println("Player hits");
						count+=2;
						//System.out.println(count);
						card card4 = new card(new String (data,count,2));
						System.out.println("Player draws " + translater(card4.getCard()));
						result= (calculate(card4,result));
						if (result<=21) {
						System.out.println("Total : " + result);
						count+=3;
						}
							else if (resultS>21){
								System.out.println("Player busts with "+ result);
								split=false;
							}
					
					}
				
		 }
			 split =true;
			 

				System.out.println("Player plays for his second split.");

				System.out.println("Player hits");
				card card4 = new card(new String (data,count,2));
				System.out.println("Player draws " + translater(card4.getCard()));
				resultS= (calculate(card4,resultS));
				if (result<21) {
				System.out.println("Total : " + resultS);
				count+=3;
		 }
				while (split==true){
					
					if (decryptedMsg.charAt(count)== 'S') {
						System.out.println("Player stands");
						count+=2;
						split=false;
						break;
					}
					
					else if (decryptedMsg.charAt(count)== 'H') {
						System.out.println("Player hits");
						count+=2;
						//System.out.println(count);
						card card6 = new card(new String (data,count,2));
						System.out.println("Player draws " + translater(card6.getCard()));
						resultS= (calculate(card6,resultS));
						if (resultS<=21) {
						System.out.println("Total : " + resultS);
						count+=3;
						}
							else if (resultS>21) {
								System.out.println("Player busts with "+ resultS);
								split=false;
								break;
							}
					
					}
				
		 }
				
			 
		 }
			else if ((result<21)&&(resultD<21) && (data.length>=count+2)&&(normal==true)){
				
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
							System.out.println("Player stands with "+ result);
							count+=2;
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
				
				///////////////////////////////////////DEALER CODE FOR FILE
				
	 }
		 		if (data.length>=count+2) {
		 			
		 			if (decryptedMsg.charAt(count)== 'S') {
						System.out.println("Dealer stands");
						count+=2;
					}
		 			 else if (splitD==true) {
		 				 if (decryptedMsg.charAt(count)!= 'S') {
		 						System.out.println("Dealer splits");
		 						System.out.println("Dealer plays for his first split.");
		 						System.out.println("Dealer hits");
		 						card card4 = new card(new String (data,count,2));
		 						System.out.println("Player draws " + translater(card4.getCard()));
		 						resultD= (calculate(card4,resultD));
		 						if (resultD>16) {
		 							splitD=false;
		 						}
		 						if (resultD<21) {
		 						System.out.println("Total : " + resultD);
		 						count+=3;
		 				 }
		 				 }
		 				 while (splitD==true){
		 						
		 						if (decryptedMsg.charAt(count)== 'S') {
		 							System.out.println("Dealer stands");
		 							count+=2;
		 							splitD=false;
		 						}
		 						
		 						else  {
		 							System.out.println("Dealer hits");
		 							//System.out.println(count);
		 							card card4 = new card(new String (data,count,2));
		 							System.out.println("Dealer draws " + translater(card4.getCard()));
		 							resultD= (calculate(card4,resultD));
		 							if (resultD>16) {
		 								splitD=false;
		 							}
		 							if (resultD<=21) {
		 							System.out.println("Total : " + resultD);
		 							count+=3;
		 							}
		 							if (resultD>21) {
				 						System.out.println("Dealer busts with : " + resultD);
				 						count+=3;
				 					}
		 								else if (resultDS>21){
		 									System.out.println("Dealer busts with "+ resultD);
		 									splitD=false;
		 								}
		 						
		 						}
		 					
		 			 }
		 				 splitD =true;
		 				 

		 					System.out.println("Dealer plays for his second split.");

		 					System.out.println("Dealer hits");
		 					card card4 = new card(new String (data,count,2));
		 					System.out.println("Dealer draws " + translater(card4.getCard()));
		 					resultDS= (calculate(card4,resultDS));
		 					
		 					if (card4.Rank.equals("A")){
 								gotAce=true;
 							}
		 					if (resultDS>17) {
		 						splitD=false;
		 					}
		 					if (resultDS<21) {
		 					System.out.println("Total : " + resultDS);
		 					count+=3;
		 			 }
		 					if (resultDS>21) {
		 						System.out.println("Dealer busts with : " + resultDS);
		 						count+=3;
		 					}
		 					while (splitD==true){
		 						
		 						if ((decryptedMsg.charAt(count)== 'S')&&(decryptedMsg.charAt(count+1)== ' ')) {
		 							System.out.println("Dealer stands");
		 							count+=2;
		 							splitD=false;
		 							//break;
		 						}
		 						
		 						else  {
		 							System.out.println("Dealer hits");
		 							//System.out.println(count);
		 							card card6 = new card(new String (data,count,2));
		 							if (card6.Rank.equals("A")){
		 								gotAce=true;
		 							}

		 							System.out.println("Dealer draws " + translater(card6.getCard()));
		 							resultDS= (calculate(card6,resultDS));
		 							if ((resultDS>21)&&(gotAce==true)){
		 								resultDS-=10;
		 								System.out.println("changed ace value to 1");
		 							}
		 							if (resultDS>17) {
				 						splitD=false;
				 						count+=3;
				 					}
		 							if (resultDS<=21) {
		 							System.out.println("Total : " + resultDS);
		 							count+=3;
		 							}
		 							
		 								else if (resultDS>21) {
		 									System.out.println("Dealer busts with "+ resultDS);
		 									splitD=false;
		 									break;
		 								}
		 						
		 						}
		 					
		 			 }
		 					
		 				 
		 			 }
		 			
		 			
		 			else if (decryptedMsg.length()>count) {
						while (decryptedMsg.length()>count) {

						System.out.println("Dealer hits");
						card card4 = new card(new String (data,count,2));
						System.out.println("Dealer draws " + translater(card4.getCard()));
						resultD= (calculate(card4,resultD));
						if (resultD<=21) {
						System.out.println("Total : " + resultD);
						count+=3;
						}
					//	else if ((decryptedMsg.length()-2)==count) {
							
						//}
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
		 		if ((resultDS<22)&&(resultD<resultDS)){
		 			resultD=resultDS;
		 		}
		 		if ((resultS<22)&&(result<resultS)){
		 			result=resultS;
		 		}
		 		

		 		if (result<22) {
		 			System.out.println("Player wins with "+ result);
		 			break;
		 		}
		 		else if (resultD<22) {
		 			System.out.println("Dealer wins with "+ resultD);
		 			break;
		 		}
	 }
		 
	 }
	}
}  
