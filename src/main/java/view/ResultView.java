package view;

import dto.LottoDTO;
import model.LottoGame;

public class ResultView {

    public static void printLotto(LottoDTO lotto) {

        System.out.println(lotto.getLotto().size() + "개를 구매했습니다.");
        for (int i = 0; i < lotto.getLotto().size(); i++) {
            System.out.println(lotto.getLotto().get(i).getLottoNumber());
        }
        System.out.println();
    }

    public static void printResult(LottoGame lottoGame, LottoDTO lotto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + lottoGame.getPrizeLottoList()[3] + "개");
        System.out.println("4개 일치 (50000원)- " + lottoGame.getPrizeLottoList()[2] + "개");
        System.out.println("5개 일치 (150000원)- " + lottoGame.getPrizeLottoList()[1] + "개");
        System.out.println("6개 일치 (200000000원)- " + lottoGame.getPrizeLottoList()[0] + "개");
        System.out.println("총 수익률은 " + lottoGame.getProfitRate(lotto.getLotto()) + "% 입니다.");
    }
}