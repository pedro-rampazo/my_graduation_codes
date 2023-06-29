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

import br.edu.ifsp.aluno.dao.AlbumDAO;
import br.edu.ifsp.aluno.model.Album;


public class ListAlbumView extends JDialog {
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JPanel panel;
    private AlbumDAO albumDao;

    public ListAlbumView(AlbumDAO albumDao) {
        this.albumDao = albumDao;
        setTitle("List Albums");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);

        tableModel = new DefaultTableModel(
            new Object[] {"ID", "Name", "Year", "Label", "Artist"},
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
            List<Album> albums = albumDao.findAll();

            for (Album a : albums) {
                Object[] row = {
                    a.getId(),
                    a.getName(),
                    a.getYear(),
                    a.getLabel(),
                    a.getArtist()
                };
                tableModel.addRow(row);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                ListAlbumView.this,
                "Erro ao acessar o banco de dados",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
