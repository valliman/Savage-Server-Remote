package view;

import controller.Tool;
import model.ConnectionManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 04.08.12
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class LoadMapForm extends JFrame{
    private JComboBox loadMapComboBox;
    private JButton loadMapButton;
    private JPanel contentPane;
    private JLabel loadMapImageLabel;
    private ConnectionManager cman;

    public LoadMapForm(ConnectionManager cman) {
        setTitle("Load Map...");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.cman=cman;
        onLoadMapForm();
        loadMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLoadMap();
            }
        });
        pack();
        setVisible(true);
        loadMapComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                onLoadMapChange();
            }
        });
    }

    private void onLoadMapChange() {
        loadMapImageLabel.setIcon(Tool.getMapImage(loadMapComboBox.getSelectedItem().toString()));
    }

    private void onLoadMapForm() {
        String mapslist=cman.get("mapslist");
        mapslist=mapslist.replace(" ","");
        mapslist=mapslist.replace("\n",",");
        mapslist=mapslist.replace("Listofmapsonthisserver:","");
        String[] maps=mapslist.split(",");
        for(String map:maps) {
            if(!map.equals("")) loadMapComboBox.addItem(map);
        }
        loadMapImageLabel.setIcon(Tool.getMapImage(loadMapComboBox.getSelectedItem().toString()));
    }

    private void onLoadMap() {
        cman.execute("world "+loadMapComboBox.getSelectedItem().toString());
    }
}
