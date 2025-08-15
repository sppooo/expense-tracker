# Smart Expense Tracker with AI Insights

A modern Java application to help you track your expenses, visualize financial trends, and receive AI-powered insights to improve your spending habits.

## Features

- **User Authentication:** Secure login/signup
- **Transaction Management:** Add/edit/delete expenses and income
- **Categorization:** Organize spending by category
- **Recurring Payments:** Track regular bills and subscriptions
- **Data Visualization:** Charts and graphs of your finances
- **AI Insights:** Detect habits, offer savings suggestions
- **Notifications:** Reminders for bills and spending alerts
- **Export & Backup:** CSV/Excel export, local/cloud backup

## Technology Stack

- **Java 17+**
- **JavaFX** (UI)
- **SQLite** (local database) or **MySQL/PostgreSQL**
- **JDBC/Hibernate** (ORM)
- **JUnit/Mockito** (testing)
- **JFreeChart** or **JavaFX Charts** (visualization)
- **Smile** (optional, for ML/AI)
- **Maven** or **Gradle** (build tool)

## Project Structure

```plaintext
smart-expense-tracker/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.expensetracker/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       ├── controller/
│   │   │       ├── ai/
│   │   │       └── utils/
│   │   └── resources/
│   ├── test/
│   │   └── java/
├── build.gradle or pom.xml
├── README.md
└── .gitignore
```

## Getting Started

1. **Clone the repository**
    ```sh
    git clone https://github.com/yourusername/smart-expense-tracker.git
    cd smart-expense-tracker
    ```
2. **Build the project**
    ```sh
    ./gradlew build
    # or
    mvn install
    ```
3. **Run the application**
    ```sh
    ./gradlew run
    # or
    mvn javafx:run
    ```

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License

[MIT](LICENSE)