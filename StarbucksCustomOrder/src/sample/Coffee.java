package sample;

/** コーヒーを表すクラス */
public interface Coffee {
    Sweetness getSweetness();
    Hotness getHotness();
    CoffeeId getId();
}
