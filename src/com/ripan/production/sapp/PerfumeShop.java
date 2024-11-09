package com.ripan.production.sapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class CollectCustomerInformation {
    String name;
    String address;
    String contactNumber;
    String emailId;

    public CollectCustomerInformation(String name, String address, String contactNumber, String emailId) {
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
    }

    public void displayCustomerDetailsAndBillInformation(ArrayList<Integer> selectedItems) {
        JFrame frame = new JFrame("Bill Information");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JTextArea billTextArea = new JTextArea();
        billTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(billTextArea);

        StringBuilder billInfo = new StringBuilder();
        billInfo.append("___The Royal Perfume Club___\n");
        billInfo.append("   - : Customer Details :- \n");
        billInfo.append("Name: ").append(name).append("\n");
        billInfo.append("Address: ").append(address).append("\n");
        billInfo.append("Contact Information: ").append(contactNumber).append(", ").append(emailId).append("\n\n");
        billInfo.append("--- Bill Information ---\n");
        billInfo.append(String.format("%-30s%-10s%-10s%-10s\n", "Perfume", "Price", "Quantity", "Total"));

        double totalPrice = 0.0;
        for (Integer itemId : selectedItems) {
            String itemName = getItemName(itemId);
            double itemPrice = getItemPrice(itemId);
            int quantity = 1;
            double total = itemPrice * quantity;

            billInfo.append(String.format("%-30s$%-10.2f%-10d$%-10.2f\n", itemName, itemPrice, quantity, total));
            totalPrice += total;
        }
        billInfo.append("\nTotal: $").append(totalPrice);

        billTextArea.setText(billInfo.toString());
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> frame.dispose());
        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private String getItemName(int itemId) {
        switch (itemId) {
            case 1: return "Royal Oud by Creed";
            case 2: return "Amber Aoud by Roja Parfums";
            case 3: return "Noir de Noir by Tom Ford";
            case 4: return "Mon Guerlain by Guerlain";
            case 5: return "Flowerbomb by Viktor & Rolf";
            case 6: return "Oud Wood by Tom Ford";
            case 7: return "Sauvage by Dior";
            case 8: return "Black Opium by Yves Saint Laurent";
            case 9: return "Acqua di Gio by Giorgio Armani";
            case 10: return "Coco Mademoiselle by Chanel";
            default: return "Unknown Perfume";
        }
    }

    private double getItemPrice(int itemId) {
        switch (itemId) {
            case 1: return 100.0;
            case 2: return 400.0;
            case 3: return 150.0;
            case 4: return 50.0;
            case 5: return 250.0;
            case 6: return 300.0;
            case 7: return 120.0;
            case 8: return 210.0;
            case 9: return 20.0;
            case 10: return 250.0;
            default: return 0.0;
        }
    }
}

class GenerateLuckyNumbers {
    public List<Integer> generateLuckyNumbers(ArrayList<Integer> luckyNumbers, int num) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            int randomNumberIndex = random.nextInt(luckyNumbers.size());
            numbers.add(luckyNumbers.get(randomNumberIndex));
            luckyNumbers.remove(randomNumberIndex);
        }
        return numbers;
    }

    public void checkResult(ArrayList<Integer> checkLuckyNumbers, int numberGuessedByCustomer) {
        int firstLuckyNumber = checkLuckyNumbers.get(0);
        int secondLuckyNumber = checkLuckyNumbers.get(1);
        int thirdLuckyNumber = checkLuckyNumbers.get(2);

        if (numberGuessedByCustomer == firstLuckyNumber) {
            if (numberGuessedByCustomer == secondLuckyNumber && numberGuessedByCustomer == thirdLuckyNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won the first prize.");
            } else if (numberGuessedByCustomer == secondLuckyNumber || numberGuessedByCustomer == thirdLuckyNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won the second prize.");
            } else {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won the third prize.");
            }
        } else if (numberGuessedByCustomer == secondLuckyNumber) {
            if (numberGuessedByCustomer == thirdLuckyNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won the second prize.");
            } else {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won the third prize.");
            }
        } else if (numberGuessedByCustomer == thirdLuckyNumber) {
            JOptionPane.showMessageDialog(null, "Congratulations! You've won the third prize.");
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, you guessed the wrong lucky number.\nThank you for visiting our shop.");
        }
    }
}

public class PerfumeShop {
    private static CollectCustomerInformation customer1;
    private static GenerateLuckyNumbers generateLuckyNumbers = new GenerateLuckyNumbers();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Online Perfume Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField nameField = new JTextField(20);
        JTextField addressField = new JTextField(20);
        JTextField contactField = new JTextField(20);
        JTextField emailField = new JTextField(20);
        JButton submitButton = new JButton("Submit");

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Address:"));
        panel.add(addressField);
        panel.add(new JLabel("Contact Number:"));
        panel.add(contactField);
        panel.add(new JLabel("Email ID:"));
        panel.add(emailField);
        panel.add(submitButton);

        JTextArea itemList = new JTextArea(10, 40);
        itemList.setText("1. Royal Oud by Creed : $100\n" +
                "2. Amber Aoud by Roja Parfums : $400\n" +
                "3. Noir de Noir by Tom Ford : $150\n" +
                "4. Mon Guerlain by Guerlain : $50\n" +
                "5. Flowerbomb by Viktor & Rolf : $250\n" +
                "6. Oud Wood by Tom Ford : $300\n" +
                "7. Sauvage by Dior : $120\n" +
                "8. Black Opium by Yves Saint Laurent : $210\n" +
                "9. Acqua di Gio by Giorgio Armani : $20\n" +
                "10. Coco Mademoiselle by Chanel : $250\n");
        itemList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(itemList);
        panel.add(scrollPane);

        JTextField itemsField = new JTextField(20);
        panel.add(new JLabel("Enter Item IDs to Buy (comma-separated):"));
        panel.add(itemsField);

        JTextField luckyNumberField = new JTextField(20);
        panel.add(new JLabel("Enter your lucky number:"));
        panel.add(luckyNumberField);

        JButton generateBillButton = new JButton("Generate Bill");
        JButton checkLuckyNumberButton = new JButton("Check Lucky Number");
        panel.add(generateBillButton);
        panel.add(checkLuckyNumberButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String address = addressField.getText();
                String contact = contactField.getText();
                String email = emailField.getText();
                customer1 = new CollectCustomerInformation(name, address, contact, email);
                JOptionPane.showMessageDialog(frame, "Customer information submitted successfully.");
            }
        });

        generateBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemsText = itemsField.getText();
                String[] itemsArray = itemsText.split(",");
                ArrayList<Integer> selectedItems = new ArrayList<>();
                for (String item : itemsArray) {
                    selectedItems.add(Integer.parseInt(item.trim()));
                }
                customer1.displayCustomerDetailsAndBillInformation(selectedItems);
            }
        });

        checkLuckyNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guessedNumber = Integer.parseInt(luckyNumberField.getText());
                ArrayList<Integer> luckyNumbers = new ArrayList<>();
                for (int i = 1; i <= 10; i++) {
                    luckyNumbers.add(i);
                }
                List<Integer> generatedNumbers = generateLuckyNumbers.generateLuckyNumbers(luckyNumbers, 3);
                generateLuckyNumbers.checkResult(new ArrayList<>(generatedNumbers), guessedNumber);
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
