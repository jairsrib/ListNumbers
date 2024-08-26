package br.ulbra.bonus;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Numbers {

    private int number;
    public ArrayList<Integer> list;

    public Numbers() {
        list = new ArrayList();
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
// add / save

    public ArrayList<Integer> getList() {
        return list;
    }

    /*if (list.contains(element)) {
            JOptionPane.showMessageDialog(null, "Number already setted.");
        }*/
    public static void addToList(ArrayList<Integer> list, Object element) {
        if (element instanceof Integer) {
            Integer number = (Integer) element;
            if (list.contains(number)) {
                JOptionPane.showMessageDialog(null, "Number already added.");
            } else {
                list.add(number);
                JOptionPane.showMessageDialog(null, "Added successfully.");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Enter a valid number.");
        }
    }

//list all
    public String listAll() {
        String element = "List of Numbers \n";
        if (list.isEmpty()) {
            return "List is empty.";
        } else {
            for (int i = 0; i < list.size(); i++) {
                element += (i + 1) + " - " + list.get(i) + "\n";
            }
        }
        return element;
    }

//list just even numbers
    public String listEven() {
        StringBuilder element = new StringBuilder("List of Even Numbers: \n");
        for (int num : list) {
            if (num % 2 == 0) {
                element.append(num).append("\n");
            }
        }
        return element.toString();
    }

//list just odd numbers
    public String listOdd() {
        StringBuilder element = new StringBuilder("List of Odd Numbers: \n");
        for (int num : list) {
            if (num % 2 != 0) {
                element.append(num).append("\n");
            }
        }
        return element.toString();
    }
//alter the element of the number

    public void update(int i, int newNumber) {
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "List is empty.");
        } else if (i > list.size() || i < 0) {
            JOptionPane.showMessageDialog(null, "Non-existent number.");
        } else {
            list.set(i, newNumber);
        }
    }
//remove a number

    public void remove(int i) {
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "list is empty");

        } else if (i >= list.size() || i < 0) {
            JOptionPane.showMessageDialog(null, "non-existent task");

        } else {
            list.remove(i);
            JOptionPane.showMessageDialog(null, "deleted sucessfully");
        }
    }
//search for a number

    public void check(int i) {
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "List is empty.");
        } else if (i > list.size() || i < 0) {
            JOptionPane.showMessageDialog(null, "Non-existent number.");
        } else {
            list.get(i);
        }
    }
//verify if is valid, if it is calculate the media

    public double media() {
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "List is empty.");
            return 0;
        }
        double sum = 0;
        for (int num : list) {

            sum += num;
        }
        return sum / list.size();

    }
//get the min and max NUMBER, using if, to select to search for min or max 

    public void minMax() {
        int i;
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You don't have neither a minimum nor a maximum number.");
        } else {
            Object[] options = {"Minimum", "Maximum"};
            int order;
            order = JOptionPane.showOptionDialog(null,
                    "How you want to sort?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    options,
                    options[0]);
            if (order == JOptionPane.YES_OPTION) {
                Object[] options1 = {"Index", "Element"};
                int code1;
                code1 = JOptionPane.showOptionDialog(null,
                        "Minimum index or element?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        options1,
                        options1[0]);
                if (code1 == JOptionPane.YES_OPTION) {//minimum index
                    JOptionPane.showMessageDialog(null, "Minimum index: " + list.get(i = 0));
                } else {//minimum number
                    JOptionPane.showMessageDialog(null, "Minimum value: " + Collections.min(list));

                }
            } else {
                Object[] options2 = {"Index", "Element"};
                int code1;
                code1 = JOptionPane.showOptionDialog(null,
                        "Maximum index or element?",
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        options2,
                        options2[0]);
                if (code1 == JOptionPane.YES_OPTION) {//maximum index
                    for (i = 0; i < list.size(); i++) {
                        JOptionPane.showMessageDialog(null, "Maximum index: " + i);
                    }
                } else {//maximum number
                    JOptionPane.showMessageDialog(null, "Maximum value: " + Collections.max(list)
                    );
                }
            }
        }
    }
//list directions, choose ascending or descending 

    public void directions(int i) {

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You can't set a direction, your list is empty.");
        } else {
            Object[] options = {"Ascending", "Descending"};
            int order;
            order = JOptionPane.showOptionDialog(null,
                    "How you want to sort?",
                    "Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null,
                    options,
                    options[0]);
            if (order == JOptionPane.YES_OPTION) {
                list.sort(null);
            } else {
                Collections.sort(list, Collections.reverseOrder());
            }

        }

    }

}
