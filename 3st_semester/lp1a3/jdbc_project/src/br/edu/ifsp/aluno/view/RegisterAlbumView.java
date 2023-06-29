package br.edu.ifsp.aluno.view;

import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.ifsp.aluno.dao.AlbumDAO;
import br.edu.ifsp.aluno.dao.ArtistDAO;
import br.edu.ifsp.aluno.model.Album;
import br.edu.ifsp.aluno.model.Artist;

public class RegisterAlbumView extends JFrame {
    private JLabel nameLabel = new JLabel("Nome:");
    private JTextField nameTextField = new JTextField(20);
    private JLabel yearLabel = new JLabel("Ano:");
    private JTextField yearTextField = new JTextField(20);
    private JLabel labelLabel = new JLabel("Gravadora:");
    private JTextField labelTextField = new JTextField(20);
    private JLabel artistLabel = new JLabel("Artista:");
    private JComboBox artistComboBox = new JComboBox<>();
    private JButton registerButton = new JButton("Cadastrar");
    private JPanel panel = new JPanel();

    
    public RegisterAlbumView() throws SQLException {
        setTitle("Novo Álbum");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(yearLabel);
        panel.add(yearTextField);
        panel.add(labelLabel);
        panel.add(labelTextField);
        panel.add(artistLabel);
        panel.add(artistComboBox);
        panel.add(registerButton);

        loadComboBoxArtists();

        registerButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String year = yearTextField.getText();
            String label = labelTextField.getText();
            Artist artist = (Artist) artistComboBox.getSelectedItem();

            ArrayList<String> errors = new ArrayList<>();

            if (name.isBlank()) {
                errors.add("Nome não pode ser vazio");
            }

            try {
                Integer yearInteger = Integer.parseInt(year);
            } catch (Exception ex) {
                if (!year.isBlank()) {
                    errors.add("O ano de lançamento é inválido");
                }
            }

            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(
                    RegisterAlbumView.this,
                    String.join("\n", errors),
                    "Erro ao cadastrar",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                try {
                    AlbumDAO albumDao = new AlbumDAO();
                    Album album = new Album(name, Integer.parseInt(year), label, artist);
                    Album savedAlbum = albumDao.create(album);
                    JOptionPane.showMessageDialog(
                        RegisterAlbumView.this,
                        "Álbum cadastrado com sucesso id: " + savedAlbum.getId(),
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                    cleanTextFields();
                } catch (Exception ex) {
                    // TODO: handle exception
                }
            }
        });
        getContentPane().add(panel);
        setResizable(false);
        setVisible(true);
    }

    private void loadComboBoxArtists() throws SQLException {
        artistComboBox.removeAllItems();
        for (Artist a : new ArtistDAO().findAll()) {
            artistComboBox.addItem(a);
        }
    }

    private void cleanTextFields() throws SQLException {
        nameTextField.setText("");
        yearTextField.setText("");
        labelTextField.setText("");
        loadComboBoxArtists();
    }

}
