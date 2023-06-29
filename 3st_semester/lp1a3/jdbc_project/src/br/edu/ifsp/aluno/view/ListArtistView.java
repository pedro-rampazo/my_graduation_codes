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

import br.edu.ifsp.aluno.dao.ArtistDAO;
import br.edu.ifsp.aluno.model.Artist;

public class ListArtistView extends JDialog {
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JPanel panel;
    private ArtistDAO artistDao;

    public ListArtistView(ArtistDAO artistDao) {
        this.artistDao = artistDao;
        setTitle("List Artists");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);

        tableModel = new DefaultTableModel(
            new Object[] {"ID", "Name", "Origin", "Formed In", "Genre"},
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
            List<Artist> artists = artistDao.findAll();

            for (Artist a : artists) {
                Object[] row = {
                    a.getId(),
                    a.getName(),
                    a.getOrigin(),
                    a.getFormedIn(),
                    a.getGenre()
                }; 
                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                ListArtistView.this,
                "Erro ao acessar o banco de dados",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
