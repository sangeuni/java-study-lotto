package view;

import dto.LottoDTO;
import dto.LottoGameDTO;
import util.Rank;

public class ResultView {

    public static void printLotto(LottoDTO lottoDTO) {
        System.out.printf("수동으로 %d개, 자동으로 %d개를 구매했습니다.\n", LottoGameDTO.getManualCount(), LottoGameDTO.getAutoCount());
        for (int i = 0; i < lottoDTO.getLottoList().size(); i++) {
            System.out.println(lottoDTO.getLottoList().get(i).getLotto());
        }
        System.out.println();
    }

    public static void printResult(LottoDTO lottoDTO) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + LottoGameDTO.getLottoGame().getPrizeMoney().get(Rank.FIFTH) + "개");
        System.out.println("4개 일치 (50000원)- " + LottoGameDTO.getLottoGame().getPrizeMoney().get(Rank.FOURTH) + "개");
        System.out.println("5개 일치 (150000원)- " + LottoGameDTO.getLottoGame().getPrizeMoney().get(Rank.THIRD) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30000000원)- " + LottoGameDTO.getLottoGame().getPrizeMoney().get(Rank.SECOND) + "개");
        System.out.println("6개 일치 (200000000원)- " + LottoGameDTO.getLottoGame().getPrizeMoney().get(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + LottoGameDTO.getLottoGame().getProfitRate(LottoGameDTO.getMoney()) + "% 입니다.");
    }
}