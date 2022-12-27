import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginPage() {
        // Set the title and layout of the frame
        super("Login");
        setLayout(new FlowLayout());

        // Create the username field and label
        JLabel usernameLabel = new JLabel("Username: ");
        usernameField = new JTextField(20);
        add(usernameLabel);
        add(usernameField);

        // Create the password field and label
        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField(20);
        add(passwordLabel);
        add(passwordField);

        // Create the login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());
        add(loginButton);

        // Set the size and location of the frame, and make it visible
        setPreferredSize(new Dimension(300, 100));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the username and password from the fields
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Validate the username and password (replace with your own logic)
            if (username.equals("admin") && new String(password).equals("password")) {
                // If the username and password are valid, show a message and close the frame
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Login successful!");
                panel.add(label);
                add(panel);
                setVisible(true);
                setSize(300, 100);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } else {
                // If the username and password are invalid, show an error message
                JPanel panel = new JPanel();
                JLabel label = new JLabel("Error: Invalid username or password");
                panel.add(label);
                add(panel);
                setVisible(true);
                setSize(300, 100);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}