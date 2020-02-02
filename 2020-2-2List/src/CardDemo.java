import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardDemo {
    public static final String[]colors={"♥","♠","♦","♣"};
    public static List<Card> buyDeck(){
        List<Card> deck=new ArrayList<Card>();
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
    public static void swap(List<Card> deck,int i,int j){
        Card t=deck.get(i);
        deck.set(i,deck.get(j));
        deck.set(j,t);
    }

    public static void shuffle(List<Card> deck){
        Random random=new Random(20200202);
        for(int i=deck.size()-1;i>0;i--){
            int j=random.nextInt(i);
            swap(deck,i,j);
        }
    }

    public static void main(String[] args) {
        List<Card> card=buyDeck();
        System.out.println(card);
        shuffle(card);
        System.out.println(card);

        List<List<Card>>person=new ArrayList<>();
        person.add(new ArrayList<>());
        person.add(new ArrayList<>());
        person.add(new ArrayList<>());
        for(int i=0;i<17;i++){
            for(int j=0;j<3;j++){
                person.get(j).add(card.remove(0));
            }
        }
        System.out.println("底牌");
        System.out.println(card);
        System.out.println("A的牌");
        System.out.println(person.get(0));
        System.out.println("B的牌");
        System.out.println(person.get(1));
        System.out.println("C的牌");
        System.out.println(person.get(2));


        /*
        Random rand = new Random();
        long startTime = System.nanoTime() ;
        int i1 = rand.nextInt(1000000000);
        System.out.println(i1);
        long endTime = System.nanoTime();
        System.out.println("Random.nextInt(): " + (endTime - startTime));

        long startTime2 = System.nanoTime();
        int i2 = (int) (java.lang.Math.random() * 1000000000);
        System.out.println(i2);
        long endTime2 = System.nanoTime();
        System.out.println("Math.random():" + (endTime2 - startTime2));*/
    }
}
