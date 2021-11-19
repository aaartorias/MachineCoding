package main.java.com.interfaces;

public interface IUserRepository {
    public User addUser(String name, String email, String phone);
    public User getUser(Integer id);
}
