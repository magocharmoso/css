package app.controllers;

import app.repository.RestaurantRepository;

public class RestaurantController {

    public static final int NARGSD = 3;
    public static final int NARGSE = 3;
    public static final int NARGSF = 3;
    public static final int NARGSG = 3;

    RestaurantRepository restaurantRepository;

    public RestaurantController() {
        this.restaurantRepository = new RestaurantRepository();
    }

    /**
     * D. Buscar por restaurantes.
     * Pesquisa restaurantes por nome ou por cidade.
     */
    public String d() {
        return "";
    }

    /**
     * E. Criação de restaurantes e gestão do seu estado.
     * Permite criar restaurantes e alternar o seu estado entre aberto e fechado.
     */
    public String e() {
        return "";
    }

    /**
     * F. Adicionar, remover e atualizar produtos no cardápio de um restaurante.
     * Gere os produtos disponíveis no menu de um restaurante.
     */
    public String f() {
        return "";
    }

    /**
     * G. Buscar produtos de um restaurante.
     * Lista os produtos associados ao cardápio de um restaurante.
     */
    public String g() {
        return "";
    }
}
