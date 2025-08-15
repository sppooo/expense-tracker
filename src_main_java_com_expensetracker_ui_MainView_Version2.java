package com.expensetracker.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Top: Navigation Bar
        MenuBar menuBar = new MenuBar();
        Menu accountMenu = new Menu("Account");
        accountMenu.getItems().addAll(new MenuItem("Profile"), new MenuItem("Logout"));
        Menu dataMenu = new Menu("Data");
        dataMenu.getItems().addAll(new MenuItem("Export"), new MenuItem("Backup"));
        menuBar.getMenus().addAll(accountMenu, dataMenu);

        // Left: Categories/Filters
        VBox categoriesBox = new VBox(10);
        categoriesBox.setPadding(new Insets(10));
        categoriesBox.getChildren().add(new Label("Categories"));
        ListView<String> categoryList = new ListView<>();
        categoryList.getItems().addAll("All", "Food", "Utilities", "Entertainment", "Transport", "Other");
        categoriesBox.getChildren().add(categoryList);

        // Center: Transactions Table
        TableView<String> transactionTable = new TableView<>();
        transactionTable.setPlaceholder(new Label("No transactions yet."));
        transactionTable.setPrefWidth(500);

        // Right: AI Insights & Charts
        VBox rightBox = new VBox(15);
        rightBox.setPadding(new Insets(10));
        rightBox.getChildren().add(new Label("AI Insights"));
        TextArea insightArea = new TextArea("Sample insight: You spend most on Food.");
        insightArea.setEditable(false);
        insightArea.setWrapText(true);
        insightArea.setPrefHeight(100);

        rightBox.getChildren().add(insightArea);
        rightBox.getChildren().add(new Separator());
        rightBox.getChildren().add(new Label("Spending Chart"));
        // Placeholder for chart (actual chart code to be added later)
        Pane chartPlaceholder = new Pane();
        chartPlaceholder.setStyle("-fx-background-color: #f0f0f0; -fx-border-color: #ccc;");
        chartPlaceholder.setPrefSize(250, 200);
        rightBox.getChildren().add(chartPlaceholder);

        // Bottom: Add Transaction Form
        HBox addTransactionBox = new HBox(10);
        addTransactionBox.setPadding(new Insets(10));
        TextField amountField = new TextField();
        amountField.setPromptText("Amount");
        ComboBox<String> categoryField = new ComboBox<>();
        categoryField.getItems().addAll("Food", "Utilities", "Entertainment", "Transport", "Other");
        categoryField.setPromptText("Category");
        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("Date");
        TextField descField = new TextField();
        descField.setPromptText("Description");
        Button addButton = new Button("Add Transaction");
        addTransactionBox.getChildren().addAll(amountField, categoryField, datePicker, descField, addButton);

        // Main Layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(menuBar);
        mainLayout.setLeft(categoriesBox);
        mainLayout.setCenter(transactionTable);
        mainLayout.setRight(rightBox);
        mainLayout.setBottom(addTransactionBox);

        Scene scene = new Scene(mainLayout, 900, 600);
        primaryStage.setTitle("Smart Expense Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}