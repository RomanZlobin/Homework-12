import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repositories.ProductRepo;
import ru.netology.managers.ProductManager;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;

public class ProductManagerTest {
    ProductRepo repo = new ProductRepo();
    ProductManager manager = new ProductManager();
    Product book1 = new Book(1, "Harry Potter", 12, "Rowling");
    Product book2 = new Book(2, "Harry Potter 2", 15, "Rowling");
    Product smartphone1 =new Smartphone(3, "12", 200, "Xiaomi");
    Product smartphone2 = new Smartphone(4, "11", 150, "Xiaomi");

    @Test
    public void testAdd() {


        manager.add(new Book(1, "Harry Potter", 12, "Rowling") );
        manager.add(new Book(2, "Harry Potter 2", 15, "Rowling") );
        manager.add(new Smartphone(3, "12", 200, "Xiaomi") );
        manager.add(new Smartphone(4, "11", 150, "Xiaomi") );

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }
}
