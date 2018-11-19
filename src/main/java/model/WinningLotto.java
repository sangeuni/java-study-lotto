package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningLotto {
    private static final int LOTTO_SIZE = 6;
    private List<LottoNo> winningLotto;

    public WinningLotto(String numbers) {
        winningLotto = new ArrayList<>(LOTTO_SIZE);
        setWinningLotto(toWinningLottoList(numbers));
    }

    public List<LottoNo> toWinningLottoList (String numbers){
        List<LottoNo> winningNumbers = new ArrayList();
        for (String number : numbers.split(",")) {
            winningNumbers.add(new LottoNo(Integer.parseInt(number)));
        }
        return winningNumbers;
    }

    public void setWinningLotto(List<LottoNo> lotto){
        winningLotto = lotto;
    }

    public List<LottoNo> getWinningLotto(){
        return winningLotto;
    }
}
