import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        // Test uchun boshlanishiga 2 ta mijoz qo'shib qo'yamiz
        bankService.createAccount(new BankAccount("111", "Muhammad", 5000.0));
        bankService.createAccount(new BankAccount("222", "Eshmat", 1000.0));

        System.out.println("=== DEHQON BANK TIZIMIGA XUSH KELIBSIZ ===");

        while (true) {
            System.out.println("\n--- MENYU ---");
            System.out.println("1. Hisob ma'lumotlarini ko'rish");
            System.out.println("2. Pul kiritish (Deposit)");
            System.out.println("3. Pul yechish (Withdraw)");
            System.out.println("4. Pul o'tkazmasi (Transfer)");
            System.out.println("5. Chiqish");
            System.out.print("Amalni tanlang: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Hisob raqamini kiriting: ");
                        String accNum = scanner.nextLine();
                        BankAccount account = bankService.findAccount(accNum);
                        System.out.println("Natija: " + account);
                    }
                    case 2 -> {
                        System.out.print("Hisob raqamini kiriting: ");
                        String accNum = scanner.nextLine();
                        System.out.print("Kiritiladigan summa: ");
                        double amount = scanner.nextDouble();

                        BankAccount account = bankService.findAccount(accNum);
                        account.deposit(amount);
                        System.out.println("🎉 Pul muvaffaqiyatli kiritildi. Yangi balans: " + account.getBalance());
                    }
                    case 3 -> {
                        System.out.print("Hisob raqamini kiriting: ");
                        String accNum = scanner.nextLine();
                        System.out.print("Yechiladigan summa: ");
                        double amount = scanner.nextDouble();

                        BankAccount account = bankService.findAccount(accNum);
                        account.withdraw(amount);
                        System.out.println("🎉 Pul muvaffaqiyatli yechildi. Yangi balans: " + account.getBalance());
                    }
                    case 4 -> {
                        System.out.print("Kimning hisobidan (From): ");
                        String from = scanner.nextLine();
                        System.out.print("Kimning hisobiga (To): ");
                        String to = scanner.nextLine();
                        System.out.print("O'tkazma summasi: ");
                        double amount = scanner.nextDouble();

                        bankService.transfer(from, to, amount);
                    }
                    case 5 -> {
                        System.out.println("Dastur tugatildi. Salomat bo'ling!");
                        System.exit(0);
                    }
                    default -> System.out.println("Xato buyruq! Qaytadan urinib ko'ring.");
                }
            } catch (RuntimeException e) {
                System.out.println("\n⚠️ BANK XATOLIGI: " + e.getMessage());
            }
        }
    }
}