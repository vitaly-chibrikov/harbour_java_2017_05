package space.harbour.l141;


public class MSMain {
    public static void main(String[] args) throws InterruptedException {
        AddressContext context = new AddressContext();
        FrontendService frontendService = new FrontendService(context);
        frontendService.start();
        DBService dbService = new DBService(context);
        dbService.start();

        frontendService.handleRequest("tully");
        frontendService.handleRequest("sully");

        frontendService.join();
        dbService.join();
    }
}
