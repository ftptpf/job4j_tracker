package ru.job4j.tracker;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Работа с базой данных.
 */
public class SqlTracker implements Store {
    private Connection cn;

    public SqlTracker(Connection connection) {
        this.cn = connection;
    }

    public void init() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(
                        Paths.get("resources/app.properties").toFile()));
            ) {
            Properties config = new Properties();
            config.load(bufferedInputStream);
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
            pStatement.executeUpdate();
            try (ResultSet getGeneratedKey = pStatement.getGeneratedKeys()) {
                if (getGeneratedKey.next()) {
                    item.setId(getGeneratedKey.getInt(1));
                }
                return item;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
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
                    Item item = new Item();
                    item.setId(resultSet.getInt("id"));
                    item.setName(resultSet.getString("name"));
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pStatement = cn.prepareStatement("SELECT * FROM items WHERE name = ?")) {
            pStatement.setString(1, key);
            try (ResultSet resultSet = pStatement.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getInt("id"));
                    item.setName(resultSet.getString("name"));
                    items.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (PreparedStatement pStatement = cn.prepareStatement("SELECT * FROM items WHERE id = ?")) {
            pStatement.setInt(1, id);
            try (ResultSet resultSet = pStatement.executeQuery()) {
                if (resultSet.next()) {
                    result = new Item();
                    result.setId(resultSet.getInt("id"));
                    result.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }
}
