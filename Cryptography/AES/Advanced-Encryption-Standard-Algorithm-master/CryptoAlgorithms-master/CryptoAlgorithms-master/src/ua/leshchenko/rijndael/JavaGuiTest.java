package ua.leshchenko.rijndael;
import ua.leshchenko.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class JavaGuiTest {

    public static void main(String[] args) {
        int size=35;
        JLabel nameLab1 = new JLabel("Plaintxt:");
        JLabel nameLab4 = new JLabel("Key:");
        JLabel nameLab2 = new JLabel("Code:");
        JLabel nameLab3 = new JLabel("Plaintxt:");
        nameLab1.setFont(new Font(("宋体bai"),Font.BOLD, size));
        nameLab2.setFont(new Font(("宋体bai"),Font.BOLD, size));
        nameLab3.setFont(new Font(("宋体bai"),Font.BOLD, size));
        nameLab4.setFont(new Font(("宋体bai"),Font.BOLD, size));

        Frame f=new Frame("AES");

        TextField tf=new TextField(20);
        TextField tf2=new TextField(20);

        TextArea ta=new TextArea(10,75);
        TextArea ta2=new TextArea(10,75);
        f.setBounds(400,300,400,300);
        tf.setFont(new Font(("宋体bai"),Font.BOLD, size));
        tf2.setFont(new Font(("宋体bai"),Font.BOLD, size));

        ta.setFont((new Font(("宋体bai"),Font.BOLD,size)));
        ta2.setFont((new Font(("宋体bai"),Font.BOLD,size)));

        Button b=new Button("Encryption");
        Button b1=new Button("CLEAR");
        b.setFont(new Font(("宋体bai"),Font.BOLD, size));
        b1.setFont(new Font(("宋体bai"),Font.BOLD, size));


        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e1) {
                ta2.selectAll();
                ta2.setText(null);
                ta.selectAll();
                ta.setText(null);
                tf.setText("");
                tf2.setText("");
            }
        });



        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
 ////////////////////////////////////////////////////////////////////
                String Plaintxt=tf.getText().trim();
                String Key=tf2.getText().trim();

                byte[] key = Key.getBytes();
                //RC4 encoder = new RC4(key);

                Rijndael encoder = new Rijndael();
                java.util.List<byte[]> chunks = Utils.chunk(Plaintxt.getBytes());
                List<byte[]> encrypted = new ArrayList<>();
                for (byte[] current : chunks) {
                    encrypted.add(encoder.encrypt(key, current));
                }


/////////////////////////////////////
//                //byte[] testBytes=Plaintxt.getBytes();
////
////                //byte[] result = encoder.encode(testBytes, testBytes.length);
////                //////////////////////////////////////////////////////////////
////
////                //RC4 decoder = new RC4(key);
////                byte[] decryptedBytes = decoder.decode(result, result.length);
////                String decryptedTestString=new String(decryptedBytes);
////                try {
////                    decryptedTestString = new String(decryptedBytes, "UTF-8");
////                    System.out.println("明文结果是  >>> " + decryptedTestString);
////                    System.out.println("密钥是>>>"+Key);
////                } catch (Exception e1) {
////                    e1.printStackTrace();
////                }
                String decryptedTestString = "";
                Rijndael decoder = new Rijndael();
                try {

                    for (byte[] temporary : encrypted) {
                        byte[] decryptedBytes = decoder.decrypt(key, temporary);
                        decryptedTestString += new String(decryptedBytes, "UTF-8");
                    }
                    System.out.println("Result value >>> " + decryptedTestString);
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }




                //////////////////////////////////////////////////////////




                //ta.append(new String(result)+"\n");

                //List<byte[]> encrypted = new ArrayList<>();
                for(byte[] T: encrypted){
                    ta.append(new String(T)+"\n");
                }


                //ta2.setFont((new Font(("宋体bai"),Font.BOLD,size)));
                ta2.append(decryptedTestString+"\n");
                //tf.setText(null);
                tf.requestFocus();
            }
        });






        f.add(nameLab1);
        f.add(tf);
        f.add(nameLab4);
        f.add(tf2);
        f.add(b);
        f.add(nameLab2);
        f.add(ta);

        f.add(nameLab3);
        f.add(ta2);

        f.add(b1);
        f.setLayout(new FlowLayout());

        f.setSize(800,900);
        f.setLocation(200,300);
        f.setTitle("AES");
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        f.setLayout(new GridLayout(10, 1));






    }
}
