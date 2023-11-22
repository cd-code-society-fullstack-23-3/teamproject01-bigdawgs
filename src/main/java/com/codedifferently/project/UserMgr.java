package com.codedifferently.project;

import java.util.ArrayList;

public class UserMgr {

    private ArrayList<User> users;

    /**
     * This constructor will always create the default user
     */
    public UserMgr(){
        users = new ArrayList<>();
        createDefaultUser();
    }

    /**
     * This constructor will only create the default user if parameter is true
     * @param createDefaultUser
     */
    public UserMgr(Boolean createDefaultUser){
        users = new ArrayList<>();
        if(createDefaultUser){
            createDefaultUser();
        }
    }

    public String showAllUsers(){
        StringBuilder result = new StringBuilder();
        result.append(String.format("There are currently %d users:\n", users.size()));
        for(int x =0; x < users.size(); x++){
            User u = users.get(x);
            result.append(String.format("%d) %s, %s\n",x, u.getLastName(), u.getFirstName()));
        }
        return result.toString();
    }

    private void createDefaultUser(){
        users.add(new User("Default", "User", 3));
    }

    public User search(String firstName, String lastName) throws Exception{
        for (User u:users) {
            String currentFirstName = u.getFirstName();
            String currentLastName = u.getLastName();
            if(currentFirstName.equals(firstName) && currentLastName.equals(lastName)){
                return u;
            }
        }
        throw new Exception("User not found");
    }

    public void update(User oldUser, String firstName, String lastName, Integer code) throws Exception{
        User modifiedUser = search(oldUser.getFirstName(), oldUser.getLastName());
        modifiedUser.setFirstName(firstName);
        modifiedUser.setLastName(lastName);
        modifiedUser.setCipherCode(code);
    }

    public Boolean addUser(User user){
        if(userExist(user.getFirstName(), user.getLastName())){
            return false;
        }
        users.add(user);
        return true;
    }

    public String requestEncode(String firstName, String lastName, String message) throws Exception{
        return search(firstName, lastName).encodeMessage(message);
    }

    private Boolean userExist(String firstName, String lastName){
        for (User u:users) {
            String currentFirstName = u.getFirstName();
            String currentLastName = u.getLastName();
            if(currentFirstName.equals(firstName) && currentLastName.equals(lastName)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        Boolean exist = userExist("Default", "User");
        builder.append(String.format("The UserMgr is working "));
        String postFix = (exist)? "with default encoder present": "without default encoder present";
        builder.append(postFix);
        return builder.toString();
    }
}
