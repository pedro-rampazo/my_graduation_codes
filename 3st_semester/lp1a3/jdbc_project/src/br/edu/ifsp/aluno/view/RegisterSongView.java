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
import br.edu.ifsp.aluno.dao.SongDAO;
import br.edu.ifsp.aluno.model.Album;
import br.edu.ifsp.aluno.model.Song;

public class RegisterSongView extends JFrame {
    private JLabel nameLabel = new JLabel("Nome:");
    private JTextField nameTextField = new JTextField(20);
    private JLabel durationLabel = new JLabel("Duração:");
    private JTextField durationTextField = new JTextField(20);
    private JLabel trackLabel = new JLabel("Faixa:");
    private JTextField trackTextField = new JTextField(20);
    private JLabel albumLabel = new JLabel("Álbum:");
    private JComboBox albumComboBox = new JComboBox<>();
    private JButton registerButton = new JButton("Cadastrar");
    private JPanel panel = new JPanel();

    public RegisterSongView() throws SQLException {
        setTitle("Nova Música");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(5, 2, 5, 5));
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(durationLabel);
        panel.add(durationTextField);
        panel.add(trackLabel);
        panel.add(trackTextField);
        panel.add(albumLabel);
        panel.add(albumComboBox);
        panel.add(registerButton);

        loadComboBoxAlbums();

        registerButton.addActionListener(e -> {
            String name = nameTextField.getText();
            String duration = durationTextField.getText();
            String track = trackTextField.getText();
            Album album = (Album) albumComboBox .getSelectedItem();

            ArrayList<String> errors = new ArrayList<>();

            if (name.isBlank()) {
                errors.add("Nome não pode ser vazio");
            }

            try {
                Integer trackInteger = Integer.parseInt(track);
            } catch (Exception ex) {
                if (!track.isBlank()) {
                    errors.add("A faixa é inválida");
                }
            }

            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(
                    RegisterSongView.this,
                    String.join("\n", errors),
                    "Erro ao cadastrar",
                    JOptionPane.ERROR_MESSAGE
                );
            } else {
                
                try {
                    SongDAO songDao = new SongDAO();
                    Song song = new Song(name, duration, Integer.parseInt(track), album);
                    Song savedSong = songDao.create(song);
                    JOptionPane.showMessageDialog(
                        RegisterSongView.this,
                        "Música cadastrada com sucesso id: " + savedSong.getId(),
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

    private void loadComboBoxAlbums() throws SQLException {
        albumComboBox.removeAllItems();
        for (Album a : new AlbumDAO().findAll()) {
            albumComboBox.addItem(a);
        }
    }

    private void cleanTextFields() throws SQLException {
        nameTextField.setText("");
        durationTextField.setText("");
        trackTextField.setText("");
        loadComboBoxAlbums();
    }

}
