public class Card {
    public int rank;
    public String color;

    Card(int rank,String color){
        this.rank=rank;
        this.color=color;
    }
    @Override
    public String toString(){
        return String.format("[%s %d]",color,rank);
    }

}
