import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Card {
    int rank;
    String color;
    Card(int rank,String color){
        this.rank=rank;
        this.color=color;
    }
    @Override
    public String toString(){
        String valueStr=null;
        if(rank==1){
            valueStr="A";
        }else if(rank>10){
            if(rank==11)
                valueStr="J";
            if(rank==12)
                valueStr="Q";
            if(rank==13)
                valueStr="K";
        }else{
            valueStr=String.valueOf(rank);
        }
        return String.format("[%s %s]",valueStr,color);
    }
}
public class DeckDemo{
     private static final String[]colors={"♥","♦","♣","♠"};
     public static List<Card> createCard(){
         List<Card>deck=new ArrayList<>(52);
         for(int i=0;i<4;i++){
             for(int j=1;j<=13;j++){
                 String color=colors[i];
                 int rank=j;
                 Card card=new Card(rank,color);
                 deck.add(card);
             }
         }
         return deck;
     }
     public static void shuffle(List<Card>deck){
         Random rand=new Random();
         for(int i=deck.size()-1;i>0;--i) {
             int pos = rand.nextInt(i);
             swap(deck, i, pos);
         }
     }
	 public static void send(List<Card> deck, List<List<Card>> persons,
                            int numberCard, int numberPerson){
        for(int i = 0; i < numberPerson; ++i){
            persons.add(new ArrayList<>());
        }
        for(int i = 0; i < numberCard; ++i){
            for(int j = 0; j < numberPerson; ++j){
                Card card = deck.remove(0);
                persons.get(j).add(card);
            }
        }
    }
     public static void swap(List<Card>deck,int i,int j){
         Card tmp=deck.get(i);
         deck.set(i,deck.get(j));
         deck.set(j,tmp);
     }

    public static void main(String[] args) {
        List<Card> deck=createCard();
        System.out.println(deck);
        shuffle(deck);
        System.out.println(deck);
        List<List<Card>> hands=new ArrayList<>();
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        hands.add(new ArrayList<>());
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                hands.get(j).add(deck.remove(0));
            }
        }
        System.out.println("第一个人的牌");
        System.out.println(hands.get(0));
        System.out.println("第二个人的牌");
        System.out.println(hands.get(1));
        System.out.println("第三个人的牌");
        System.out.println(hands.get(2));

    }
}
