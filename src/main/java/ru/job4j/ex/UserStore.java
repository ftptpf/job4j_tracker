package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User huntUser = null;
        for (int index = 0; index < users.length; index++) {
            String search = users[index].getUsername();
            if (search.equals(login)) {
                huntUser = users[index];
                break;
            }
        }
        if (huntUser == null) {
            throw new UserNotFoundException("User not found. Try other name.");
        }
        return huntUser;
    }
    public static boolean validate(User user) throws UserInvalidException {
        boolean booChek = true;
        if (user.getUsername().length() < 3 || !user.isValid()) {
            booChek = false;
            throw new UserInvalidException("User name is not valid");
        }
        return booChek;
    }
    public static void main(String[] args){

        User[] users = {
                new User ("Petr Arsentev", true)
        };
        User user = new User("Pe", true);
        try {
            user = findUser(users, user.getUsername());
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
