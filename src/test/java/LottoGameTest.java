
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import model.Lotto;
import model.LottoGame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LottoGameTest {
    private LottoGame lottoGame = new LottoGame(3000);
    private List<Lotto> lottoList;
    private List<Integer> lotto;
    private List<Integer> winningNumbers;

    @Test
    public void makeLotto_test(){
        List<Lotto> lottoList1 = lottoGame.makeLotto();
        assertNotNull(lottoList1);
    }

    @Test
    public void toArrayList_test() {
        lottoGame = new LottoGame(1000);
        String numbers = "1, 2, 3, 4, 5, 6";
        List<Integer> list = lottoGame.toWinningNumbersList(numbers);
        assertEquals("[1, 2, 3, 4, 5, 6]", list.toString());
    }

    @Test
    public void countMatchNumber_test() {
        lotto = new ArrayList<>();
        winningNumbers = new ArrayList<>();
        lotto.add(1);
        lotto.add(2);
        lotto.add(3);
        lotto.add(4);
        lotto.add(5);
        lotto.add(6);
        winningNumbers.add(4);
        winningNumbers.add(5);
        winningNumbers.add(6);
        winningNumbers.add(7);
        winningNumbers.add(8);
        winningNumbers.add(9);
        assertEquals(3, lottoGame.countMatchNumber(lotto, winningNumbers));
    }

    @Test
    public void getResult_test(){
        lottoList = new ArrayList<>(3);
        for(int i=0;i<lottoList.size();i++)
        {
            lottoList.get(i).setMatchCount(3);
        }
        assertEquals(500, lottoGame.getProfitRate(lottoList));
    }

}
