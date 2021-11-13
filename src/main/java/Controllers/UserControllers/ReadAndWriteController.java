package Controllers.UserControllers;

import DataAccess.DataAccessGateway;
import UseCase.UserManager;

import java.io.IOException;

public class ReadAndWriteController {

    public void runRead () throws IOException, ClassNotFoundException {
        UserManager userManager = new UserManager();
        DataAccessGateway gateway = new DataAccessGateway();
        userManager.readData(gateway);
    }

    public void runWrite () throws IOException, ClassNotFoundException {
        UserManager userManager = new UserManager();
        DataAccessGateway gateway = new DataAccessGateway();
        userManager.writeData(gateway);
    }
}