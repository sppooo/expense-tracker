package com.expensetracker;

import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        // TODO: Initialize UI, set up controllers and services
        primaryStage.setTitle("Smart Expense Tracker");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}