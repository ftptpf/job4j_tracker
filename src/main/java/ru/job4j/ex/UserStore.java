package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        int rls = -1;
        User huntUser = new User(null, false);
        for (int index = 0; index < users.length; index++) {
            String search = users[index].getUsername();
            if (search.equals(login)) {
                huntUser = users[index];
                rls = index;
                break;
            }
        }
        if (rls == -1) {
            throw new UserNotFoundException("User not found. Try other name.");
        }
        return huntUser;
    }
    public static boolean validate(User user) throws UserInvalidException {
        boolean booCheck = true;
        if (user.getUsername().length() < 3 & user.isValid()) {
            booCheck = false;
            throw new UserInvalidException("User name is not valid");
        }
        return booCheck;
    }
    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User ("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        try {
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
