public class Main {

    public static void main(String[] args) {
        Market market = new Market();
        Human human1 = new Human("a");
        Human human3 = new Human("c");

        market.acceptToMarket(human1);
        market.acceptToMarket(human3);

        market.update();


    }


}