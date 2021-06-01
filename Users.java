package main;
import java.util.ArrayList;

/**
 * A class to represent a user.
 */
public class User{

    public static final int MAXUSERNAME = 15;
    protected String userName;
    protected String userType; //either regular (RU), critic (CU) or admin (AA)
    protected Database currDatabase;
    protected ArrayList<Movie> recommendations;
    protected ArrayList<User> friends;
    // protected String password;


    /**
     * Constructs a User that has a userName and userType
     *
     * @param userName the user name
     * @param userType the type of the user
     */
    public User(String userName, String userType){
        this.userName = userName;
        this.userType = userType;
        this.recommendations = new ArrayList<>();
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
    public ArrayList<Movie> getFriends() {
        return this.friends;
    }

    /**
     * Returns a string representation based on whether they are able to add a friend
     * @param
     */


    /**
     * Allows developer to request putting the app up for sale.
     * Returns a string representation based on whether the requestSell operation is successful
     * @param appName the app name
     * @param appPrice the original price of the app
     * @param userName the developer's user name
     *
     * @return a string representation based on whether the requestSell operation is successful, error otherwise.
     */
    public String requestSell(String appName, double appPrice, String userName, String category){
        Transaction sell = new SellTransaction(userName, appName, appPrice, category, this.currDatabase);

        return sell.execute();
    }

    /**
     * Allows owner to request removing the app from their inventory.
     * Returns a string representation based on whether the requestRemoveApp operation is successful
     * @param appName the app name
     * @param ownerName the name of the owner (optional)
     *
     * @return a string representation based on whether the requestRemoveApp operation is successful, error otherwise.
     */
    public String requestRemoveApp(String appName, String ownerName){
        if(ownerName.equals("")){
            ownerName = this.userName;
        }
        Transaction removeApp = new RemoveAppTransaction(this.userName, this.currDatabase, appName, ownerName);
        return removeApp.execute();
    }
}
