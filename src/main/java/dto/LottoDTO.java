package dto;

import model.Lotto;

import java.util.List;

public class LottoDTO {
    private List<Lotto> lotto;
    private int matchCount;

    public LottoDTO(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public List<Lotto> getLotto() {
        return this.lotto;
    }

    public void setMatchCount(int matchCount) {
        this.matchCount = matchCount;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
