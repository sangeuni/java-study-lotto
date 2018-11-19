package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return scanner.nextInt();
    }

    public static List<String> inputManualLotto(int count) {
        List<String> manualLottoList = new ArrayList<>(count);
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        for (int i = 0; i < count; i++) {
            manualLottoList.add(scanner.next());
        }
        return manualLottoList;
    }

    public static String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return scanner.next();
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해주세요. ");
        return scanner.nextInt();
    }
}

