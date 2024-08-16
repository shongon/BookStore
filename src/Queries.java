import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Queries {
    //Get book title and prices
    public static void getAllBookTitlesAndPrices() {
        String query = "SELECT title, price FROM books;";

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                System.out.println("Title: " + title + ", Price: " + price);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Find book and price by author id
    public static void findBooksByAuthor(int authorId) {
        String query = "SELECT title, price FROM books WHERE author_id = " + authorId;
    
        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
    
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                System.out.println("Title: " + title + ", Price: " + price);
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Get book with higher price than 1000
    public static void getBooksHigherThan1000() {
        String queryBookHigherThan1000 = "SELECT title, price FROM books WHERE price > 1000;";

        try(Connection connection = DatabaseConnector.connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryBookHigherThan1000)){

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                System.out.println("Title: " + title + ", Price: " + price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    //Count book by category
    public static void countBooksByCategory() {
        String countBooksByCategory = "SELECT category_id, COUNT(*) AS book_count FROM books GROUP BY category_id";

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(countBooksByCategory)){
                while (resultSet.next()) {
                    int categoryID = resultSet.getInt("category_id");
                    int bookCount = resultSet.getInt("book_count");
                    System.out.println("Category ID: " + categoryID + ", Book Count: " + bookCount);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // List All Books That Are Out of Stock
    public static void listBooksIsOutStock(){
        String listBooksIsOutStock = "SELECT title FROM books WHERE stock_status != 'In Stock';";

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(listBooksIsOutStock)) {

                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    System.out.println("Title: " + title);
                }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get the Top 5 Books with the Most Reviews
    public static void getTop5MostReviews() {
        String getTop5MostReviews = "SELECT title, reviews FROM books ORDER BY reviews DESC LIMIT 5;";

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(getTop5MostReviews)) {
            
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    int reviews = resultSet.getInt("reviews");
                    System.out.println("Title: " + title + ", Review: " + reviews);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Find the Total Number of Copies Left for a Specific Category
    public static void getTotalCopiesLeftOfCategory(int categoryID){
        String queryCopiesLeft = "SELECT SUM(copies_left) FROM books WHERE category_id = 3;";

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(queryCopiesLeft)) {
            
                while (resultSet.next()) {
                    int copiesLeft = resultSet.getInt("SUM(copies_left)");
                    System.out.println("Sum of copies left: " + copiesLeft);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Get top 10 wished users
    public static void getTop10WishedUsers() {
        String queryWishedUser = "SELECT title, wished_users FROM books ORDER BY wished_users DESC LIMIT 10;";

        try (Connection connection = DatabaseConnector.connect();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(queryWishedUser)) {
            
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    int wishedUser = resultSet.getInt("wished_users");
                    System.out.println("Title: " + title + ", Wished Users: " + wishedUser);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
