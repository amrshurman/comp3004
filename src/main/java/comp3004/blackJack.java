package comp3004;


import java.util.*;

	
public class blackJack extends card{

	public static void main(String[] args) {
		boolean breaked=false;
		boolean soft17=false;
		int result=0;
		int resultD=0;
	String input;
	 Scanner sc = new Scanner(System.in);
	
	 card card1 = new card();
	 card card2 = new card();
	 card cardD1 = new card();
	 card cardD2 = new card();
	 resultD=calculate(cardD1,resultD);
	 resultD=calculate(cardD2,resultD);
	System.out.println("Dealer has drawn a " + cardD1.getCard()+ ", the other card he drew is hidden for now.");
	System.out.println("Your first card acquired is "+card1.getCard());
	System.out.println("Your second card acquired is " + card2.getCard());
	result=calculate(card1,result);
	result=calculate(card2,result);
	System.out.println("Total : " + result);
	while (true) {
		if (result==21) {
			System.out.println("You got BlackJack!");
			break;
		}
		else if ((result<21)&&(resultD<21)){
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
	else {
		System.out.println("You break");
		breaked=true;
		break;
	}
	}
	while (true) {
		if (breaked==true) {
			System.out.println("Dealer wins because you break.");
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
		System.out.println("Dealer breaks, you win");
		break;
	}
	else {
		System.out.println("Dealer stands");
		if (result>resultD) {
			System.out.println("You win by having a closer number to 21.");
		break;
		}
	}
	}
	} 
}  
