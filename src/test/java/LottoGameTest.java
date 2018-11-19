
import static org.junit.Assert.assertEquals;

import model.Lotto;
import model.LottoGame;
import model.LottoNo;
import org.junit.Before;
import org.junit.Test;
import util.Rank;

import java.util.*;

public class LottoGameTest {
    private LottoGame lottoGame;
    private List<Lotto> lottoList;
    private List<LottoNo> winningNumbers;

    @Before
    public void setUp() {
        lottoGame = new LottoGame();
        lottoList = new ArrayList<>();
        winningNumbers = new ArrayList<>();
        winningNumbers.add(new LottoNo(1));
        winningNumbers.add(new LottoNo(2));
        winningNumbers.add(new LottoNo(3));
        winningNumbers.add(new LottoNo(4));
        winningNumbers.add(new LottoNo(5));
        winningNumbers.add(new LottoNo(6));
    }

    @Test
    public void makeManualLotto_test() {
        int count = 1;
        List<String> manual = new ArrayList<>();
        manual.add("1,2,3,4,15,16");
        List<Lotto> lottoList = lottoGame.makeManualLotto(manual, count);
        assertEquals("[1, 2, 3, 4, 15, 16]", lottoList.get(0).getLotto().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void input_negativeMoney_test() throws Exception {
        List<String> manual = new ArrayList<>();
        manual.add("1,2,3,4,15,16");
        lottoGame.makeManualLotto(manual,-2000);
    }

    @Test
    public void countMatchNumber_test(){
        List<LottoNo> lotto = new ArrayList<>();
        lotto.add(new LottoNo(1));
        lotto.add(new LottoNo(2));
        lotto.add(new LottoNo(3));
        lotto.add(new LottoNo(4));
        lotto.add(new LottoNo(16));
        lotto.add(new LottoNo(17));
        assertEquals(4,lottoGame.countMatchNumber(lotto,winningNumbers));
    }

    @Test
    public void containsBonusBall_test() {
        Lotto lotto = new Lotto("1,2,3,4,15,16");
        int bonusBall = 15;
        assertEquals(true,lottoGame.containsBonusBall(lotto,bonusBall));
    }

    @Test
    public void rank_test(){
       assertEquals(Rank.SECOND,Rank.valueOf(5,true));
    }
}
