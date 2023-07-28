
import java.io.Serializable;
import java.util.List;

public class Service {
    private ToyStore toyStore;
    private FileOperations fileOperations;

    public Service() {
        toyStore = new ToyStore();
        fileOperations = new WriteRead();

    }


    public void addToy(Toy toy) {
        toyStore.addToy(toy);
    }


    public void updateToyWeight(int toyId, double newWeight) {
        toyStore.updateToyWeight(toyId, newWeight);
    }


    public void organizeRaffle(int numPrizes) {
        toyStore.organizeRaffle(numPrizes);
    }


    public List<Toy> getPrizeToys() {
        return toyStore.getPrizeToys();
    }


    public void saveToyStoreToFile(String filePath) {
        fileOperations.write(toyStore, filePath);
    }


    public void savePrizeToys(String filePath) {
        fileOperations.write((Serializable) toyStore.prizeToys, filePath);
    }

    public void loadToyStoreFromFile(String filePath) {
        ToyStore loadedToyStore = (ToyStore) fileOperations.read(filePath);
        if (loadedToyStore != null) {
            toyStore = loadedToyStore;
        }
    }


    public void printAllToysInfo() {
        System.out.println("Информация о всех игрушках:");
        System.out.println(toyStore.getInfo());
    }


    public void printPrizeToysInfo() {
        List<Toy> prizeToys = toyStore.getPrizeToys();
        System.out.println("Призовые игрушки:");
        for (Toy prizeToy : prizeToys) {
            System.out.println(prizeToy.getName());
        }
    }


    public void printToysStore(String filePath) {
        ToyStore newLoadedToyStore = (ToyStore) fileOperations.read(filePath);
        System.out.println("Информация о всех игрушках (загружено из файла):");
        System.out.println(newLoadedToyStore.getInfo());
    }


    public void printPrizeToysInfoFromFile(String filePath) {
        List<Toy> newLoadedPrizeToys = fileOperations.readPrizeToysFromFile(filePath);
        System.out.println("Информация о всех призовых игрушках (загружено из файла):");
        for (Toy toy : newLoadedPrizeToys) {
            System.out.println(toy.getInfo());
        }
    }
}
