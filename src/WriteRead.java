import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteRead implements FileOperations {

    @Override
    public boolean write(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            System.out.println("Запись успешно произведена");
            System.out.println();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Реализация метода readPrizeToysFromFile
    @SuppressWarnings("unchecked")
    @Override
    public List<Toy> readPrizeToysFromFile(String filePath) {
        List<Toy> prizeToys = new ArrayList<>();

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    List<Toy> toys = (List<Toy>) objectInputStream.readObject();
                    prizeToys.addAll(toys);
                } catch (EOFException e) {
                    // Достигнут конец файла
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prizeToys;
    }
}


