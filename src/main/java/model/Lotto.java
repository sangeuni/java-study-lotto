package model;

import java.util.*;

public class Lotto {
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private List<LottoNo> lotto;


    public Lotto() {
        lotto = generateLottoList();
    }

    public Lotto(String manualNumbers) {
        lotto = new ArrayList<>();
        for (String number : manualNumbers.split(",")) {
            lotto.add(new LottoNo(Integer.parseInt(number)));
        }
        if (lotto.size() < LOTTO_SIZE) throw new InputMismatchException();
    }

    public List<LottoNo> getLotto() {
        return this.lotto;
    }

    public List<LottoNo> generateLottoList() {
        List<LottoNo> lottoList = new ArrayList<>();
        List<LottoNo> lotto = new ArrayList<>();
        for (int i = FIRST_LOTTO_NUMBER; i <= LAST_LOTTO_NUMBER; i++) {
            lottoList.add(new LottoNo(i));
        }
        Collections.shuffle(lottoList);
        for (int i = 0; i < LOTTO_SIZE; i++) {
            lotto.add(i, lottoList.get(i));
        }
        Collections.sort(lotto, new Comparator<LottoNo>() {
            @Override
            public int compare(LottoNo o1, LottoNo o2) {
                if (o1.getNumber() < o2.getNumber()) {
                    return -1;
                } else if (o1.getNumber() > o2.getNumber()) {
                    return 1;
                }
                return 0;
            }
        });
        return lotto;
    }

    public boolean contains(int bonusBall) {
        for (LottoNo ball : lotto) {
            int number = Integer.parseInt(ball.toString());
            if (number == bonusBall) return true;
        }
        return false;
    }
}
