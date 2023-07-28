import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore implements Serializable  {
    public List<Toy> toys;
    public List<Toy> prizeToys;
    protected Random random;

    public ToyStore() {

        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
        random = new Random();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, double newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeightPercentage(newWeight);
                break;
            }
        }
    }

    public void organizeRaffle(int numberOfPrizes) {
        prizeToys.clear();
        for (int i = 0; i < numberOfPrizes; i++) {
            Toy drawnToy = drawToy();
            if (drawnToy != null) {
                prizeToys.add(drawnToy);
                drawnToy.decreaseQuantity();
            } else {
                System.out.println("К сожалению, в этот раз приз не выпал.");
                break;
            }
        }
    }

    private Toy drawToy() {
        double totalWeight = toys.stream().mapToDouble(Toy::getWeightPercentage).sum();
        double randomNumber = random.nextDouble() * totalWeight;

        for (Toy toy : toys) {
            randomNumber -= toy.getWeightPercentage();
            if (randomNumber <= 0) {
                return toy;
            }
        }
        return null;
    }

    public List<Toy> getPrizeToys() {
        return prizeToys;
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        for (Toy toy : toys) {
            info.append(toy.getInfo()).append("\n");
        }
        return info.toString();
    }
}