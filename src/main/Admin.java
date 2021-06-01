package main;

/**
 * A class to represent an Admin User.
 */
public class Admin extends Users {
    /**
     * Constructs an Admin user that has a userName, userType and an accountBalance
     * Includes the apps that the user owns (appsOwned), the apps that the user can sell(appsToSell), and
     * the apps that the user bought today (newPurchases)
     *
     * @param userName the user name of the admin
     * @param userType the type of the user

     */
    public Admin(String userName, String userType){
        super(userName, userType);
    }

    /**
     * Creates a user using the userName and userType.
     * Returns a String representation of the transaction
     *
     * @param newUserName the user name of the user to be created
     * @param userType the user type of the user to be created
     * @return a String representation of the create user operation
     */
    public String requestCreateUser(String newUserName, String userType){
        Features createUser = new CreateUserFeatures(this.userName, newUserName, userType, this.getDatabase());
        return createUser.execute();

    }

    /**
     * Removes a user and return a String representation of the operation
     *
     * @param userToRemove the name of the user to be deleted
     * @return a String representation of the delete user operation
     */
    public String requestDeleteUser(String userToRemove){
        Features deleteUser = new DeleteUserFeatures(this.userName, userToRemove, this.getDatabase());
        return deleteUser.execute();
    }

    /**
     * Adds the movie to the system
     *
     * @param movieName the movie name
     * @return the String representation of the add movie operation
     */
    public String requestAddMovie(String movieName){
        Features addMovie = new AddMovieFeatures(this.userName, movieName, this.currDatabase);

        return addMovie.execute();

    }

    /**
     * Adds the trigger warning of movie
     *
     * @param movieName the movie name
     * @return the String representation of the add trigger operation
     */
    public String requestAddTrigger(String movieName){
        Features addTrigger = new AddTriggerFeatures(this.userName, movieName, this.currDatabase);

        return addTrigger.execute();
    }
}
