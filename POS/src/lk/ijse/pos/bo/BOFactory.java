package lk.ijse.pos.bo;

import lk.ijse.pos.dao.SuperDAO;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{
        CUSTOMER, ITEM, ORDER
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new PurchaseOrderBOImpl();
            default:
                return null;
        }
    }
}
