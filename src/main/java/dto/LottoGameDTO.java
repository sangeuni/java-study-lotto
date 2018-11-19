package dto;

import model.LottoGame;

public class LottoGameDTO {
    private static final int LOTTO_PRICE = 1000;
    private static LottoGame lottoGame;
    private static int money;
    private static int manualCount;
    private static int autoCount;

    public LottoGameDTO(LottoGame lottoGame, int money, int manualCount) {
        this.lottoGame = lottoGame;
        this.money = money;
        this.manualCount = manualCount;
        autoCount = countLotto(money) - manualCount;
    }

    public static int getMoney() {
        return money;
    }

    public static LottoGame getLottoGame() {
        return lottoGame;
    }

    public static int getManualCount() {
        return manualCount;
    }

    public static int getAutoCount() {
        return autoCount;
    }

    public int countLotto(int money) {
        return money / LOTTO_PRICE;
    }
}
