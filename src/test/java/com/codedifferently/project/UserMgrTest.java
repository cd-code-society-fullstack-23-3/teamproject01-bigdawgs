package com.codedifferently.project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMgrTest {

    @Test
    public void defaultConstructorTest01(){
        UserMgr userMgr = new UserMgr();

        String expected = "The UserMgr is working with default encoder present";
        String actual = userMgr.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void parameterConstructorTestSetToFalse(){
        UserMgr userMgr = new UserMgr(false);
        String expected = "The UserMgr is working without default encoder present";
        String actual = userMgr.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void parameterConstructorTestSetToTrue(){
        UserMgr userMgr = new UserMgr(true);
        String expected = "The UserMgr is working with default encoder present";
        String actual = userMgr.toString();

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void showAllUsersTest01(){
        UserMgr userMgr = new UserMgr();
        String expected = "There are currently 1 users:\n0) User, Default\n";
        String actual = userMgr.showAllUsers();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestSuccess() throws  Exception{
        UserMgr userMgr = new UserMgr();
        String expectedFirstName = "Default";
        User actualUser = userMgr.search("Default", "User");
        String actualFirstName = actualUser.getFirstName();
        Assertions.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void searchTestFail(){
        Assertions.assertThrows(Exception.class, ()->{
            UserMgr userMgr = new UserMgr();
            userMgr.search("Earl", "User");
        });
    }

    @Test
    public void updateUserSuccess() throws Exception{
        UserMgr userMgr = new UserMgr();
        User user = new User("Default", "User", 3);
        userMgr.update(user, "Earl", "SweatShirt", 35);
        User actual = userMgr.search("Earl", "SweatShirt");
        Assertions.assertEquals("Earl", actual.getFirstName());
    }

    @Test
    public void updateUserFail(){
        Assertions.assertThrows(Exception.class, ()->{
            UserMgr userMgr = new UserMgr();
            User user = new User("Earl", "SweatShirt", 3);
            userMgr.update(user, "Tyler", "TheCreator", 35);
        });

    }

    @Test
    public void addUserTestSuccess(){
        UserMgr userMgr = new UserMgr();
        User user = new User("Earl", "SweatShirt", 3);
        Boolean actual = userMgr.addUser(user);
        Assertions.assertTrue(actual);
    }

    @Test
    public void addUserTestFail(){
        UserMgr userMgr = new UserMgr();
        User user = new User("Default", "User", 3);
        Boolean actual = userMgr.addUser(user);
        Assertions.assertFalse(actual);
    }

    @Test
    public void requestEncodeTestSuccess() throws Exception{
        UserMgr userMgr = new UserMgr();
        String expected = "Khoor, zruog!";
        String actual = userMgr.requestEncode("Default", "User", "Hello, world!");
        assertEquals(expected, actual);
    }

    @Test
    public void requestEncodeTestFail(){
        Assertions.assertThrows(Exception.class, ()->{
            UserMgr userMgr = new UserMgr();
            userMgr.requestEncode("Earl", "Sweatshirt", "Hello, world!");
        });
    }
}
