import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Service service = new Service();
        String toyStoreFilePath = "toy_store.txt";
        String prizeToysFilePath = "prize_toys.txt";



        service.addToy(new Toy(1, "Мяч", 15, 20.0));
        service.addToy(new Toy(2, "Кукла", 5, 2.0));
        service.addToy(new Toy(3, "Машинка", 20, 3.0));
        service.addToy(new Toy(4, "Конструктор", 1, 1.0));





        service.updateToyWeight(2, 0.5);


        service.organizeRaffle(5);


        service.getPrizeToys();


        service.saveToyStoreToFile(toyStoreFilePath);


        service.savePrizeToys(prizeToysFilePath);


        service.loadToyStoreFromFile(toyStoreFilePath);


        service.printAllToysInfo();


        service.printPrizeToysInfo();


        service.printPrizeToysInfoFromFile(prizeToysFilePath);


        System.out.println();


        service.printToysStore(toyStoreFilePath);



    }
}