package edu.vsu.ru.project;

public class Main {

    public static void main(String[] args) throws Exception {
        GUI_Main.winMain();





        MyLinkedList<Integer> beginList = new MyLinkedList<>();

        beginList.addLast(1);
        beginList.addLast(2);
        beginList.addLast(3);
        beginList.addLast(44);
        beginList.addLast(55);
        beginList.addLast(66);
        beginList.addLast(777);
        beginList.addLast(888);
        beginList.addLast(999);

        MyLinkedList<Integer> sortList = beginList.convert();

        int i = 0;
        for (Integer v:sortList) {
            System.out.print((i > 0 ? "," : "") + v);
            i++;
        }
        /*for (Integer v : list) {

    }
    for (Iterator iterator = list.iterator(); iterator.hasNext(); ) {
        int v = iterator.next();
    }*/
    }
}
