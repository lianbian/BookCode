package chapter3;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class page103 {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 8个练习题
        // 1. 找出2011年发生的所有交易，并按照交易额排序（从低到高）
        List<Transaction> transactions1 =
                transactions.stream()
                        .filter(x -> x.getYear() == 2011)
                        .sorted(Comparator.comparing(Transaction::getValue))
                        .collect(Collectors.toList());

        // 2. 交易员都在哪些不同的城市呆过
        List<String> citys = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());


        Set<String> citys2 = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .collect(Collectors.toSet());

        // 3. 查找所有来自剑桥的交易员，并按照姓名排序
        List<Trader> traders = transactions.stream()
                            .map(Transaction::getTrader)
                            .filter(x -> x.getCity().equals("Cambridge"))
                            .distinct()
                            .sorted(Comparator.comparing(Trader::getName))
                            .collect(Collectors.toList());
    }
}

@Data
class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

@Data
class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}