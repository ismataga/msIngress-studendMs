package com.ingress.desingpatterns.Factory;

public class Main {
    public static void main(String[] args) {
        Restaurant beefRestaurant = new BeefBurgerRestaurant();
        Burger beefBurger=beefRestaurant.orderBurger();

        Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
        Burger veggieBurger=veggieRestaurant.orderBurger();
    }
}
