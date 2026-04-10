package app.ui;

import java.util.Scanner;

import app.controllers.OrderController;
import app.controllers.RestaurantController;
import app.controllers.UserController;

public class Cli {
    // This is a simple CLI for demonstration purposes. 
    public final static String MENU = "A. Login com autentica¸c˜ao (Nota: vamos fazer mock. Qualquer palavra-passe ser´a aceite con-\n" + //
                "tanto que o utilizador seja v´alido).\n" + //
                "B. Registo de utilizadores (Clientes, Administradores e Entregadores).\n" + //
                "C. Verificar, remover e atualizar utilizadores.\n" + //
                "D. Buscar por restaurantes (por nome ou cidade).\n" + //
                "E. Cria¸c˜ao de restaurantes e gest˜ao do seu estado (aberto/fechado).\n" + //
                "F. Adicionar, remover e atualizar produtos no card´apio de um restaurante.\n" + //
                "G. Buscar produtos de um restaurante.\n" + //
                "H. Cria¸c˜ao de um pedido.\n" + //
                "I. Registo e processamento do pagamento associado a um pedido.\n" + //
                "J. Atualiza¸c˜ao do estado do pedido.\n" + //
                "K. Atribui¸c˜ao de um entregador a um pedido\n" + //
                "L. Cancelamento de um pedido";
    private static UserController userController;
    private static RestaurantController restaurantController;
    private static OrderController orderController;

    public static void main(String[] args) {
        System.out.println("Welcome to the Food Delivery System CLI!");
        userController = new UserController();
        restaurantController = new RestaurantController();
        orderController = new OrderController();
        System.out.println(MENU);
        Scanner scanner = new Scanner(System.in);
        

        String msg = scanner.nextLine().trim();
        while (!msg.equalsIgnoreCase("exit")) {
            System.out.print(processMessage(msg));  
            msg = scanner.nextLine().trim();
        }
        System.out.println("Exiting the CLI. Goodbye!");
        scanner.close();
    }

    private static String processMessage(String msg) {
        String[] args = msg.split(" ");
        if (args.length == 0) {
            return "No command entered.\n" + MENU + "\n";
        }
        String command = args[0].toUpperCase();
        switch (command) {
            case "A":
                if(UserController.NARGSA != args.length) {
                    return "Invalid number of arguments for command A. Expected " + UserController.NARGSA + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                    
                    return userController.a(args[1], args[2]);
                }
            case "B":
                if(UserController.NARGSB != args.length) {
                    return "Invalid number of arguments for command B. Expected " + UserController.NARGSB + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return userController.b(args[1], args[2], args[3]);
                }
            case "C1":
                if(UserController.NARGSC1 != args.length) {
                    return "Invalid number of arguments for command C1. Expected " + UserController.NARGSC1 + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return userController.c1(args[1]);
                }
            case "C2":
                if(UserController.NARGSC2 != args.length) {
                    return "Invalid number of arguments for command C2. Expected " + UserController.NARGSC2 + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return userController.c2();
                }
            case "C3":
                if(UserController.NARGSC3 != args.length) {
                    return "Invalid number of arguments for command C3. Expected " + UserController.NARGSC3 + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return userController.c3();
                }
            case "D":
                if(RestaurantController.NARGSD != args.length) {
                    return "Invalid number of arguments for command D. Expected " + RestaurantController.NARGSD + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return restaurantController.d();
                }
            case "E":
                if(RestaurantController.NARGSE != args.length) {
                    return "Invalid number of arguments for command E. Expected " + RestaurantController.NARGSE + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return restaurantController.e();
                }
            case "F":
                if(RestaurantController.NARGSF != args.length) {
                    return "Invalid number of arguments for command F. Expected " + RestaurantController.NARGSF + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return restaurantController.f();
                }
            case "G":
                if(RestaurantController.NARGSG != args.length) {
                    return "Invalid number of arguments for command G. Expected " + RestaurantController.NARGSG + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return restaurantController.g();
                }
            case "H":
                if(OrderController.NARGSH != args.length) {
                    return "Invalid number of arguments for command H. Expected " + OrderController.NARGSH + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return orderController.h();
                }
            case "I":
                if(OrderController.NARGSI != args.length) {
                    return "Invalid number of arguments for command I. Expected " + OrderController.NARGSI + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return orderController.i();
                }
            case "J":
                if(OrderController.NARGSJ != args.length) {
                    return "Invalid number of arguments for command J. Expected " + OrderController.NARGSJ + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return orderController.j();
                }
            case "K":
                if(OrderController.NARGSK != args.length) {
                    return "Invalid number of arguments for command K. Expected " + OrderController.NARGSK + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return orderController.k();
                }
            case "L":
                if(OrderController.NARGSL != args.length) {
                    return "Invalid number of arguments for command L. Expected " + OrderController.NARGSL + ", got " + args.length + ".\n" + MENU + "\n";
                }else {
                   
                    return orderController.l();
                }
            default:
                return "Unknown command: " + command + "\n" + MENU + "\n";  
    }
}
}