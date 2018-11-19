package dto;

import model.Lotto;

import java.util.List;

public class LottoDTO {
    private List<Lotto> lottoList;

    public LottoDTO(List<Lotto> lotto) {
        this.lottoList = lotto;
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
