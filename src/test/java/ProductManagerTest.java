import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repositories.ProductRepo;
import ru.netology.managers.ProductManager;
import ru.netology.products.Book;
import ru.netology.products.Product;
import ru.netology.products.Smartphone;

class ProductManagerTest {
    private ProductRepo repo = new ProductRepo();
    private ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Harry Potter", 12, "Rowling");
    Product book2 = new Book(2, "Harry Potter 2", 15, "Rowling");
    Product smartphone1 = new Smartphone(3, "12", 200, "Xiaomi");
    Product smartphone2 = new Smartphone(4, "11", 150, "Xiaomi");

    @Test
    public void testAdd() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind2Elements() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {book1, book2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind1Element() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("12");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind0() {


        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("dfnkdjs");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind0Because0Added() {


        Product[] actual = manager.searchBy("Harry");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
}
