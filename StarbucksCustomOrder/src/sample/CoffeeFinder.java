package sample;

/** 対象のコーヒーを探すためのクラス */
public interface CoffeeFinder {
    Coffee find(Sweetness sweetness, Hotness hotness);
}
