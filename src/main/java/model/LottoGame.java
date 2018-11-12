package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int PRICE = 1000;
    private int totalPrice;
    private List<Lotto> lottoList;
    private List<Integer> winningNumbers;
    private Map<Integer, Integer> prizeMoney;
    private int[] prizeLottoList = new int[4];

    public LottoGame(int totalPrice) {
        this.totalPrice = totalPrice;
        prizeMoney = new HashMap<>();
        prizeMoney.put(3, 5000);
        prizeMoney.put(4, 50000);
        prizeMoney.put(5, 150000);
        prizeMoney.put(6, 200000000);
    }

    public List<Lotto> makeLotto() {
        int times = totalPrice / PRICE;
        lottoList = new ArrayList<>(times);
        for (int i = 0; i < times; i++) {
            lottoList.add(i, new Lotto());
            lottoList.get(i).setNumber();
        }
        return lottoList;
    }

    public List<Integer> toWinningNumbersList(String numbers) {
        winningNumbers = new ArrayList<>();
        String[] token = numbers.split(",");
        for (String number : token) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }

    public int countMatchNumber(List<Integer> lotto, List<Integer> winningNumbers) {
        int count = (int) lotto.stream().filter(winningNumbers::contains).count();
        return count;
    }

    public void setMatchCounts(List<Lotto> lottoList, List<Integer> winningNumbers) {
        for (int i = 0; i < lottoList.size(); i++) {
            lottoList.get(i).setMatchCount(countMatchNumber(lottoList.get(i).getLottoNumber(), winningNumbers));
            setPrizeLottoList(i);

        }
    }

    public void setPrizeLottoList(int index) {

        if (lottoList.get(index).getMatchCount() == 3)
            prizeLottoList[3]++;
        if (lottoList.get(index).getMatchCount() == 4)
            prizeLottoList[2]++;
        if (lottoList.get(index).getMatchCount() == 5)
            prizeLottoList[1]++;
        if (lottoList.get(index).getMatchCount() == 6)
            prizeLottoList[0]++;
    }

    public int[] getPrizeLottoList() {
        return this.prizeLottoList;
    }

    public int getProfitRate(List<Lotto> lottoList) {
        int result = 0;
        for (Lotto lotto : lottoList) {
            if (prizeMoney.containsKey(lotto.getMatchCount())) {
                result += prizeMoney.get(lotto.getMatchCount());
            }
        }
        return (result / totalPrice) * 100;
    }
}
