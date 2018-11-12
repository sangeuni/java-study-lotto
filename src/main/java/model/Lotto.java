package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto = new ArrayList();
    private int matchCount = 0;

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setNumber() {
        for (int i = 0; i < 6; i++) {
            this.lotto.add(i, generateLottoList().get(i));
        }
    }

    public List<Integer> getLottoNumber() {
        return this.lotto;
    }

    public List<Integer> generateLottoList() {
        List<Integer> lottoList = new ArrayList();
        List<Integer> lotto = new ArrayList();
        for (int i = 1; i <= 45; i++) {
            lottoList.add(i);
        }
        Collections.shuffle(lottoList);
        for (int i = 0; i < 6; i++) {
            lotto.add(i, lottoList.get(i));
        }
        Collections.sort(lotto);
        return lotto;
    }

}
