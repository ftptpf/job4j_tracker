package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Работа с базой данных.
 */
public class SqlTracker implements Store {
    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement pStatement = cn.prepareStatement("INSERT INTO items (name) VALUES (?)",
                Statement.RETURN_GENERATED_KEYS)) {
            pStatement.setString(1, item.getName());
            pStatement.execute();
            try (ResultSet getGeneratedKey = pStatement.getGeneratedKeys()) {
                if (getGeneratedKey.next()) {
                    item.setId(getGeneratedKey.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement pdStatement = cn.prepareStatement("UPDATE items SET name = ? WHERE id = ?")) {
            pdStatement.setString(1, item.getName());
            pdStatement.setInt(2, id);
            result = pdStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement pStatement = cn.prepareStatement("DELETE FROM items WHERE id = ?")) {
            pStatement.setInt(1, id);
            result = pStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pStatement = cn.prepareStatement("SELECT * FROM items")) {
            try (ResultSet resultSet = pStatement.executeQuery()) {
                while (resultSet.next()) {
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name")
                    ));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        return null;
    }

    @Override
    public Item findById(int id) {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
