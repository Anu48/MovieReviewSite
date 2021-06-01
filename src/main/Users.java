package main;
import java.util.ArrayList;

/**
 * A class to represent a user.
 */
public class Users{

    public static final int MAXUSERNAME = 15;
    protected String userName;
    protected String userType; //either regular (RU), critic (CU) or admin (AA)
    protected Database currDatabase;
    protected ArrayList<Movie> recommendations;
    protected ArrayList<Users> friends;
    // protected String password;


    /**
     * Constructs a User that has a userName and userType
     *
     * @param userName the user name
     * @param userType the type of the user
     */
    public Users(String userName, String userType){
        this.userName = userName;
        this.userType = userType;
        this.recommendations = new ArrayList<Movie>();
        this.friends = new ArrayList<>();
    }

    /**
     * Returns the username of the user.
     * @return the user's username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Returns the usertype of the user.
     * @return the user's type
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Returns the account balance of the user.
     * @return the user's account balance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Returns the current database of the system.
     * @return the database of the system
     */
    public Database getDatabase() {
        return this.currDatabase;
    }

    /**
     * Sets the database.
     * @param database the database of the system
     */
    public void setDatabase(Database database){
        this.currDatabase = database;
    }

    /**
     * Returns a list of recommendations from the user
     * @return the list of recommendations
     */
    public ArrayList<Movie> getRecommendations() {
        return this.recommendations;
    }

    /**
     * Returns a list of friends from the user
     * @return the list of friends
     */
    public ArrayList<Users> getFriends() {
        return this.friends;
    }

    /**
     * Returns a string representation based on whether they are able to add a friend
     * @param friendName the friend's name the user wants to add
     * @return a string representation based on whether they are able to add a friend
     */
    public String requestAddFriend(String friendName){
        Features addFriend = new AddFriendFeature(userName, friendName, this.currDatabase);
        return addFriend.execute;
    }

    /**
     * Returns a string representation based on whether they are able to add a movie recommendation
     * @param movieName the name of the movie the user wants to recommend
     * @return a string representation based on whether they are able to add a friend
     */
    public String requestAddRecommendation(String movieName){
        Features addRec = new AddRecommendationFeature(userName, movieName, this.currDatabase);
        return addRec.execute;
    }

    /**
     * Returns a string representation based on whether they are able to remove a friend
     * @param friendName the friend's name the user wants to add
     * @return a string representation based on whether they are able to remove a friend
     */
    public String requestRemoveFriend(String friendName){
        Features removeFriend = new RemoveFriendFeature(userName, friendName, this.currDatabase);
        return removeFriend.execute;
    }

    /**
     * Returns a string representation based on whether they are able to remove a movie from their recommendation
     * @param movieName the name of the movie the user wants to recommend
     * @return a string representation based on whether they are able to remove a movie from their recommendation
     */
    public String requestRemoveRecommendation(String movieName){
        Features removeRec = new RemoveRecommendationFeature(userName, movieName, this.currDatabase);
        return removeRec.execute;
    }

    /**
     * Returns a string representation based on whether they are able to rate a movie from 0 to 5 stars
     * @param movieName the name of the movie the user wants to rate
     * @return a string representation based on whether they are able to rate a movie from 0 to 5 stars
     */
    public String requestRating(String movieName){
        Features rating = new RateMovieFeature(userName, movieName, this.currDatabase);
        return rating.execute;
    }
}
