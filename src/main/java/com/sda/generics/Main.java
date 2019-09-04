package com.sda.generics;


import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // declarare tip generic - nivel pre java7
        List<String> strings = new LinkedList<String>();

        //declarare tip generic - nivel post Java 7
        // List<String> string = new LinkedList<>();

        String text = "asd";

        int numar = 1;

        strings.add(text);
//        strings.add(numar); // eroare de comilare datorita tipului generic

        List listaDeStringuri = new LinkedList();
        listaDeStringuri.add(text);
        System.out.println(listaDeStringuri.get(0));
        listaDeStringuri.add(numar);
        System.out.println(listaDeStringuri.get(1));
        Object o = listaDeStringuri.get(1);
//        String s = (String) listaDeStringuri.get(1);

        System.out.println("===========================");

        Car car = new Car(150);
        Box<Object> box = new Box<>(car);

        Object object = box.getObject();
        Car object1 = (Car) object;
        object1.getMaxSpeed();

        Box<Car> carBox = new Box<>(car);
        Car carRetrieved = carBox.getObject();

        GenericBox<AVehicle> genericBox= new GenericBox<>(car);
        AVehicle vehicle=genericBox.getT();
        GenericBox<String> stringGenericBox=new GenericBox<>(new String("asd"));
        String string=stringGenericBox.getT();

        Car dacia=new Car(180);
        Car audiA3=new Car(197);

        int compareResult=dacia.compareTo(audiA3);
        if(compareResult<0){
            System.out.println("Audi e mai rapid");
        }else if(compareResult>0){
            System.out.println("Dacia e mai rapida");
        }else{
            System.out.println("Vitezele sunt egale");
        }

        //se asteapta la copil al lui AVehicle
        //Consumer
        GenericBox<? extends AVehicle> garaj1=new GenericBox<Car>(dacia);

        //se asteapta la un parinte al lui Car
        //Producer
        GenericBox<? super Car> garaj2=new GenericBox<AVehicle>(audiA3);
        Car ferarri=new Car(320);
//        garaj1.setT(ferarri);
        garaj2.setT(ferarri);


    }
}
