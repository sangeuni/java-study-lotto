package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.");
        int money = scanner.nextInt();
        return money;
    }

    public static String inputNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return scanner.next();
    }

}

