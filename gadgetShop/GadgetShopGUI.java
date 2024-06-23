import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GadgetShopGUI {
    private static GadgetShopGUI gadgetShopGUI;

    private ArrayList<Gadget> gadgets;
    private JFrame frame;
    private JTextField modelField, priceField, weightField, sizeField,
    creditField, memoryField, displayNumberField, phoneNumberField, durationField, 
    downloadSizeField, addCreditField, deleteMusicSizeField;

    private JTextArea displayArea;

    public GadgetShopGUI() {
        gadgets = new ArrayList<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Gadget Shop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));

        modelField = new JTextField(20);
        priceField = new JTextField(20);
        weightField = new JTextField(20);
        sizeField = new JTextField(20);
        creditField = new JTextField(20);
        memoryField = new JTextField(20);
        displayNumberField = new JTextField(20);
        phoneNumberField = new JTextField(20);
        durationField = new JTextField(20);
        downloadSizeField = new JTextField(20);
        addCreditField = new JTextField(20);
        deleteMusicSizeField = new JTextField(20);

        inputPanel.add(new JLabel(" Model:"));
        inputPanel.add(modelField);
        inputPanel.add(new JLabel(" Price (£):"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel(" Weight (g):"));
        inputPanel.add(weightField);
        inputPanel.add(new JLabel(" Size:"));
        inputPanel.add(sizeField);
        inputPanel.add(new JLabel(" Initial Credit (min):"));
        inputPanel.add(creditField);
        inputPanel.add(new JLabel(" Initial Memory (MB):"));
        inputPanel.add(memoryField);
        inputPanel.add(new JLabel(" Display Number:"));
        inputPanel.add(displayNumberField);
        inputPanel.add(new JLabel(" Phone Number:"));
        inputPanel.add(phoneNumberField);
        inputPanel.add(new JLabel(" Duration (minutes):"));
        inputPanel.add(durationField);
        inputPanel.add(new JLabel(" Download Size (MB):"));
        inputPanel.add(downloadSizeField);
        inputPanel.add(new JLabel(" Add Credit (min):"));
        inputPanel.add(addCreditField);
        inputPanel.add(new JLabel(" Delete Music Size (MB):"));
        inputPanel.add(deleteMusicSizeField);

        JPanel buttonPanel = new JPanel();
        JButton addMobileButton = new JButton("Add Mobile");
        addMobileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMobile();
            }
        });
        JButton addMP3Button = new JButton("Add MP3");
        addMP3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addMP3();
            }
        });
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        JButton displayAllButton = new JButton("Display All");
        displayAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAll();
            }
        });
        JButton makeCallButton = new JButton("Make A Call");
        makeCallButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeCall();
            }
        });
        JButton downloadMusicButton = new JButton("Download Music");
        downloadMusicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                downloadMusic();
            }
        });
        JButton addCreditButton = new JButton("Add Credit");
        addCreditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addCredit();
            }
        });
        JButton deleteMusicButton = new JButton("Delete Music");
        deleteMusicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteMusic();
            }
        });


        buttonPanel.add(addMobileButton);
        buttonPanel.add(addMP3Button);
        buttonPanel.add(clearButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(makeCallButton);
        buttonPanel.add(downloadMusicButton);
        buttonPanel.add(addCreditButton);
        buttonPanel.add(deleteMusicButton);

        displayArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(scrollPane, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void addMobile() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int credit = Integer.parseInt(creditField.getText());

            Mobile mobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(mobile);
            displayArea.append("Mobile added: " + model + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Error: Invalid input format. Please enter numbers for price, weight, and credit.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addMP3() {
        try {
            String model = modelField.getText();
            double price = Double.parseDouble(priceField.getText());
            int weight = Integer.parseInt(weightField.getText());
            String size = sizeField.getText();
            int memory = Integer.parseInt(memoryField.getText());

            MP3player mp3 = new MP3player(model, price, weight, size, memory);
            gadgets.add(mp3);
            displayArea.append("MP3 added: " + model + "\n");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Error: Invalid input format. Please enter numbers for price, weight, and memory.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        modelField.setText("");
        priceField.setText("");
        weightField.setText("");
        sizeField.setText("");
        creditField.setText("");
        memoryField.setText("");
        displayNumberField.setText("");
        phoneNumberField.setText("");
        durationField.setText("");
        downloadSizeField.setText("");
        addCreditField.setText("");
        deleteMusicSizeField.setText("");
        displayArea.setText("");
    }

    public void displayAll() {
        displayArea.setText("");
        for (int i = 0; i < gadgets.size(); i++) {
            displayArea.append("Gadget " + i + ":\n");
            Gadget gadget = gadgets.get(i);
            displayArea.append("Model: " + gadget.getModel() + "\n");
            displayArea.append("Price: £" + gadget.getPrice() + "\n");
            displayArea.append("Weight: " + gadget.getWeight() + "g\n");
            displayArea.append("Size: " + gadget.getSize() + "\n");
            displayArea.append("\n");
        }
    }

    private void makeCall() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                Mobile mobile = (Mobile) gadgets.get(displayNumber);
                String phoneNumber = phoneNumberField.getText();
                int duration = Integer.parseInt(durationField.getText());
                mobile.makeCall(phoneNumber, duration);
            } else {
                JOptionPane.showMessageDialog(frame, "Error: Invalid display number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Error: Invalid input format. Please enter a valid number for display number and duration.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(frame, "Error: The selected gadget is not a mobile.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void downloadMusic() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                MP3player mp3 = (MP3player) gadgets.get(displayNumber);
                int downloadSize = Integer.parseInt(downloadSizeField.getText());
                mp3.downloadMusic(downloadSize);
            } else {
                JOptionPane.showMessageDialog(frame, "Error: Invalid display number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Error: Invalid input format. Please enter a valid number for display number and download size.", "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(frame, "Error: The selected gadget is not an MP3 player.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void addCredit() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                Mobile mobile = (Mobile) gadgets.get(displayNumber);
                int credit = Integer.parseInt(addCreditField.getText());
                mobile.addCredit(credit);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid display number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input format. Please enter a valid number for display number and credit amount.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(frame, "The selected gadget is not a mobile.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteMusic() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber >= 0 && displayNumber < gadgets.size()) {
                MP3player mp3 = (MP3player) gadgets.get(displayNumber);
                int deleteSize = Integer.parseInt(deleteMusicSizeField.getText());
                mp3.deleteMusic(deleteSize);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid display number.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input format. Please enter a valid number for display number and delete size.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ClassCastException ex) {
            JOptionPane.showMessageDialog(frame, "The selected gadget is not an MP3 player.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        if (gadgetShopGUI == null) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    gadgetShopGUI = new GadgetShopGUI();
                }
            });
        }
    }
}