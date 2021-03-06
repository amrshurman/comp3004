package comp3004;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class card {
	
  //got some inspiration from https://codereview.stackexchange.com/questions/125873/implementation-of-a-card-class-in-java 
	 protected String Suit;
	protected String Rank;
	private String Color;
	protected String Card;
	 private static final Random generator = new Random();
	 
	    private static String[] Suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
	    private static String[] Ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8",
	    "9", "10", "Jack", "Queen", "King"};

	    int randomSuits = generator.nextInt(Suits.length);
	    int randomRanks = generator.nextInt(Ranks.length);
	    
	    card(String s){
	    	if (s.length()<2) {
	    		System.out.println("invalid card");
	    	}
	    	else {
	    		Card=s;
	    		Suit=s.charAt(0)+"";
	    		Rank=s.charAt(1)+"";
	    	}
	    }
	    
	    card(){
	    	 Suit = Suits[randomSuits];
	         Rank = Ranks[randomRanks];
	         if (Rank.equals("10")) {
	        	 Card = Suit.charAt(0) + "" + Rank.charAt(0) + Rank.charAt(1); 
	         }
	         else {
	         Card = Suit.charAt(0) + "" + Rank.charAt(0);
	         }
	  
	    }
	
	    public String getCard() {
	         return Card;
	     }
	    
	    public String getSuit() {
	         return Suit;
	     }

	     public String getRank() {
	         return Rank;
	     }
	    
	     public static String translater(String s) {
	    	 String x="";
	    	 String y = "";
	    	 if (s.charAt(0)=='H') {
	 			x="Hearts";
	 		}
	 			else if (s.charAt(0)=='S') {
	 				x="Spades";
	 			}
	 			else if (s.charAt(0)=='D') {
	 				x="Diamonds";
	 			}
	 			else if (s.charAt(0)=='C') {
	 				x="Clubs";
	 			}
	    	 if (s.charAt(1)=='A') {
					y="Ace";
				}
				else if	(s.charAt(1)=='2') {
						y="2";
					}
				else if	(s.charAt(1)=='3') {
					y="3";
				}
				else if	(s.charAt(1)=='4') {
					y="4";
				}
				else if	(s.charAt(1)=='5') {
					y="5";
				}
				else if	(s.charAt(1)=='6') {
					y="6";
				}
				else if	(s.charAt(1)=='7') {
					y="7";
				}
				else if	(s.charAt(1)=='8') {
					y="8";
				}
				else if	(s.charAt(1)=='9') {
					y="9";
				}
				else if	((s.charAt(1)=='1')&&(s.charAt(2)=='0')) {
					y="10";
				}
				else if (s.charAt(1)=='K') {
					y="King";
				}
				else if (s.charAt(1)=='Q') {
					y="Queen";
				}
				else if (s.charAt(1)=='J') {
					y="Jack";
				}
	    	 
	    	 return (y + " of " + x);
				}

	     
	     
	public static int validateCard(String s) {
		if (s.charAt(0)=='H') {
			//System.out.println("HEARTS card accquired");
		}
			else if (s.charAt(0)=='S') {
				//System.out.println("SPADES card accquired");
			}
			else if (s.charAt(0)=='D') {
				//System.out.println("DIAMONDS card accquired");
			}
			else if (s.charAt(0)=='C') {
				//System.out.println("CLUBS card accquired");
			}
		
		else { 
			System.out.println("Invalid Suit selected");
			System.out.println(s.charAt(0));
			return 0;
		}
		
			if (s.charAt(1)=='A') {
				return 1;
			}
			else if	(s.charAt(1)=='2') {
					return 2;
				}
			else if	(s.charAt(1)=='3') {
				return 3;
			}
			else if	(s.charAt(1)=='4') {
				return 4;
			}
			else if	(s.charAt(1)=='5') {
				return 5;
			}
			else if	(s.charAt(1)=='6') {
				return 6;
			}
			else if	(s.charAt(1)=='7') {
				return 7;
			}
			else if	(s.charAt(1)=='8') {
				return 8;
			}
			else if	(s.charAt(1)=='9') {
				return 9;
			}
			else if	((s.charAt(1)=='1')&&(s.charAt(2)=='0')) {
				return 10;
			}
			else if ((s.charAt(1)=='K') || (s.charAt(1)=='Q') || (s.charAt(1)=='J'))
				return 10;
			
			else {
			System.out.println("Invalid Rank selected");
			return 0;
			}
		}
	
	public static boolean is21(int x) {
		if (x==21) {
			return true;
		}
		return false;
	}
	
	public static int calculate(card card, int result) {
		int value=validateCard(card.getCard());
		
		if ((value==1) && (value+result<12)) {
			result=result+10;
		}
		result=result+value;
		return result;
	}

	public static byte[] readFile(String fileName) throws IOException{
    	Path file = Paths.get(fileName);
    	byte[] data = null;
    		
    		data = Files.readAllBytes(file);
    		
    		return data;
    	
		}
	
	}
	

