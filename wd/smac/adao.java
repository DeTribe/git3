package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import Model.Account;


public class AccountDAO {
     private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection ;
    }
    
    // create a new user account
    public Optional<Account> createAccount( Account account) {
       String insertSql = "Insert Into account ( username, password) Values( ? , ? )";
       try ( PreparedStatement preparedStatement = connection.prepareStatement(insertSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
           preparedStatement.setString( 1, account.getUsername());
           preparedStatement.setString( 2, account.getPassword());
    
           int rowsAffected = preparedStatement.executeUpdate();
           if ( rowsAffected == 1 ) {
              try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
            if ( generatedKeys.next()) {
                int accountId = generatedKeys.getInt( 1 );
                return Optional.of( new Account(accountId, account.getUsername(), account.getPassword()));
             }
            }
           }
         } catch (SQLException e) {
            e.printStackTrace();
         }
         return Optional.empty();
        }
        
        // Retrieve an account by username
        public Optional<Account> getAccountByUsername(String username) {
            String selectSql = "Select * From Account Where username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
                preparedStatement.setString( 1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()){
                     if ( resultSet.next()) {
                          int accountId = resultSet.getInt( "account_id");
                          String password = resultSet.getString( "password");
                          return Optional.of(new Account( accountId, username, password));
                                  
                     }
                }
            } catch (SQLException e ) {
                e.printStackTrace();

            }
            return Optional.empty();
        }
        public Optional<Account> getAccountById(int accountId) {
            String selectSql = " Select * From Account Where account_id = ?"; 
            try ( PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
                preparedStatement.setInt( 1, accountId);
                try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                    if ( resultSet.next()) {
                        String username = resultSet.getString("username");
                        String password = resultSet.getString("password");
                        return Optional.of(new Account( accountId, username, password));
                    }
                  }
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.empty();
            }                                                        
        }
    