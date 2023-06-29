package br.edu.ifsp.aluno.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.edu.ifsp.aluno.dao.SongDAO;
import br.edu.ifsp.aluno.model.Song;

public class ListSongView extends JDialog {
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JPanel panel;
    private SongDAO songDao;

    public ListSongView(SongDAO songDao) {
        this.songDao = songDao;
        setTitle("List Songs");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);

        tableModel = new DefaultTableModel(
            new Object[] {"ID", "Name", "Duration", "Track", "Album"},
            0
        );

        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);

        panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        loadData();

        getContentPane().add(panel);

        setVisible(true);
    }

    private void loadData() {
        try {
            List<Song> songs = songDao.findAll();

            for (Song s : songs) {
                Object[] row = {
                    s.getId(),
                    s.getName(),
                    s.getDuration(),
                    s.getTrack(),
                    s.getAlbum()
                };
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                ListSongView.this,
                "Erro ao acessar o banco de dados",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
