/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author d
 */
import java.awt.event.*;
import javax.swing.*;

public class TableActions extends JFrame
{
    public TableActions()
    {
        JTable table = new JTable(15, 5)
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
              return column % 2 == 0;
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        //  Have the enter key work the same as the tab key

        KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
        im.put(enter, im.get(tab));
        
        //  Disable the right arrow key
        KeyStroke right = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
        im.put(right, "none");

        //  Override the default tab behaviour
        //  Tab to the next editable cell. When no editable cells goto next cell.

        final Action oldTabAction = table.getActionMap().get(im.get(tab));
        Action tabAction = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                oldTabAction.actionPerformed( e );
                JTable table = (JTable)e.getSource();
                int rowCount = table.getRowCount();
                int columnCount = table.getColumnCount();
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();

            
                    column += 1;

                    if (column == columnCount)
                    {
                        column = 0;
                        row +=1;
                    }

                    if (row == rowCount)
                    {
                        row = 0;
                    }

                    //  Back to where we started, get out.

                    if (row == table.getSelectedRow()
                    &&  column == table.getSelectedColumn())
                    {
                        //break;
                    }
                

                table.changeSelection(row, column, false, false);
            }
        };
        table.getActionMap().put(im.get(tab), tabAction);
    }

    public static void main(String[] args)
    {
        TableActions frame = new TableActions();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}