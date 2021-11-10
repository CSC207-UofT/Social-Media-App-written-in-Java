package Entity;

import java.util.ArrayList;
import java.util.HashMap;

/* Responsibility
        Each user has an unique ID, a userName, an associated password, an avatar
        Create a user ID when Creating a new user account.
        It has a list of friends, each friend is a User object.
        It has a list of posts that was posted by the user.
        It has a list blocked user, each blocked user is an User object. The blocked user cannot add this user as friend.
        It has a request list attribute which stores a string of adding friend request.
       It has a string attribute called loggedIn, which indicate whether the user is logged in or not.
*/


public class User {
    //TODO: avatar, chat, mypost
    private final String iD;
    private String userName;
    private String password;
    private final ArrayList<User> friends;
    private final ArrayList<ParagraphPost> myPosts;
    private final ArrayList<User> blockedUser;
    private final ArrayList<String> addFriendRequests;
    private final SharingCentre sharingCentre;
    private boolean loggedIn;
    private final HashMap<User, ArrayList<PtoPMessage>> PtoPMessageHistory;

    public User(String id, String username, String password){
        this.iD = id;
        this.userName = username;
        this.password = password;
        this.friends = new ArrayList<>();
        this.myPosts = new ArrayList<>();
        this.blockedUser = new ArrayList<>();
        this.addFriendRequests = new ArrayList<>();
        this.loggedIn = false;
        this.PtoPMessageHistory = new HashMap<>();
        this.sharingCentre = new SharingCentre();
    }

    public String getID (){
        return this.iD;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<User> getFriends() {
        return this.friends;
    }

    public ArrayList<ParagraphPost> getMyPosts() {
        return this.myPosts;
    }

    public ArrayList<User> getBlockedUser() {
        return this.blockedUser;
    }

    public ArrayList<String> getAddFriendRequests() {
        return this.addFriendRequests;
    }

    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    public SharingCentre getSharingCentre() {
        return sharingCentre;
    }

    public void changeLoggedInStatus() {
        //Change LogIn status of the user with given id.
        if (this.loggedIn){
            this.loggedIn = false;
        }
        this.loggedIn = true;
    }

    public void changeUserName (String userName){
        //Change the userName to new userName
        this.userName = userName;
    }

    public void changePassword (String password){
        //Change the password to new password
        this.password = password;
    }

    public void addFriend (User friend){
        //Add friend to the list friends
        this.friends.add(friend);
    }

    public void removeFriend (User friend){
        //Remove friend from the list friends
        int k = this.friends.size() + 1;
        for (int i = 0; this.friends.size() > i; i++){
            if (this.friends.get(i).equals(friend)){
                k = i;
            }
        }
        if (k < this.friends.size()) {
            this.friends.remove(k);
        }
    }

    public void addMessage(User user, PtoPMessage message){
        if (! PtoPMessageHistory.containsKey(user)){
            ArrayList<PtoPMessage> first = new ArrayList<>();
            first.add(message);
            PtoPMessageHistory.put(user, first);
        }
        else {
            ArrayList<PtoPMessage> lst = PtoPMessageHistory.get(user);
            lst.add(message);
        }
    }

    public ArrayList<PtoPMessage> getMessage(User user){
        if (! PtoPMessageHistory.containsKey(user)){
            return new ArrayList<>();
        }
        else {
            return PtoPMessageHistory.get(user);
        }
    }

    public void deleteMessage(User user, PtoPMessage message){
        ArrayList<PtoPMessage> lst = PtoPMessageHistory.get(user);
        lst.remove(message);
    }
}

