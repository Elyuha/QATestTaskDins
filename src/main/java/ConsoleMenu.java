import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private final Controller controller = new Controller();
    private final Scanner scanner = new Scanner(System.in);

    public void start(){
        boolean exit = true;
        while (exit) {
            System.out.println("1) Get post by id");
            System.out.println("2) Get posts by user id");
            System.out.println("3) Get all posts");
            System.out.println("0) Exit");
            System.out.print("Enter: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter id: ");
                    long id = scanner.nextLong();
                    POJO postById = controller.getPostById(id);
                    System.out.println(postById);
                    break;
                case 2:
                    System.out.print("Enter user id: ");
                    long userId = scanner.nextLong();
                    List<POJO> postsByUserId = controller.getPostsByUserId(userId);
                    System.out.println(postsByUserId);
                    break;
                case 3:
                    List<POJO> allPosts = controller.getAllPosts();
                    System.out.println(allPosts);
                    break;
                case 0:
                    exit = false;
                    break;
                default:
                    break;
            }
        }
    }
}
