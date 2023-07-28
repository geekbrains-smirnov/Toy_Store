import java.io.Serializable;
import java.util.List;

public interface FileOperations {
    boolean write(Serializable serializable, String filePath);
    Object read(String filePath);
    List<Toy> readPrizeToysFromFile(String filePath);
}
