package UIs;

import CommandControl.Constants;
import Controllers.UserControllers.LogOutController;
import Presenters.LogOutPresenter;

import java.util.Scanner;

public class LogoutUI extends ParentUI {

    public void run () {

        Constants constants = new Constants();
        String currentUser = constants.getCurrentUser();

        LogOutController controller = new LogOutController();
        LogOutPresenter presenter = new LogOutPresenter();


        if(currentUser != null){
            controller.runLogOut(currentUser);
            if (!presenter.isLoggedIn()){
                System.out.println(presenter.presentOutput());
            }
        }else{
            System.out.println("Please log in first!");
        }
    }
}
