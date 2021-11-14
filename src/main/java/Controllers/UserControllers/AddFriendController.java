package Controllers.UserControllers;

import InputBoundary.UserInputBoundary;
import Presenters.AccountRegistrationPresenter;
import Presenters.AddFriendPresenter;
import UseCase.UserManager;

public class AddFriendController{

    /**
     * The input boundary for the AccountRegistration use case.
     */
    private UserInputBoundary AddFriendInputBoundary = new UserManager();

    public void setAddFriendInputBoundary(UserInputBoundary addFriendInputBoundary) {
        AddFriendInputBoundary = addFriendInputBoundary;
    }

    public void addFriend(String[] parameters, AddFriendPresenter presenter){
        AddFriendInputBoundary.runAddFriend(parameters, presenter);
    }


}
