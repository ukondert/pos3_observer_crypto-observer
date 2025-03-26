# CryptoObserver

Schreiben Sie eine Software mit der Sie Cryptowährungen beobachten können.

## Klasse CryptoCurrencySubject

Dazu implementieren Sie einen Klasse CryptoCurrencySubject. Diese stellt die Crytowährungen dar. 
Diese sind nach dem Observer-Pattern observable und können beobachtet werden. Implementieren Sie die dazu nötigen Methoden.

Weiters hat jedes CryptoCurrencySubject 2 Atribute:

- name
- rate

## Interface CryptoObserver

Für die Observer Objekte implementieren Sie das CryptoObserver Interface.
In der Update Methode soll das aktuelle CryptoCurrencySubject mit übergeben werden.

```java
public interface CryptoObserver 
{
    public void update(CryptoCurrencySubject ob);
}
```

Als konkrete Observer implementieren Sie 2 Observer:

## CryptoMessageObserver
Der CryptoMessageObserver speichert alle Änderungen durch die update Methode in einer List als String Message. 
Z.B:

```txt
dogecoin changed to 3540.0
```
Überschreiben Sie die toString() Methode, sodass alle Messages ausgegeben werden.

## CryptoMaxRateObserver
Der CryptoMaxRateObserver speichert den maximalen Kurs für jeden Währung die beobachtet wird. Speichern Sie die Werte am besten als 
Key Value Pairs.

überschreiben Sie die toString() Methode, sodass die Namen und jeweiligen maximalen Werte ausgegeben werden.

## Main Methode

Schreiben Sie eine Main Methode bei der Sie aus 4 Verschiedenen Krypto Währungen auswählen können ob sie diese beobachten möchten. 
Beobachten Sie die Messages und den maxValue. Setzen Sie anschließend in einer Schleife die Rate auf 10 verschieden Werte und führen update aus.

## Mögliche Programmabläufe
```txt
Starting the cryto currency observer demo
Are you interested in harmony[Y/N]
N
Are you interested in dogecoin[Y/N]
Y
Observing dogecoin
Are you interested in SushiSwap[Y/N]
N
Are you interested in bluemelCoin[Y/N]
Y
Observing bluemelCoin
My crypto portfolio 
dogecoin changed to 3681.0
bluemelCoin changed to 3386.0
dogecoin changed to 6231.0
bluemelCoin changed to 3664.0
dogecoin changed to 6896.0
bluemelCoin changed to 2446.0
dogecoin changed to 6560.0
bluemelCoin changed to 9806.0
dogecoin changed to 6364.0
bluemelCoin changed to 6418.0
dogecoin changed to 3540.0
bluemelCoin changed to 2551.0
dogecoin changed to 1219.0
bluemelCoin changed to 2158.0
dogecoin changed to 8930.0
bluemelCoin changed to 3714.0
dogecoin changed to 7947.0
bluemelCoin changed to 3267.0
dogecoin changed to 8363.0
bluemelCoin changed to 9354.0

Max Values: 
dogecoin: 8930.0 
bluemelCoin: 9806.0
```
