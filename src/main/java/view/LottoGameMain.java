package view;

import dto.LottoDTO;
import dto.LottoGameDTO;
import model.Lotto;
import model.LottoGame;
import model.WinningLotto;

import java.util.List;

public class LottoGameMain {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int money = InputView.inputMoney();
        int count = InputView.inputManualLottoCount();
        List<Lotto> lottoList = lottoGame.makeManualLotto(InputView.inputManualLotto(count), money);
        lottoGame.makeAutoLotto(new LottoGameDTO(lottoGame, money, count).getAutoCount());
        ResultView.printLotto(new LottoDTO(lottoList));
        lottoGame.setMatchCounts(new WinningLotto(InputView.inputWinningNumbers()).getWinningLotto(), InputView.inputBonusBall());
        ResultView.printResult(new LottoDTO(lottoList));

    }
}
