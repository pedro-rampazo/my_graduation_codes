package br.edu.ifsp.aluno.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import br.edu.ifsp.aluno.dao.AlbumDAO;
import br.edu.ifsp.aluno.dao.ArtistDAO;
import br.edu.ifsp.aluno.dao.SongDAO;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainView extends JFrame {
    private JButton registerArtistBttn;
    private JButton listArtistBttn;
    private JButton registerAlbumBttn;
    private JButton listAlbumBttn;
    private JButton registerSongBttn;
    private JButton listSongBttn;
    private JPanel panel;

    public MainView() throws SQLException {
        setTitle("JDBC Project");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerArtistBttn = new JButton("(Artista) Cadastrar");
        listArtistBttn = new JButton("(Artista) Listar");
        registerAlbumBttn = new JButton("(Álbum) Cadastrar");
        listAlbumBttn = new JButton("(Álbum) Listar");
        registerSongBttn = new JButton("(Música) Cadastrar");
        listSongBttn = new JButton("(Música) Listar");
        
        registerArtistBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterArtistView();
            }
        });
        
        registerAlbumBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new RegisterAlbumView();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        registerSongBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new RegisterSongView();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        listArtistBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListArtistView(new ArtistDAO());
            }
        });

        listAlbumBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListAlbumView(new AlbumDAO());
            }
        });

        listSongBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListSongView(new SongDAO());
            }
        });

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(registerArtistBttn);
        panel.add(listArtistBttn);
        panel.add(registerAlbumBttn);
        panel.add(listAlbumBttn);
        panel.add(registerSongBttn);
        panel.add(listSongBttn);

        getContentPane().add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainView();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
