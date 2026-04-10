package app.controllers;

import app.repository.OrderRepository;

public class OrderController {

    public static final int NARGSH = 3;
    public static final int NARGSI = 3;
    public static final int NARGSJ = 3;
    public static final int NARGSK = 3;
    public static final int NARGSL = 3;

    OrderRepository orderRepository;

    public OrderController() {
        this.orderRepository = new OrderRepository();
    }

    /**
     * H. Criação de um pedido.
     * Cria um novo pedido a partir dos dados recebidos.
     */
    public String h() {
        return "";
    }

    /**
     * I. Registo e processamento do pagamento associado a um pedido.
     * Regista o pagamento e executa o processamento do valor do pedido.
     */
    public String i() {
        return "";
    }

    /**
     * J. Atualização do estado do pedido.
     * Atualiza o ciclo de vida do pedido, por exemplo de pendente para em curso ou entregue.
     */
    public String j() {
        return "";
    }

    /**
     * K. Atribuição de um entregador a um pedido.
     * Associa um entregador disponível a um pedido específico.
     */
    public String k() {
        return "";
    }

    /**
     * L. Cancelamento de um pedido.
     * Permite cancelar um pedido que ainda esteja elegível para cancelamento.
     */
    public String l() {
        return "";
    }
}
