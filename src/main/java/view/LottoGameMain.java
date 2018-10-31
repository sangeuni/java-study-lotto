package view;

import dto.LottoDTO;
import model.Lotto;
import model.LottoGame;

import java.util.List;

public class LottoGameMain {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.inputMoney());
        List<Lotto> lottoList = lottoGame.makeLotto();
        LottoDTO lottoDTO = new LottoDTO(lottoList);
        ResultView.printLotto(lottoDTO);
        List<Integer> winningNumbers = lottoGame.toWinningNumbersList(InputView.inputNumbers());
        lottoGame.setMatchCounts(lottoList, winningNumbers);
        ResultView.printResult(lottoGame, lottoDTO);

    }
}
