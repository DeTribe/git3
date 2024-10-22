package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Account;
import Model.Message;
import Service.AccountService;
import Service.MessageService;

private static final int MAX_MESSAGE_LENGTH=255;

public class SocialMediaController {
    private final MessageService messageService;
    private final AccountService accountService;

    public SocialMediaController(AccountService accountService, MessageService messageService) {
        this.accountService = accountService;
        this.messageService = messageService;
    }

    public Javalin startAPI() {
        Javalin app = Javalin.create();

        app.post("/register", this::handleRegistration);
        app.post("/login", this::handleLogin);
        app.post("/messages", this::handleCreateMessage);
        app.get("/messages", this::handleGetAllMessages);
        app.get("/messages/:message_id", this::handleGetMessageById);
        app.delete("/messages/:message_id", this::handleDeleteMessage);
        app.patch("/messages/:message_id", this::handleUpdateMessage);
        app.get("/accounts/:account_id/messages", this::handleGetMessagesByUserId);

        return app;
    }

    private void handleRegistration(Context ctx) {
    try {
        Account newAccount = ctx.bodyAsClass(Account.class);

        if (isValidRegistration(newAccount)) {
            Account createdAccount = accountService.registerAccount(newAccount);
            ctx.status(200).json(createdAccount);
        } else {
            ctx.status(400).result("Invalid registration data.");
        }
    } catch (SQLException e) {
        ctx.status(500).result("Error during registration.");
    }
}

/*throws SQLException {
        Account newAccount = ctx.bodyAsClass(Account.class);

        if (isValidRegistration(newAccount)) {
            Account createdAccount = accountService.registerAccount(newAccount);
            ctx.status(200).json(createdAccount);
        } else {
            ctx.status(400).result("Invalid registration data.");
        }
  } */

    private void handleLogin(Context ctx) throws SQLException {
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");

        if (username == null || password == null) {
            ctx.status(401).result("Username and password required.");
            return;
        }
        
        Account account = accountSerivce.login(username, password);
    }   if ( account != null) {
              ctx.status(200).json(account);
    } else {
        ctx.status(401).result( "Invalid credentials.");
}
}
    private void handleCreateMessage(Context ctx) throws SQLException {
        Message newMessage = ctx.bodyAsClass(Message.class);

        if (isValidMessage(newMessage)) {
            Message createdMessage = messageService.createMessage(newMessage);
            ctx.status(200).json(createdMessage);
        } else {
            ctx.status(400).result("Invalid message data.");
        }
    }

    private void handleGetAllMessages(Context ctx) throws SQLException {
        List<Message> messages = messageService.getAllMessages();
        ctx.status(200).json(messages);
    }

    private void handleGetMessageById(Context ctx) throws SQLException {
        int messageId = Integer.parseInt(ctx.pathParam("message_id"));
        Message message = messageService.getMessageById(messageId);

        if (message != null) {
            ctx.status(200).json(message);
        } else {
            ctx.status(404).json("Message not found");
        }
    }

    private void handleDeleteMessage(Context ctx) throws SQLException {
        int messageId = Integer.parseInt(ctx.pathParam("message_id"));
        Message deletedMessage = messageService.deleteMessage(messageId);

        if (deletedMessage != null) {
            ctx.status(200).json(deletedMessage);
        } else {
            ctx.status(404).json("Message not found");
        }
    }

 private void handleUpdateMessage(Context ctx) {
    try {
        int messageId = Integer.parseInt(ctx.pathParam("message_id"));
        JsonNode jsonNode = new ObjectMapper().readTree(ctx.body());
        String newMessageText = jsonNode.get("message_text").asText();

        if (isValidMessageText(newMessageText)) {
            Message existingMessage = messageService.getMessageById(messageId);
            if (existingMessage != null) {
                existingMessage.setMessage_text(newMessageText);
                Message updatedMessage = messageService.updateMessage(existingMessage);
                ctx.status(200).json(updatedMessage);
            } else {
                ctx.status(404).result("Message not found");
            }
        } else {
            ctx.status(400).result("Invalid message text.");
        }
    } catch (JsonProcessingException e) {
        ctx.status(400).result("Invalid JSON data.");
    }
}
  /* private void handleUpdateMessage(Context ctx) throws SQLException, JsonMappingException, JsonProcessingException {
        int messageId = Integer.parseInt(ctx.pathParam("message_id"));
        JsonNode jsonNode = new ObjectMapper().readTree(ctx.body());
        String newMessageText = jsonNode.get("message_text").asText();

        if (isValidMessageText(newMessageText)) {
            Message existingMessage = messageService.getMessageById(messageId);
            if (existingMessage != null) {
                existingMessage.setMessage_text(newMessageText);
                Message updatedMessage = messageService.updateMessage(existingMessage);
                ctx.status(200).json(updatedMessage);
            } else {
                ctx.status(404).json("Message not found");
            }
        } else {
            ctx.status(400).result("Invalid message text.");
        }
    } */

    private void handleGetMessagesByUserId(Context ctx) throws SQLException {
        int accountId = Integer.parseInt(ctx.pathParam("account_id"));
        List<Message> userMessages = messageService.getMessagesByAccountId(accountId);
        ctx.status(200).json(userMessages);
    }

    private boolean isValidRegistration(Account account) throws SQLException {
        return !account.getUsername().isEmpty() &&
                account.getPassword().length() >= 4 &&
                accountService.getAccountByUsername(account.getUsername()) == null;
    }

    private boolean isValidMessage(Message message) throws SQLException {
        return !message.getMessage_text().isEmpty() &&
                message.getMessage_text().length() <= 255 &&
                accountService.getAccountById(message.getPosted_by()) != null;
    }

    private boolean isValidMessageText(String messageText) {
        return !messageText.isEmpty() && messageText.length() <= MAX_MESSAGE_LENGTH;
    }
}
       