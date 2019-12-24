    public class Dog extends Animal{
    String host;
    Dog(String host){
        // super();
        this.numberOfLegs=4;
        this.host=host;
    }
    public void hell(){
        System.out.println("我有"+numberOfLegs+"条腿"+"我的主人是"+host);
    }
    public void scream(){
        super.scream();
        System.out.println("汪汪");
    }
    public Animal creatAnimal(){
        return new Animal();
    }
    public Animal creatDog(){
        return new Dog("guge");
    }
    public void introduction(Animal a){
        System.out.println(a.numberOfLegs);
    }
    public static void main(String []args){
        Dog baby=new Dog("顾哥");
        baby.hell();
        Animal d=new Dog("顾哥");
        d.scream();
    }
}
