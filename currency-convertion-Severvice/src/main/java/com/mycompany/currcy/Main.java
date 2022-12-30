package com.mycompany.currcy;

import com.cloanto.webservices.currencyserver.CurrencyServer;
import com.cloanto.webservices.currencyserver.CurrencyServerSoap;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private String[] currencies = new String[]{"AED", "AFN", "ALL", "AOA", "ARS", "AUD", "AZN", "BBD", "BDT", "BGN", "BHD", "BND", "BOB", "BRL", "BSD", "BWP", "BYN", "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CVE", "CZK", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "GBP", "GHS", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "INR", "IQD", "ISK", "JMD", "JOD", "JPY", "KES", "KHR", "KMF", "KRW", "KWD", "KZT", "LBP", "LKR", "LYD", "MAD", "MDL", "MKD", "MMK", "MOP", "MRU", "MUR", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "SAR", "SEK", "SGD", "SRD", "THB", "TMT", "TND", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VND", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW"};
    private JFrame frame = new JFrame();
    private JLabel newValueLabel = new JLabel("Result: ");
    private JLabel valueLabel = new JLabel("Enter Your Value");
    private JTextField firsDigit = new JTextField();
    private JTextField secondDigit = new JTextField();
    private JComboBox from = new JComboBox(currencies);
    private JComboBox to = new JComboBox(currencies);
    private JButton convert = new JButton("Calculate");

    private CurrencyServer service;
    private CurrencyServerSoap port;

    Main() {
        service = new CurrencyServer();
        port = service.getCurrencyServerSoap();
        frame.setSize(360, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Currency Convertor");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 320) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 340) / 2);

        valueLabel.setSize(100, 20);
        valueLabel.setLocation(20, 20);
        valueLabel.setVisible(true);
        frame.add(valueLabel);

        firsDigit.setSize(100, 20);
        firsDigit.setLocation(130, 20);
        firsDigit.setVisible(true);
        frame.add(firsDigit);

        from.setSize(70, 20);
        from.setLocation(240, 20);
        from.setVisible(true);
        frame.add(from);

        newValueLabel.setSize(100, 20);
        newValueLabel.setLocation(20, 60);
        newValueLabel.setVisible(true);
        frame.add(newValueLabel);

        secondDigit.setSize(100, 20);
        secondDigit.setLocation(130, 60);
        secondDigit.setVisible(true);
        frame.add(secondDigit);

        to.setSize(70, 20);
        to.setLocation(240, 60);
        to.setVisible(true);
        frame.add(to);

        convert.setSize(200, 40);
        convert.setLocation(60, 100);
        convert.setVisible(true);
        convert.addActionListener(e -> convertMethod());
        frame.add(convert);

    }

    private void convertMethod() {
        if (!firsDigit.getText().equals("")) {
            try {
                String fromCurr = from.getSelectedItem().toString();
                String toCurr = to.getSelectedItem().toString();
                double amount = Double.parseDouble(firsDigit.getText());
                secondDigit.setText(port.convertToStr("", fromCurr, toCurr, amount, true, "", "", ""));
            } catch (Exception ex) {
                secondDigit.setText("0");
            }
        } else {
            firsDigit.setText("0");
            secondDigit.setText("0");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
