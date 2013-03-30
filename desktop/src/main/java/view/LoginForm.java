package view;

import controller.Tool;
import model.ConnectionManager;
import model.DBManager;
import model.Favorite;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Bernhard
 * Date: 07.07.12
 * Time: 13:00
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends JFrame{
    private JTextField ipTextField;
    private JTextField portTextField;
    private JPasswordField passwordTextField;
    private JList favoritesList;
    private DefaultListModel favoritesListModel;
    private JButton connectButton;
    private JButton addToFavoritesButton;
    private JButton removeFromFavoritesButton;
    private JButton upButton;
    private JButton downButton;
    private JPanel contentPane;

    public LoginForm() {
        setTitle("Login");
        setContentPane(contentPane);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConnect();
            }
        });
        loadFavorites();
        addToFavoritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onAddToFavorites();
            }
        });
        removeFromFavoritesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRemoveFromFavorites();
            }
        });
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        favoritesList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                onFavoritesListChange();
            }
        });
        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onUpButton();
            }
        });
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onDownButton();
            }
        });
    }

    private void onDownButton() {
        DBManager dbman=new DBManager();
        if(favoritesList.getSelectedIndex()!=favoritesList.getLastVisibleIndex()) {
            Favorite involved1=dbman.get(new Favorite(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[0], Integer.parseInt(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[1])));
            Favorite involved2=dbman.get(new Favorite(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()+1).toString().split(":")[0], Integer.parseInt(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()+1).toString().split(":")[1])));
            List<Favorite> oldlist=dbman.getAll();
            dbman.deleteAll();
            List<Favorite> newlist=new ArrayList<Favorite>();
            for(Favorite f:oldlist) {
                if (f.getId()==involved1.getId()) {
                    newlist.add(involved2);
                }
                else if (f.getId()==involved2.getId()) {
                    newlist.add(involved1);
                }
                else {
                    newlist.add(f);
                }
            }
            dbman.saveList(newlist);
            dbman.close();
            loadFavorites();
        }
    }

    private void onUpButton() {
        DBManager dbman=new DBManager();
        if(favoritesList.getSelectedIndex()!=0) {
            Favorite involved1=dbman.get(new Favorite(favoritesListModel.getElementAt(favoritesList.getSelectedIndex() - 1).toString().split(":")[0], Integer.parseInt(favoritesListModel.getElementAt(favoritesList.getSelectedIndex() - 1).toString().split(":")[1])));
            Favorite involved2=dbman.get(new Favorite(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[0], Integer.parseInt(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[1])));
            List<Favorite> oldlist=dbman.getAll();
            dbman.deleteAll();
            List<Favorite> newlist=new ArrayList<Favorite>();
            for(Favorite f:oldlist) {
                if (f.getId()==involved1.getId()) {
                    newlist.add(involved2);
                }
                else if (f.getId()==involved2.getId()) {
                    newlist.add(involved1);
                }
                else {
                    newlist.add(f);
                }
            }
            dbman.saveList(newlist);
            dbman.close();
            loadFavorites();
        }
    }

    private void onFavoritesListChange() {
        if(favoritesList.getSelectedIndex()!=-1 && favoritesList.getSelectedIndex()!=favoritesList.getLastVisibleIndex()+1) {
            DBManager dbman=new DBManager();
            Favorite f=dbman.get(new Favorite(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[0], Integer.parseInt(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[1])));
            ipTextField.setText(f.getIp());
            portTextField.setText(""+f.getPort());
            passwordTextField.setText(f.getPassword());
            dbman.close();
        }
    }

    private void onRemoveFromFavorites() {
        DBManager dbman=new DBManager();
        dbman.delete(new Favorite(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[0], Integer.parseInt(favoritesListModel.getElementAt(favoritesList.getSelectedIndex()).toString().split(":")[1])));
        favoritesListModel.removeElementAt(favoritesList.getSelectedIndex());
        dbman.close();
    }

    private void loadFavorites() {
        DBManager dbman=new DBManager();
        favoritesListModel=new DefaultListModel();
        for (Favorite f:dbman.getAll()) {
            favoritesListModel.addElement(f.getIp() + ":" + f.getPort());
        }
        favoritesList.setModel(favoritesListModel);
        dbman.close();
    }

    private void onAddToFavorites() {
        DBManager dbman=new DBManager();
        if(Tool.isValid(ipTextField.getText(), portTextField.getText(), passwordTextField.getText())) {
            dbman.save(new Favorite(ipTextField.getText(),Integer.parseInt(portTextField.getText()),passwordTextField.getText()));
            favoritesListModel.addElement(ipTextField.getText()+":"+portTextField.getText());
            //favoritesList.setModel(favoritesListModel);
        }
        dbman.close();
    }

    private void onConnect() {
        if(Tool.isValid(ipTextField.getText(), portTextField.getText(), passwordTextField.getText())) {
            ConnectionManager cman=new ConnectionManager(ipTextField.getText(), portTextField.getText(), passwordTextField.getText());
            if(cman.check()) {
                dispose();
                new MainForm(cman);
            }
            else {
                MessageDialog md=new MessageDialog("Error!","Connection cannot be established!");
            }
        }
    }

}
