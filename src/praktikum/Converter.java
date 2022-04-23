package praktikum;

public class Converter {
    double rateUSD;
    double rateEUR;
    double rateJPY;
    double rateCHF;
    double rateCNY;
    double rateBTC;
    double rateETH;

    Converter(double usd, double eur, double jpy, double chf, double cny, double btc, double eth) {
        rateUSD = usd;
        rateEUR = eur;
        rateJPY = jpy;
        rateCHF = chf;
        rateCNY = cny;
        rateBTC = btc;
        rateETH = eth;
    }

    void convert(double rubles, int currency) {
        if (currency == 1)
            System.out.println("Ваши сбережения в долларах: " + rubles / rateUSD);
        else if (currency == 2)
            System.out.println("Ваши сбережения в евро: " + rubles / rateEUR);
        else if (currency == 3)
            System.out.println("Ваши сбережения в иенах: " + rubles / rateJPY);
        else if (currency == 4)
            System.out.println("Ваши сбережения в франках: " + rubles / rateCHF);
        else if (currency == 5)
            System.out.println("Ваши сбережения в юанях: " + rubles / rateCNY);
        else
            System.out.println("Неизвестная валюта.");
    }

    void convertToCrypto(double money, int currency) {
        if(currency == 1)
            System.out.println("Ваш кошелёк составит: " + money / rateBTC + " BTC.");
        else if(currency == 2)
            System.out.println("Ваш кошелёк составит: " + money / rateETH + " ETH.");
        else
            System.out.println("Неизвестная криптовалюта");
    }
}
