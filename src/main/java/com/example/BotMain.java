package com.example.telegrambot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotMain extends TelegramLongPollingBot {

    public static void main(String[] args) throws Exception {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new BotMain());
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (message.equals("/start")) {
                SendMessage response = new SendMessage();
                response.setChatId(String.valueOf(chatId));
                response.setText("Hello, I'm alive!");
                try {
                    execute(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "wbg_noc_bot";
    }

    @Override
    public String getBotToken() {
        return System.getenv("7132927335:AAG-sxdPWfH_YEj4SI-NcyNEnRR1p_bQxZI");
    }
}
