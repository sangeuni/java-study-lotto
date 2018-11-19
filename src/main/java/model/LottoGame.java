package model;

import util.Rank;

import java.util.*;

public class LottoGame {
    private final static int PRICE = 1000;
    private Map<Rank, Integer> prizeMoney;
    private List<Lotto> lottoList;

    public LottoGame() {
        prizeMoney = new LinkedHashMap<>();
        prizeMoney.put(Rank.FIRST, 0);
        prizeMoney.put(Rank.SECOND, 0);
        prizeMoney.put(Rank.THIRD, 0);
        prizeMoney.put(Rank.FOURTH, 0);
        prizeMoney.put(Rank.FIFTH, 0);
    }

    public Map<Rank, Integer> getPrizeMoney() {
        return prizeMoney;
    }

    public List<Lotto> makeAutoLotto(int autoCount) {
        for (int i = 0; i < autoCount; i++) {
            lottoList.add(new Lotto());
        }
        return lottoList;
    }

    public List<Lotto> makeManualLotto(List<String> manualLottoList, int money) {
        if (money < 0) throw new IllegalArgumentException();
        lottoList = new ArrayList<>(money / PRICE);
        for (String manualLotto : manualLottoList) {
            lottoList.add(new Lotto(manualLotto));
        }
        return lottoList;
    }

    public int countMatchNumber(List<LottoNo> lotto, List<LottoNo> winningNumbers) {
        int count = (int) lotto.stream().filter(winningNumbers::contains).count();
        return count;
    }

    public void setMatchCounts(List<LottoNo> winningNumbers, int bonusBall) {
        for (int i = 0; i < lottoList.size(); i++) {
            int count = countMatchNumber(lottoList.get(i).getLotto(), winningNumbers);
            if (count < 3) continue;
            Rank ranks = Rank.valueOf(count, containsBonusBall(lottoList.get(i), bonusBall));
            int matchCount = (int) prizeMoney.get(ranks);
            matchCount++;
            prizeMoney.put(ranks, matchCount);
        }
    }

    public boolean containsBonusBall(Lotto lotto, int bonusBall) {
        if (lotto.contains(bonusBall)) return true;
        return false;
    }

    public int getProfitRate(int money) {
        int result = 0;
        Set<Rank> set = prizeMoney.keySet();
        Iterator<Rank> rankIterator = set.iterator();
        while (rankIterator.hasNext()) {
            Rank grade = (Rank) rankIterator.next();
            int count = prizeMoney.get(grade);
            result += (grade.getWinningMoney() * count);
        }
        return result / money;
    }
}
