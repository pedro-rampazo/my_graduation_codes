package br.edu.ifsp.aluno.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.ifsp.aluno.dao.ArtistDAO;
import br.edu.ifsp.aluno.model.Artist;

public class RegisterArtistView extends JFrame {
    private JLabel nameLabel = new JLabel("Nome:");
    private JTextField nameTextField = new JTextField(20);
    private JLabel originLabel = new JLabel("Origem:");
    private JTextField originTextField = new JTextField(20);
    private JLabel formedInLabel = new JLabel("Formado em:");
    private JTextField formedInTextField = new JTextField(20);
    private JLabel genreLabel = new JLabel("Gênero:");
    private JTextField genreTextField = new JTextField(20);
    private JButton registerButton = new JButton("Cadastrar");
    private JPanel panel = new JPanel();

    public RegisterArtistView() {
        setTitle("Novo Artista");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(originLabel);
        panel.add(originTextField);
        panel.add(formedInLabel);
        panel.add(formedInTextField);
        panel.add(genreLabel);
        panel.add(genreTextField);
        panel.add(registerButton);

        registerButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String origin = originTextField.getText();
            String formedIn = formedInTextField.getText();
            String genre = genreTextField.getText();
            Integer formedInInteger;

            ArrayList<String> errors = new ArrayList<>();

            if (name.isBlank()) {
                errors.add("Nome não pode ser vazio");
            }

            try {
                formedInInteger = Integer.parseInt(formedIn);
            } catch (Exception ex) {
                if (!formedIn.isBlank()) {
                    errors.add("O ano de formação é inválido");
                }
            }

            if (genre.isBlank()) {
                errors.add("Gênero não pode ser vazio");
            }

            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(
                    RegisterArtistView.this,
                    String.join("\n", errors),
                    "Erro ao cadastrar",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                try {
                    ArtistDAO artistDao = new ArtistDAO();
                    Artist artist = new Artist(name, origin, Integer.parseInt(formedIn), genre);
                    Artist savedArtist = artistDao.create(artist);
                    JOptionPane.showMessageDialog(
                        RegisterArtistView.this,
                        "Artista cadastrado com sucesso id: " + savedArtist.getId(),
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    cleanTextFields();
                } catch (Exception ex) {

                }
            }
        });
        getContentPane().add(panel);
        setResizable(false);
        setVisible(true);
    }

    private void cleanTextFields() {
        nameTextField.setText("");
        originTextField.setText("");
        formedInTextField.setText("");
        genreTextField.setText("");
    }

}
